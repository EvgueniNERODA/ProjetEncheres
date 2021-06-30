package fr.eni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;
import fr.eni.outils.BusinessException;

/**
 * Servlet implementation class ServletDesinscription
 */
@WebServlet("/ServletDesinscription")
public class ServletDesinscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
/**************************************************DO-GET*****************************************************************/ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
/**************************************************DO-POST*****************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//------> On arrive dans la ServletDesincription après avoir cliqué sur supprimer mon compte dans modifProfil.jsp <--------//
		
		request.setCharacterEncoding("UTF-8");
		
		
	//______________________________________________RECUPERATION SESSION________________________________________________
		
		HttpSession session = request.getSession(false);
		
		int idUtilisateur = (int)session.getAttribute("noUtilisateur");	
		
		
		
	//________________________________________________UPDATE-DESACTIVE-USER______________________________________________
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		//On stocke l'utilisateur en session dans une nouvelle variable utilisateur.
		Utilisateur utilisateur;
		try {
			utilisateur = utilisateurManager.find_user(idUtilisateur);
		
				//Si Administrateur
				//if(utilisateurManager.find_user(idUtilisateur).isAdministrateur() == true) {
				//On fait un appel à une méthode Delete afin de supprimer l'utilisateur présent en BDD
				//utilisateurManager.delete_by_id(utilisateurAdmin);}
			
			//On fait appel à une méthode Update qui désactive le compte de l'utilisateur en mettant son etat statut à false.
			boolean nouveauStatut = false;
			utilisateurManager.update_statut_user(utilisateur, nouveauStatut);
			//On update le utilisateur avec le nouveau statut
			utilisateurManager.update_by_id(utilisateur);
			//Destruction de la session
			session.invalidate();
		
		} catch (BusinessException e) {
			
			e.printStackTrace();
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}
		
	//_______________________________________REDIRECTION VERS LA PAGE D'ACCUEIL___________________________________________
		boolean compteSupprime = true;
		request.setAttribute("compteSupprime", compteSupprime);	
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		//rd.forward(request, response);
		response.sendRedirect("./ServletAccueil");
	}

}

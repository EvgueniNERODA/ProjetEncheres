package fr.eni.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.manager.StatusTransformer;

import fr.eni.bll.CategorieManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Categorie;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**************************************************DO-GET*****************************************************************/	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CategorieManager manager = new CategorieManager();
		// séléction des catégories présentes en BDD
		

		List<Categorie> listesCategories = CategorieManager.getInstance().selectCategories();
		System.out.println(listesCategories);
		
		int pos = listesCategories.indexOf("Ameublement");
		System.out.println(pos);
		request.setAttribute("listesCategories", listesCategories);
		

		// renvoi vers la page Accueil
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		rd.forward(request, response);
	}

/**************************************************DO-POST*****************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On arrive dans la méthode POST après avoir cliqué sur supprimer mon compte dans modifProfil.jsp
		request.setCharacterEncoding("UTF-8");
		
		//On récupère la session
		HttpSession session = request.getSession();
		int idUtilisateur = (int)session.getAttribute("noUtilisateur");	
		
	/**********************************************METHODE-DO-POST-UPDATE-DESACTIVE-USER**************************************/
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		//On stocke l'utilisateur en session dans une nouvelle variable utilisateur.
		Utilisateur utilisateur = utilisateurManager.find_user(idUtilisateur);
				//Si Administrateur
				//if(utilisateurManager.find_user(idUtilisateur).isAdministrateur() == true) {
				//On fait un appel à une méthode Delete afin de supprimer l'utilisateur présent en BDD
				//utilisateurManager.delete_by_id(utilisateurAdmin);}
			
		//On fait appel à une méthode Update qui désactive le compte de l'utilisateur en mettant son etat statut à false.
		boolean nouveauStatut = false;
		utilisateurManager.update_statut_user(utilisateur, nouveauStatut);
		//On update le utilisateur avec le nouveau statut
		utilisateurManager.update_by_id(utilisateur);
		
		//DESTRUCTION DE LA SESSION
		session.invalidate();
		
		//REDIRECTION VERS LA PAGE D'ACCUEIL
		response.sendRedirect("ServletAccueil");
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		//rd.forward(request, response);
	}

}

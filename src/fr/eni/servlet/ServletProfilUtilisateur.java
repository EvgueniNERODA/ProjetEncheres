package fr.eni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ServletProfilUtilisateur
 */
@WebServlet("/ServletProfilUtilisateur")
public class ServletProfilUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Utilisateur utilisateur = new Utilisateur();
	private static UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
	
/**************************************************DO-GET*****************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	//------------------> On arrive dans la ServletProfilUtilisateur depuis l'AccueilConnecte.jsp <----------------------//
	//------------------------------Via un clique sur le lien du nom du vendeur de l'enchère-----------------------------//
		
	//______________________________________________RECUPERATION SESSION________________________________________________
		
		HttpSession session = request.getSession(false);
			
	//________________________________________VERIFICATION UTILISATEUR CONNECTÉ_________________________________________
		if (session != null) {
						
			try {
				//Selectionner l'enchere (avec les infos du vendeur)
				//Selectionner le vendeur et retourner ses infos
				int idUtilisateur = (int) session.getAttribute("noUtilisateur");
				utilisateur = utilisateurManager.find_user(idUtilisateur);
				//redirection vers ProfilUtilisateur.jsp
				request.setAttribute("utilisateur", utilisateur);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ProfilUtilisateur.jsp");
				rd.forward(request, response);
			} catch (BusinessException e) {
				
			e.printStackTrace();
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			}

		}else {
			//redirection vers Accueil.jsp
			boolean sessionDeconnecte = true;
			request.setAttribute("sessionDeconnecte", sessionDeconnecte);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
			rd.forward(request, response);
		}
			
	}
	
	

/**************************************************DO-POST*****************************************************************/	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

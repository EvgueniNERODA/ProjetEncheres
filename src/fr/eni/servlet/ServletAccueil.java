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

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**************************************************DO-GET*****************************************************************/	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		System.out.println(idUtilisateur);
	/**********************************************METHODE-DO-POST-DELETE**************************************/
		
		Utilisateur utilisateur = new Utilisateur(idUtilisateur);
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		//Variable pour affichage message compte supprimé
		boolean existeEnBdd = true;
		
		//On fait un appel à une méthode Delete afin de supprimer l'utilisateur présent en BDD
		utilisateurManager.delete_by_id(utilisateur);
		
		System.out.println(utilisateurManager.find_user(idUtilisateur));
		//Vérifier que l'utilisateur à bien été supprimé 
		if (utilisateurManager.find_user(idUtilisateur) == null) {
			existeEnBdd = false;
		}
		
		//Destruction de la session
		session.invalidate();
		
		//Redirection vers la page d'acceuil avec affichage d'un message que l'utilisateur à bien été supprimé
		request.setAttribute("existeEnBdd", existeEnBdd);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		rd.forward(request, response);
	}

}

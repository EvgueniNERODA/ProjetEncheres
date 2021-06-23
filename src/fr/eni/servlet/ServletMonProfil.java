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
 * Servlet implementation class ServletMonProfil
 */
@WebServlet("/ServletMonProfil")
public class ServletMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Utilisateur utilisateur = new Utilisateur();
	private static UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
       
       
/**************************************************DO-GET*****************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On arrive dans la ServletMonProfil depuis l'AccueilConnecte.jsp 
		//On récupère la session en cours 
		Utilisateur utilisateur = new Utilisateur();
		HttpSession session = request.getSession();
		int idUtilisateur = (int) session.getAttribute("noUtilisateur");
		utilisateur = utilisateurManager.find_user(idUtilisateur);
	
		//On envoie l'utilisateur vers MonProfil.jsp et on se redirige dessus
		request.setAttribute("utilisateur", utilisateur);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/MonProfil.jsp");
		rd.forward(request, response);
	}

/**************************************************DO-POST*****************************************************************/	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

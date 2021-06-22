package fr.eni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On passe dans la ServletConnexion depuis l'Accueil.jsp vers Connexion.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// On récupère l'identifiant(mail ou pseudo) et le mdp de Connexion.jsp 
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		// On vérifie si l'utilisateur existe en BDD
		
		// Si oui on redirige l'utilisateur vers la page d'acceuil (version connecté)
		// Si non on redirige sur Connexion.jsp avec un message d'erreur (mauvais mdp ou identifiant inconnu)
		
		doGet(request, response);
	}

}

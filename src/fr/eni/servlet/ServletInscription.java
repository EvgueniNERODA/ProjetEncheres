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
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//force l'encodage en UTF8 pour ne pas avoir de problèmes d'encodage dans la BDD
		request.setCharacterEncoding("UTF-8");
		
		String pseudo = "";
		String prenom = "";
		String telephone = "";
		String codePostal = "";
		String password = "";
		String nom = "";
		String email = "";
		String rue = "";
		String ville = "";
		String confirmPassword = "";
		boolean verifPseudo = false;
		boolean verifMail = false;
		
		//récupération saisie utilisateur
		pseudo = request.getParameter("pseudo");
		prenom = request.getParameter("prenom");
		telephone = request.getParameter("tel");
		codePostal = request.getParameter("cp");
		password = request.getParameter("password");
		nom = request.getParameter("nom");
		email = request.getParameter("email");
		rue = request.getParameter("rue");
		ville = request.getParameter("ville");
		confirmPassword = request.getParameter("conf");
		

		
		
		try {
			UtilisateurManager manager = new UtilisateurManager();
			
			
			//on vérifie si le pseudo et le mail existe déja en BDD
			
			if (manager.selectPseudo(pseudo) == null) {
				verifPseudo = true;
				System.out.println(manager.selectPseudo(pseudo));
				request.setAttribute("verifPseudo", verifPseudo);
				
				//redirection vers la page d'inscription
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
	        	rd.forward(request, response);
				
			}else  if (manager.selectMail(email) == null){
				verifMail = true;
				request.setAttribute("verifMail", verifMail);

				//redirection vers la page d'inscription
	    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
	        	rd.forward(request, response);
			} else {
				
				//sinon on crée un nouvel utilisateur + retour à la page d'accueil en mode connécté
				Utilisateur newUtilisateur = new Utilisateur(pseudo, prenom, nom,  email, telephone, rue, codePostal, ville, password );
				
				manager.insertNouvelUtilisateur (newUtilisateur);
				
				HttpSession session = request.getSession();
	    		session.setAttribute("noUtilisateur", newUtilisateur.getNoUtilisateur());
	    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecte.jsp");
	        	rd.forward(request, response);
			}   	  				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
}
}
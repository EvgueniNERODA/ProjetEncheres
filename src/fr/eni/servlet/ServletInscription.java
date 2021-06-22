package fr.eni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.UtilisateurManager;

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
		boolean verifDoublon = false;
		
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
			if (manager.selectPseudo(pseudo) != null) {
				verifDoublon = true;
			}else  if (manager.selectMail(password) != null){
				verifDoublon = true;
			} else {
			//sinon on crée un nouvel utilisateur
				manager.insertNouvelUtilisateur (pseudo, prenom, telephone, codePostal, password, nom, email, rue, ville);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//retour vers la page Login en mode connécté
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		rd.forward(request, response);
		
		
		
	}

}

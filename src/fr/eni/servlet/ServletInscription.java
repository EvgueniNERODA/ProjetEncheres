package fr.eni.servlet;

import java.io.IOException;

import javax.activation.MailcapCommandMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;
import fr.eni.messages.LecteurMessage;
import fr.eni.outils.BusinessException;

/**
 * Servlet implementation class ServletInscription vérifie si le pseudo et le
 * mail existent déjà crée un nouvel utilisateur
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// force l'encodage en UTF8 pour ne pas avoir de problèmes d'encodage dans la
		// BDD
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
		boolean verifPassword = false;

		// récupération saisie utilisateur
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
			Utilisateur newUtilisateur = new Utilisateur(pseudo, prenom, nom, email, telephone, rue, codePostal, ville,
					password);
			
			// vérifacation corréspondance mots de passe
			if (!confirmPassword.equals(password)) {
				verifPassword = true;
				request.setAttribute("verifPassword", verifPassword);

				// redirection vers la page d'inscription
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
				rd.forward(request, response);

				// on vérifie si le pseudo et le mail existent déja en BDD
			} else if (pseudo.equals(manager.selectPseudo(pseudo))) {

				verifPseudo = true;
				request.setAttribute("verifPseudo", verifPseudo);

				// redirection vers la page d'inscription
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
				rd.forward(request, response);

			} else if (email.equals(manager.selectMail(email))) {
				verifMail = true;
				request.setAttribute("verifMail", verifMail);

				// redirection vers la page d'inscription
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
				rd.forward(request, response);
			} else {

				// sinon on crée un nouvel utilisateur + retour à la page d'accueil en mode  connécté
				manager.insertNouvelUtilisateur(newUtilisateur);
				
				//création de la session
				HttpSession session = request.getSession();
				
				//select de l'utilisateur qui vient d'être crée					
				int noUtilisateur = manager.selectAll(pseudo).getNoUtilisateur();
				
				//redirection vers la page accueil en mode connecté
				session.setAttribute("noUtilisateur", noUtilisateur);
				response.sendRedirect("./ServletAccueilConnecte");
				
			
			}

		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			e.printStackTrace();
			// redirection vers la page d'inscription
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
			rd.forward(request, response);
		}

	}
}
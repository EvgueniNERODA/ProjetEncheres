package fr.eni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.security.ConcurrentMessageDigest;

import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class ServletModifProfil
 */
@WebServlet("/ServletModifProfil")
public class ServletModifProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
/**************************************************DO-GET*****************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On arrive dans la ServletModifProfil depuis MonProfil.jsp et on redirige vers ModifProfil.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifProfil.jsp");
		rd.forward(request, response);
	}

/**************************************************DO-POST*****************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String pseudo = "";
		String prenom = "";
		String telephone = "";
		String codePostal = "";
		String nom = "";
		String email = "";
		String rue = "";
		String ville = "";
		String confirmPassword = "";
		String actualPassword ="";
		String newPassword ="";
		boolean verifPseudo = false;
		boolean verifMail = false;
		boolean verifPassword = false;
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		
		//On récupère la session
		HttpSession session = request.getSession();
		int idUtilisateur = (int)session.getAttribute("noUtilisateur");	
		
		/**********************************************METHODE-DO-POST-UPDATE**************************************/
		//On récupère les données modifier de ModifProfil.jsp
		pseudo = request.getParameter("pseudo");
		prenom = request.getParameter("prenom");
		telephone = request.getParameter("tel");
		codePostal = request.getParameter("cp");
		nom = request.getParameter("nom");
		email = request.getParameter("email");
		rue = request.getParameter("rue");
		ville = request.getParameter("ville");
		actualPassword = request.getParameter("actualPassword");
		newPassword = request.getParameter("newPassword");
		confirmPassword = request.getParameter("confirmPassword");
		
		Utilisateur utilisateur = new Utilisateur(idUtilisateur, pseudo, prenom, nom, email, telephone, rue, codePostal, ville,
				newPassword);
	
		// Vérification correspondance des mots de passe
		if (!confirmPassword.equals(newPassword)) {
			verifPassword = true;
			request.setAttribute("verifPassword", verifPassword);

			// redirection vers la page de modifProfil
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifProfil.jsp");
			rd.forward(request, response);

		// Vérification si pseudo et mail existent en BDD
			} else if (pseudo.equals(utilisateurManager.selectPseudo(pseudo))) {
			verifPseudo = true;
			request.setAttribute("verifPseudo", verifPseudo);

			// redirection vers la page de modifProfil
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifProfil.jsp");
			rd.forward(request, response);

			} else if (email.equals(utilisateurManager.selectMail(email))) {
			verifMail = true;
			request.setAttribute("verifMail", verifMail);

			// redirection vers la page de modifProfil
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifProfil.jsp");
			rd.forward(request, response);
			}
		
		//On fait un appel à une méthode Update afin de modifier l'utilisateur présent en BDD
		utilisateurManager.update_by_id(utilisateur);
		
		//Redirection vers la page monProfil avec affichage du profil modifié
		RequestDispatcher rd = request.getRequestDispatcher("/ServletMonProfil");
		rd.forward(request, response);
		
		/**********************************************METHODE-DO-POST-DELETE**************************************/
		
	}
}

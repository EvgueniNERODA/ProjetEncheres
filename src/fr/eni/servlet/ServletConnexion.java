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
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
       
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
		boolean existeEnBdd = false;
    	Utilisateur utilisateur = new Utilisateur();
    	request.setAttribute("identifiant", identifiant);
    	request.setAttribute("motdepasse", motDePasse);
    	
    	// On vérifie s'il existe avec son adresse mail
    	if(identifiant.contains("@")) {
    		utilisateur = new Utilisateur(identifiant,motDePasse,true);
        	try {
				existeEnBdd = utilisateurManager.verifier(utilisateur);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
    	}else {
    		utilisateur = new Utilisateur(identifiant,motDePasse,false); 
    		try {
				existeEnBdd = utilisateurManager.verifier(utilisateur);
			} catch (BusinessException e) {
				e.printStackTrace();
			}   	
    	}
    	
    	// Si oui on redirige l'utilisateur vers la page d'acceuil (version connecté) avec la creation d'une session
    	if(existeEnBdd == true) {
    		HttpSession session = request.getSession();
    	
    }
    	
    
		// Si non on redirige sur Connexion.jsp avec un message d'erreur (mauvais mdp ou identifiant inconnu)
		
    	
    	
		doGet(request, response);
	}

}

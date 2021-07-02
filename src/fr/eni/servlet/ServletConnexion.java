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
import fr.eni.messages.LecteurMessage;
import fr.eni.outils.BusinessException;

/**
 * Servlet implementation class ServletConnexion
 * 
 * Cette classe permet la redirection vers la page de connexion.jsp dans la méthode DO-GET
 * 
 * Cette classe permet la vérification de l'identifiant/mdp de l'utilisateur, son statut (actif/inactif) et 
 * les differentes redirections selon les cas dans la méthode DO-POST.
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
	
	
   
/**************************************************DO-GET*****************************************************************/
	//----------------------->On arrive dans le DO-GET ServletConnexion depuis Accueil.jsp-----------------------------//
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	//______________________________________REDIRECTION VERS CONNEXION.JSP____________________________________________
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion.jsp");
		rd.forward(request, response);
		
	}
	
	

/**************************************************DO-POST*****************************************************************/
	//----------------------->On arrive dans le DO-POST ServletConnexion depuis Connexion.jsp---------------------------//
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// On récupère l'identifiant(mail ou pseudo) et le mdp de Connexion.jsp
		request.setCharacterEncoding("UTF-8");
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		
		//___________________________________VERIFICATION SI L'UTILISATEUR EXISTE EN BDD___________________________________
		boolean existeEnBdd = false;
    	Utilisateur utilisateur = new Utilisateur();
    	
    		//Si l'utilisateur existe avec son adresse mail
    		if(identifiant.contains("@")) {
    			
    			//Constructeur qui prend en paramètre un emailExistant à true
    			utilisateur = new Utilisateur(identifiant,motDePasse,true);
    			
    			try {
    				//Méthode qui renvoie un booléen true si l'utilisateur existe en BDD.
					existeEnBdd = utilisateurManager.verifier(utilisateur);
				} catch (BusinessException e) {
					e.printStackTrace();
					request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
				}
    			
    		// Si identifiant ne contient pas de "@", on vérifie que l'utilisateur existe avec un pseudo
    		}else {
    			
    			//Constructeur qui prend en paramètre un emailExistant à false
    			utilisateur = new Utilisateur(identifiant,motDePasse,false); 
    			
    			try {
    				//Même méthode qui renvoie un booléen true si l'utilisateur existe en BDD mais cette fois ci en prenant 
    				//en compte un pseudo.
					existeEnBdd = utilisateurManager.verifier(utilisateur);
				} catch (BusinessException e) {
					e.printStackTrace();
					request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
				}	
    		}
    		
    		// Sinon on redirige sur Connexion.jsp avec un message d'erreur "mauvais mdp ou identifiant inconnu"
			if (existeEnBdd == false) {
				boolean mdpIdentifiant = false;
				request.setAttribute("mdpIdentifiant", mdpIdentifiant);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion.jsp");
				rd.forward(request, response);
			
			}
    		
    		
    	//__________________________VERIFICATION SI UTILISATEUR EST INACTIF (COMPTE SUPPRIMÉ)_________________________________
    	Utilisateur utilisateurStatut = new Utilisateur();
    	
    		try {
    			//Méthode renvoyant un boolean du statut utilisateur
    			utilisateurStatut = utilisateurManager.find_user_by_email_or_pseudo(utilisateur);
    		} catch (BusinessException e) {
    			e.printStackTrace();
    			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
    		}
    	
    		//Si le statut de l'utilisateur est faux. 
    		if(utilisateurStatut.isStatut() == false) {
    			// l'attribut "compteInactif" est récupéré par la JSP pour afficher un message d'erreur à l'utilisateur.
    			boolean compteInactif = true;
    			request.setAttribute("compteInactif", compteInactif);
    			//Refus accès et redirection vers connection.jsp
    			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
    			rd.forward(request, response);
        	}
    		
    	
    	//___________________________________REDIRECTION SERVLET ACCUEIL-CONNECTE _____________________________________________
    	//	Utilisateur existe en BDD(existeEnBDD = true)
    	//	Utilisateur actif (utilisateurStatut.isStatut = true)
    	
    	if(existeEnBdd == true) {
    		//Creation session
    		HttpSession session = request.getSession();
    		//Set numero Utilisateur à la session
    		session.setAttribute("noUtilisateur", utilisateur.getNoUtilisateur());
    		//Redirection vers ServletAccueilConnecte
    		response.sendRedirect("./ServletAccueilConnecte");
    	}
    	
    }

}

package fr.eni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.session.StandardSessionFacade;

import fr.eni.outils.BusinessException;

/**
 * Servlet implementation class ServletBoutonAccueil
 */
@WebServlet("/ServletBoutonAccueil")
public class ServletBoutonAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
/**************************************************DO-GET*****************************************************************/	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//---------------> On arrive dans ServletBoutonAcceuil avec un clique sur le bouton home <-------------------//
		
		
		//______________________________________________RECUPERATION SESSION________________________________________________
			
			HttpSession session = request.getSession(false);
			System.out.println(session);
		//________________________________________VERIFICATION UTILISATEUR CONNECTÉ_________________________________________
			if (session != null && session.getAttribute("noUtilisateur") != null) {
						
				try {
					//redirection vers AccueilConnecte.jsp
					boolean compteConnecte = false;
					request.setAttribute("compteConnecte", compteConnecte);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecte.jsp");
					rd.forward(request, response);
				} catch (ServletException e) {
				
					e.printStackTrace();
				}

				}else {
				//redirection vers Accueil.jsp
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

package fr.eni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//TODO 
		//On récupère les données modifier de ModifProfil.jsp
		//On récupère l'noUtilisateur afin de savoir quel utilisateur est concerné par le changement. 
		//On vérifie que la nouvelle adresse mail et le nouveau pseudo ne sont pas déjà présent en BDD
		//On fait un appel à une méthode Update afin de modifier l'utilisateur présent en BDD
	}

}

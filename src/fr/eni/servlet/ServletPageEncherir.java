package fr.eni.servlet;


import java.io.IOException;
import java.util.List;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.InputBuffer;

import fr.eni.bll.ArticleManager;
import fr.eni.bo.Article;

/**
 * Servlet implementation class ServletPageEncherir
 */
@WebServlet("/ServletPageEncherir")
public class ServletPageEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleManager articleManager = new ArticleManager();
		int idArticle = Integer.parseInt(request.getParameter("id"));
		System.out.println(idArticle);
		List<Article> listeDeLarticle = articleManager.selectArticleById(idArticle);
		request.setAttribute("listeDeLarticle", listeDeLarticle);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageEncherir.jsp");
		rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

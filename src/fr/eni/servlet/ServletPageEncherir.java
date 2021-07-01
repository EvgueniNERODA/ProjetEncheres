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
import javax.servlet.http.HttpSession;

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
		
		List<Article> listeDeLarticle = articleManager.selectArticleById(idArticle);
		
		
		//test idEncherisseur pour savoir si c'est le vendeur ou l'acquéreur qui consulte l'article
		boolean testVendeur = false ;
		HttpSession session = request.getSession();
		int idEncherisseur = (int) session.getAttribute("noUtilisateur");
		int idVendeur = listeDeLarticle.get(0).getUtilisateur().getNoUtilisateur();
		if (idEncherisseur != idVendeur) {
			testVendeur = true;
		}
		
		request.setAttribute("testVendeur", testVendeur);
		
		request.setAttribute("listeDeLarticle", listeDeLarticle);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageEncherir.jsp");
		rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

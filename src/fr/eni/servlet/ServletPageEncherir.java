package fr.eni.servlet;


import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.ServletContext;
import org.apache.coyote.InputBuffer;

import java.sql.Timestamp;

import fr.eni.bll.ArticleManager;
import fr.eni.bll.EnchereManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Article;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class ServletPageEncherir
 */
@WebServlet("/ServletPageEncherir")
public class ServletPageEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleManager articleManager = new ArticleManager();
		int idArticle = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", idArticle);
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
		
		// force l'encodage en UTF8 pour ne pas avoir de problèmes d'encodage dans la
		// BDD
			request.setCharacterEncoding("UTF-8");
			
		int montantPropose = 0;
		
		Timestamp dateEnchere = new Timestamp(new java.util.Date().getTime());
		
		
		montantPropose= Integer.parseInt(request.getParameter("montantPropose"));
		
		
		//mise à jour du montant proposé par l'enchérisseur
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		HttpSession session = request.getSession();
		int idUtilisateur = (int) session.getAttribute("noUtilisateur");
		Utilisateur encherisseur = new Utilisateur(idUtilisateur);
		
		ArticleManager articleManager = new ArticleManager();
		int idArticle = Integer.parseInt(request.getParameter("id"));
		
		//int idArticle = (int) request.getAttribute("id");
		Article article = new Article(idArticle);
		List<Article> listeDeLarticle = articleManager.selectArticleById(idArticle);
		
		EnchereManager enchereManager = new EnchereManager();
		
		Enchere enchere = new Enchere(dateEnchere, montantPropose, encherisseur, article);
		
		//test pour savoir si il existe déjà une enchere
		if (enchereManager.selecEnchereByArticle (enchere) == null) {
			enchereManager.insertNewEnchere (enchere);
		}
		
		
		
		
	}

}

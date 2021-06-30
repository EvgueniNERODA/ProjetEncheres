package fr.eni.servlet;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import fr.eni.bll.ArticleManager;
import fr.eni.bll.CategorieManager;

import fr.eni.bo.Article;
import fr.eni.bo.Categorie;



/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**************************************************DO-GET*****************************************************************/	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// sélection des catégories présentes en BDD
		List<Categorie> listesCategories = CategorieManager.getInstance().selectCategories();	
		
		//ajout de la liste de catégories à la requète
		request.setAttribute("listesCategories", listesCategories);
		
		
		
		

		// renvoi vers la page Accueil
		HttpSession session = request.getSession(false);
		System.out.println(session);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		rd.forward(request, response);
	}

/**************************************************DO-POST*****************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	//_______________________________________AFFICHAGE ARTICLES___________________________________________
		
		
		//récupération de la saisie de l'utilisateur
		ArticleManager articleManager = new ArticleManager();
		int categorie = Integer.valueOf(request.getParameter("categorie"));
		categorie = 5;
		//cration instance catégorie avec noCatagorie
		Categorie nouvelleCategorie = new Categorie(categorie);
		String nomArticle = request.getParameter("recherche");
		//création instance article avec nomArticle et Catégorie
		Article article = new Article(nomArticle, nouvelleCategorie);
		System.out.println(nomArticle);
		
		List<Article> listesArticles = new ArrayList<>();
		
		if (categorie == 5) {
			listesArticles = articleManager.selectAllArticles(article);
		}else {
			listesArticles = articleManager.selectArticlesSelonCategorie (article);
			
		}
		System.out.println(listesArticles);
		
		request.setAttribute("listesArticles", listesArticles);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		rd.forward(request, response);
	}

	
	
}

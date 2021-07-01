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

import fr.eni.bll.ArticleManager;
import fr.eni.bll.CategorieManager;
import fr.eni.bll.EnchereManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Article;
import fr.eni.bo.Categorie;
import fr.eni.bo.Enchere;

/**
 * Servlet implementation class ServletAccueilConnecte
 */
@WebServlet("/ServletAccueilConnecte")
public class ServletAccueilConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**************************************************DO-GET*****************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// sélection des catégories présentes en BDD
		List<Categorie> listesCategories = CategorieManager.getInstance().selectCategories();	
				
		//ajout de la liste de catégories à la requète
		request.setAttribute("listesCategories", listesCategories);
				
		//sélection de tous les articles par défaut
		List<Article> listesArticles = new ArrayList<>();
		ArticleManager articleManager = new ArticleManager();
		listesArticles  = articleManager.selectAllArticles();
		request.setAttribute("listesArticles", listesArticles);
				
		//Passer la liste d'enchere en parametre à la jsp
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecte.jsp");
    	rd.forward(request, response);
		
	}

/**************************************************DO-POST*****************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//_______________________________________AFFICHAGE ARTICLES___________________________________________
			
			// sélection des catégories présentes en BDD
			List<Categorie> listesCategories = CategorieManager.getInstance().selectCategories();	
					
			//ajout de la liste de catégories à la requète
			request.setAttribute("listesCategories", listesCategories);
			
			
			
			//récupération de la saisie de l'utilisateur
			ArticleManager articleManager = new ArticleManager();
			int categorie = Integer.valueOf(request.getParameter("categorie"));
			
			//cration instance catégorie avec noCatagorie
			Categorie nouvelleCategorie = new Categorie(categorie);
			String nomArticle = request.getParameter("recherche");
			//création instance article avec nomArticle et Catégorie
			Article article = new Article(nomArticle, nouvelleCategorie);
			
			
			List<Article> listesArticles = new ArrayList<>();
			
			if (categorie == 5) {
				listesArticles = articleManager.selectAllArticles(article);
			}else {
				listesArticles = articleManager.selectArticlesSelonCategorie (article);
			
				
			}
		
			
			request.setAttribute("listesArticles", listesArticles);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecte.jsp");
			rd.forward(request, response);
	}

}

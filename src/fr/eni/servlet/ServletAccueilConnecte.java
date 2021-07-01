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
import javax.websocket.Session;

import fr.eni.bll.ArticleManager;
import fr.eni.bll.CategorieManager;
import fr.eni.bll.EnchereManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Article;
import fr.eni.bo.Categorie;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

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
		
		HttpSession session = request.getSession();
		int idUtilisateurEnCours = (int) session.getAttribute("noUtilisateur");

		//_______________________________________AFFICHAGE ARTICLES___________________________________________
			
			// sélection des catégories présentes en BDD
			List<Categorie> listesCategories = CategorieManager.getInstance().selectCategories();	
					
			//ajout de la liste de catégories à la requète
			request.setAttribute("listesCategories", listesCategories);
			
			
			
			//récupération de la saisie de l'utilisateur
			ArticleManager articleManager = new ArticleManager();
			int categorie = Integer.valueOf(request.getParameter("categorie"));
			
			//création instance utilisateur avec utilisateur en cours
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			Utilisateur utilisateurEnCours = new Utilisateur(idUtilisateurEnCours);
			
			//cration instance catégorie avec noCatagorie
			Categorie nouvelleCategorie = new Categorie(categorie);
			String nomArticle = request.getParameter("recherche");
			//création instance article avec nomArticle et Catégorie
			Article article = new Article(utilisateurEnCours, nomArticle, nouvelleCategorie);
			
			
			List<Article> listesArticles = new ArrayList<>();
			
			//filtes
			String encheresOuvertes = request.getParameter("encheres_ouvertes");
			String mesVentesEnCours = request.getParameter("mes_ventes_en_cours");
			String mesEncheres = request.getParameter("mes_encheres");
			String ventesNonDebutees = request.getParameter("ventes_non_debutees");
			String mesEncheresRemportees = request.getParameter("mes_encheres_remportees");
			String ventesTerminees = request.getParameter("ventes_terminees");
			
			if (categorie == 5) {
				Article articleSansCategorie = new Article(utilisateurEnCours, nomArticle);
				if (encheresOuvertes!= null) {
					listesArticles = articleManager.selectAllArticles(articleSansCategorie);
					System.out.println(1);
				} 
				if (mesVentesEnCours != null) {
					listesArticles = articleManager.selectArticlesByUserAndCategorie (articleSansCategorie);
					System.out.println(2);
				}
				if (mesEncheres!= null) {
					System.out.println(3);
				} 
				if (ventesNonDebutees!= null) {
					listesArticles = articleManager.selectByUserAndDateDebutEnchere (articleSansCategorie);
				} 
				if (mesEncheresRemportees!= null) {
					System.out.println(5);
				} 
				if(ventesTerminees!= null) {
					listesArticles = articleManager.selectByUserAndDateFinEnchere (articleSansCategorie);
				} if(ventesTerminees== null&&encheresOuvertes== null&&mesVentesEnCours == null&&mesEncheres== null&&ventesNonDebutees== null&&mesEncheresRemportees== null) {
				listesArticles = articleManager.selectAllArticles(article);
				}
			}else {
				if (encheresOuvertes!= null) {
					System.out.println(7);
				} 
				if (mesVentesEnCours != null) {
					System.out.println(8);
				}
				if (mesEncheres!= null) {
					System.out.println(9);
				} 
				if (ventesNonDebutees!= null) {
					System.out.println(10);
				} 
				if (mesEncheresRemportees!= null) {
					System.out.println(11);
				} 
				if(ventesTerminees!= null) {
					System.out.println(12);
				} else {
				listesArticles = articleManager.selectArticlesSelonCategorie (article);
			
				
			}
			
			}
			
			
			
			
	
			request.setAttribute("listesArticles", listesArticles);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecte.jsp");
			rd.forward(request, response);
	}

	
}
	

			

package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Article;
import fr.eni.bo.Categorie;
import fr.eni.bo.Utilisateur;
/**
 * 
 * Interface ArticleDAO pour le DesignPattern DAO
 *
 */

public interface ArticleDAO {

	void insertNouvelArticle(Article nouvelArticle);

	List <Article> selectArticlesSelonCategorie (Article articleARechercher);

	List<Article> selectAllArticlesByMotCle(Article articleARechercher);

	List<Article> selectAllArticles();

	List<Article> selectArticlesByUserAndCategorie(Article articleARechercher);

	List<Article> selectArticleById(int idArticle);

	List<Article> selectByUserAndDateDebutEnchere(Article articleSansCategorie);

	List<Article> selectByUserAndDateFinEnchere(Article articleSansCategorie);


	
			

}

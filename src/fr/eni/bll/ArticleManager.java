package fr.eni.bll;

import fr.eni.bo.Article;
import fr.eni.dal.ArticleDAO;
import fr.eni.dal.DAOFactory;

public class ArticleManager {

/*************************************************CREATION-SINGLETON************************************************/
	private static ArticleManager instance;
	
	public static ArticleManager getInstance() {
		if (instance == null)
			instance = new ArticleManager();
		return instance;

	}

	public void inserNouvelArticle(Article nouvelArticle) {
		ArticleDAO articleDAO = DAOFactory.getArticleDAO();
		articleDAO.insertNouvelArticle (nouvelArticle);
		
	}
	
	
}

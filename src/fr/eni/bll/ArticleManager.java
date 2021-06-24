package fr.eni.bll;

public class ArticleManager {

/*************************************************CREATION-SINGLETON************************************************/
	private static ArticleManager instance;
	
	public static ArticleManager getInstance() {
		if (instance == null)
			instance = new ArticleManager();
		return instance;

	}
	
	
}

package fr.eni.bll;

public class EnchereManager {

/*************************************************CREATION-SINGLETON************************************************/
	private static EnchereManager instance;
	
	public static EnchereManager getInstance() {
		if (instance == null)
			instance = new EnchereManager();
		return instance;

	}
	
}

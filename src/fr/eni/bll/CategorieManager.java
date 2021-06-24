package fr.eni.bll;

import fr.eni.bo.Categorie;
import fr.eni.dal.DAOFactory;

public class CategorieManager {

	/*************************************************CREATION-SINGLETON************************************************/
	private static CategorieManager instance;
	
	public static CategorieManager getInstance() {
		if (instance == null)
			instance = new CategorieManager();
		return instance;

	}

	/*****************************************METHODE-SELECT ALL UTILISATEUR AVEC PESEUDO******************************/
	public Categorie selectCategories() {
		
		return DAOFactory.getCategorieDAO().selectCategories ();
			
		
		
	}
	
	
}

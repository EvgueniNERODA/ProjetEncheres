package fr.eni.dal.jdbc;

import fr.eni.bo.Categorie;
import fr.eni.dal.CategorieDAO;

public class CategorieDAOImplt implements CategorieDAO {
	
	private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM CATEGORIES";

	@Override
	public Categorie selectCategories() {
		
		return null;
	}

}

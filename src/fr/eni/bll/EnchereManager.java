package fr.eni.bll;

import java.util.List;

import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.EnchereDAO;

public class EnchereManager {

/*************************************************CREATION-SINGLETON************************************************/
	private static EnchereManager instance;
	
	public static EnchereManager getInstance() {
		if (instance == null)
			instance = new EnchereManager();
		return instance;

	}

	public Boolean selecEnchereByArticle(Enchere enchere) {
		
		
		return DAOFactory.getEnchereDAO().selecEnchereByArticle(enchere);
		
		
	}

	public void insertNewEnchere(Enchere enchere) {
	
		EnchereDAO enchereDAO = DAOFactory.getEnchereDAO();
		enchereDAO.insertNewEnchere(enchere);
		
	}

	public List<Enchere> selectEnchereMaxById(int idArticle) {
		return DAOFactory.getEnchereDAO().selectEnchereMaxById(idArticle);
		// TODO Auto-generated method stub
		
	}

	
	
}

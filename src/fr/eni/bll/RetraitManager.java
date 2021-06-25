package fr.eni.bll;

import fr.eni.bo.Retrait;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.RetraitDAO;
import fr.eni.dal.UtilisateurDAO;

public class RetraitManager {

	/*************************************************CREATION-SINGLETON************************************************/
	private static RetraitManager instance;
	
	public static RetraitManager getInstance() {
		if (instance == null)
			instance = new RetraitManager();
		return instance;

	}

	/******************************************METHODE-INSERTION-NOUVEAU-RETRAIT*************************************/
	public void insertRetrait(Retrait retrait) {
		
		RetraitDAO retraitDAO = DAOFactory.getRetraitDAO();
		retraitDAO.insertRetrait(retrait);
	}
	
}

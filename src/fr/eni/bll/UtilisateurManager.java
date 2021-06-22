package fr.eni.bll;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.UtilisateurDAO;
import fr.eni.javaee.dal.RepasDAO;
/**
 * 
 * Création de la classe UtilisateurManager.
 *
 */
public class UtilisateurManager {
	
	
/*************************************************CREATION-SINGLETON************************************************/
	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if (instance == null)
			instance = new UtilisateurManager();
		return instance;
	}

/***************************************METHODE-VERIFIER-UTILISATEURS-EMAIL-OU-PSEUDO******************************/	
	public boolean verifier(Utilisateur utilisateur) {
		return DAOFactory.getUtilisateurDAO().verifier(utilisateur);
	}
	
	
	
	
	
}

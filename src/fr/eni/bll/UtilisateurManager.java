package fr.eni.bll;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurDAO;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.UtilisateurDAO;

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
	

	public Utilisateur selectPseudo(String pseudo) {
		
		return DAOFactory.getUtilisateurDAO().selectPseudo(pseudo);
	}
	
	
	
/***************************************METHODE-INSERTION-INSERTION-NOUVEL-UTILISATEUR****************************/	
	public void insertNouvelUtilisateur(String pseudo, String prenom, String telephone, String codePostal,
			String password, String nom, String email, String rue, String ville) {
		
		
	}

public Utilisateur selectMail(String email) {
	
	return DAOFactory.getUtilisateurDAO().selectMail(email);
}


	
}

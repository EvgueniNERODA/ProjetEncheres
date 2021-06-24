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

/***************************************METHODES-VERIFIER-UTILISATEURS-EMAIL-OU-PSEUDO******************************/	
	public boolean verifier(Utilisateur utilisateur) {
		return DAOFactory.getUtilisateurDAO().verifier(utilisateur);
	}
	

	public String selectPseudo(String pseudo) {
		
		return DAOFactory.getUtilisateurDAO().selectPseudo(pseudo);
	}
	
	public String selectMail(String email) {
		
		return DAOFactory.getUtilisateurDAO().selectMail(email);
	}
	
	
/*****************************************METHODE-SELECT ALL UTILISATEUR AVEC PESEUDO******************************/
	
	public Utilisateur selectAll(String pseudo) {
		
		return DAOFactory.getUtilisateurDAO().selectAll(pseudo);
		
	}
	
	
/*****************************************METHODE-INSERTION-NOUVEL-UTILISATEUR*************************************/	
	public void insertNouvelUtilisateur(Utilisateur utilisateur) {
	
	UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	utilisateurDAO.insertNouvelUtilisateur(utilisateur);
	}

/********************************************METHODE-AFFICHAGE-PAGE-MODIF-PROFIL***********************************/
	public Utilisateur find_user(int noUtilisateur) {
		return DAOFactory.getUtilisateurDAO().find_user(noUtilisateur);
	}




	
}

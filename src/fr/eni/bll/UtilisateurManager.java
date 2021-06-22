package fr.eni.bll;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurDAO;



public class UtilisateurManager {
	


	public Utilisateur selectPseudo(String pseudo) {
		
		return UtilisateurDAO.selectPseudo(pseudo);
	}

}

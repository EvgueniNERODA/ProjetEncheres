package fr.eni.dal;

import fr.eni.dal.jdbc.UtilisateurDAOImplt;

public class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImplt();
	}
	

}

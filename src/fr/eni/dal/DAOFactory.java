package fr.eni.dal;

import fr.eni.dal.jdbc.CategorieDAOImplt;
import fr.eni.dal.jdbc.RetraitDAOImplt;
import fr.eni.dal.jdbc.UtilisateurDAOImplt;

public class DAOFactory {
	
	


	


	public static RetraitDAO getRetraitDAO () {
		return new RetraitDAOImplt();
	}


	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImplt();
	}
	

	public static CategorieDAO getCategorieDAO () {
		return new CategorieDAOImplt();
		
	}
}

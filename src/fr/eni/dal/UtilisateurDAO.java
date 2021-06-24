package fr.eni.dal;

import fr.eni.bo.Utilisateur;
/**
 * 
 * Interface utilisateurDAO.
 * Elle permet de faire appel aux méthodes définie dans utilisateurDAOImplt.
 *
 */

public interface UtilisateurDAO {

	String selectPseudo(String pseudo) ;

	
	public boolean verifier(Utilisateur utilisateur);


	String selectMail(String email);
	
	
	void insertNouvelUtilisateur(Utilisateur utilisateur);
	
	Utilisateur find_user(int noUtilisateur);



	Utilisateur selectAll(String pseudo);

	void updateUserById(Utilisateur utilisateur);


	
}

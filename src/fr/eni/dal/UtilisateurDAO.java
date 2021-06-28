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

	//méthode DELETE-BY-iD
	void deleteUserById(Utilisateur utilisateur);

	//méthode UPDATE-STATUT-USER
	void updateStatutUser(Utilisateur utilisateur, boolean nouveauStatut);

	//méthode FIND-USER-BY-EMAIL-OR-PSEUDO
	Utilisateur find_user_by_email_or_pseudo(Utilisateur utilisateur);



}

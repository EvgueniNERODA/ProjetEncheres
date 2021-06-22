package fr.eni.dal;

import fr.eni.bo.Utilisateur;


public interface UtilisateurDAO {

	 Utilisateur selectPseudo(String pseudo) ;

	
	public boolean verifier(Utilisateur utilisateur);


	Utilisateur selectMail(String email);
	
}

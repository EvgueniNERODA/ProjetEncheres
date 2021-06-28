package fr.eni.bll;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurDAO;
import fr.eni.outils.BusinessException;
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

/***************************************METHODES-VERIFIER-UTILISATEURS-EMAIL-OU-PSEUDO
 * @throws BusinessException ******************************/	
	public boolean verifier(Utilisateur utilisateur) throws BusinessException {
		
		// Validation des données
				BusinessException be = new BusinessException();
<<<<<<< HEAD
				validationEmail(utilisateur.getEmail(), be);
				
=======
				if (utilisateur.getPseudo() != null) {
					validationPseudo(utilisateur.getPseudo(), be);
				}else {
					validationEmail(utilisateur.getEmail(), be);
				}
				validationPassword(utilisateur.getMotDePasse(), be);
	
>>>>>>> branch 'main' of https://github.com/EvgueniNERODA/ProjetEncheres
				if (be.hasErreurs()) {
					throw be;
				}
		return DAOFactory.getUtilisateurDAO().verifier(utilisateur);
	}
	

	public String selectPseudo(String pseudo) throws BusinessException {
		
		// Validation des données
		BusinessException be = new BusinessException();
		validationPseudo(pseudo, be);
		if (be.hasErreurs()) {
			throw be;
		}
		
		return DAOFactory.getUtilisateurDAO().selectPseudo(pseudo);
	}
	
	public String selectMail(String email) throws BusinessException {
		// Validation des données
				BusinessException be = new BusinessException();
				validationEmail(email, be);
				if (be.hasErreurs()) {
					throw be;
				}
		
		return DAOFactory.getUtilisateurDAO().selectMail(email);
	}
	
	

/*****************************************METHODE-SELECT ALL UTILISATEUR AVEC PSEUDO
 * @throws BusinessException ******************************/
	
	public Utilisateur selectAll(String pseudo) throws BusinessException {
		
		// Validation des données
				BusinessException be = new BusinessException();
				validationPseudo(pseudo, be);
				if (be.hasErreurs()) {
					throw be;
				}
		
		return DAOFactory.getUtilisateurDAO().selectAll(pseudo);
		
	}
	
	

/******************************************METHODE-INSERTION-NOUVEL-UTILISATEUR
 * @throws BusinessException *************************************/	

	public void insertNouvelUtilisateur(Utilisateur utilisateur) throws BusinessException {
	
		// Validation des données
		BusinessException be = new BusinessException();
		validationPseudo(utilisateur.getPseudo(), be);
		validationNom(utilisateur.getNom(), be);
		validationPrenom(utilisateur.getPrenom(), be);
		validationEmail(utilisateur.getEmail(), be);
		validationTelephone(utilisateur.getTelephone(), be);
		validationRue(utilisateur.getRue(), be);
		validationCp(utilisateur.getCodePostal(), be);
		validationVille(utilisateur.getVille(), be);
		validationPassword(utilisateur.getMotDePasse(), be);
		validationPseudo(utilisateur.getPseudo(), be);
		
		if (be.hasErreurs()) {
			throw be;
		}
		
		
	UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	utilisateurDAO.insertNouvelUtilisateur(utilisateur);
	}

/******************************************METHODE-AFFICHAGE-PAGE-MODIF-PROFIL
 * @throws BusinessException *************************************/
	public Utilisateur find_user(int noUtilisateur) throws BusinessException {
		
		// Validation des données
				BusinessException be = new BusinessException();
				validationNoUtilisateur(noUtilisateur, be);
		
				if (be.hasErreurs()) {
					throw be;
				}
		return DAOFactory.getUtilisateurDAO().find_user(noUtilisateur);
	}

	
/******************************************METHODE-UPDATE-USER-BY-ID
 * @throws BusinessException ***********************************************/
	public void update_by_id(Utilisateur utilisateur) throws BusinessException {
		
		// Validation des données
		BusinessException be = new BusinessException();
		validationPseudo(utilisateur.getPseudo(), be);
		validationNom(utilisateur.getNom(), be);
		validationPrenom(utilisateur.getPrenom(), be);
		validationEmail(utilisateur.getEmail(), be);
		validationTelephone(utilisateur.getTelephone(), be);
		validationRue(utilisateur.getRue(), be);
		validationCp(utilisateur.getCodePostal(), be);
		validationVille(utilisateur.getVille(), be);
		validationPassword(utilisateur.getMotDePasse(), be);
		validationPseudo(utilisateur.getPseudo(), be);
		
		if (be.hasErreurs()) {
			throw be;
		}
		
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		utilisateurDAO.updateUserById(utilisateur);
}

/******************************************METHODE-DELETE-USER-BY-ID
 * @throws BusinessException ***********************************************/
	public void delete_by_id(Utilisateur utilisateur) throws BusinessException {
		
		// Validation des données
		BusinessException be = new BusinessException();
		validationPseudo(utilisateur.getPseudo(), be);
		validationNom(utilisateur.getNom(), be);
		validationPrenom(utilisateur.getPrenom(), be);
		validationEmail(utilisateur.getEmail(), be);
		validationTelephone(utilisateur.getTelephone(), be);
		validationRue(utilisateur.getRue(), be);
		validationCp(utilisateur.getCodePostal(), be);
		validationVille(utilisateur.getVille(), be);
		validationPassword(utilisateur.getMotDePasse(), be);
		validationPseudo(utilisateur.getPseudo(), be);
		
		if (be.hasErreurs()) {
			throw be;
		}
		
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		utilisateurDAO.deleteUserById(utilisateur);
	
}

/******************************************METHODE-UPDATE-STATUT-USER-BY-ID
 * @param nouveauStatut 
 * @throws BusinessException ***********************************************/
	public void update_statut_user(Utilisateur utilisateur, boolean nouveauStatut) throws BusinessException {
		
		// Validation des données
		BusinessException be = new BusinessException();
		validationPseudo(utilisateur.getPseudo(), be);
		validationNom(utilisateur.getNom(), be);
		validationPrenom(utilisateur.getPrenom(), be);
		validationEmail(utilisateur.getEmail(), be);
		validationTelephone(utilisateur.getTelephone(), be);
		validationRue(utilisateur.getRue(), be);
		validationCp(utilisateur.getCodePostal(), be);
		validationVille(utilisateur.getVille(), be);
		validationPassword(utilisateur.getMotDePasse(), be);
		validationPseudo(utilisateur.getPseudo(), be);
		
		if (be.hasErreurs()) {
			throw be;
		}
		
	UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	utilisateurDAO.updateStatutUser(utilisateur, nouveauStatut);
}

	
	/******************************************METHODE-FIND-USER-BY-EMAIL-OR-PSEUDO
	 * @throws BusinessException ***********************************************/	
	public Utilisateur find_user_by_email_or_pseudo(String identifiant) throws BusinessException {
		
		// Validation des données
				BusinessException be = new BusinessException();
				validationPseudo(identifiant, be); //TODO vérifier
				
				if (be.hasErreurs()) {
					throw be;
				}
		
		return DAOFactory.getUtilisateurDAO().find_user_by_email_or_pseudo(identifiant);
}
	
	/*****************************************************************************************************************************/
	/******************************************METHODES-VERIFICATIONS-ERREURS*****************************************************/

	private void validationPseudo (String pseudo, BusinessException be) {
			if (pseudo == null || pseudo.trim().isEmpty() || pseudo.length() > 30) {
				be.ajouterErreur(CodesErreurBll.UTILISATEUR_PSEUDO_ERREUR);
			}
		}
	
	private void validationUtilisateur (Utilisateur utilisateur, BusinessException be) {
		if (utilisateur == null) {
			be.ajouterErreur(CodesErreurBll.UTILISATEUR_OBJET_NULL);
		}
		
		
	}

	private void validationNom (String nom, BusinessException be) {
		if (nom == null || nom.isEmpty() || nom.length() > 30) {
			be.ajouterErreur(CodesErreurBll.UTILISATEUR_NOM_ERREUR);
		}
	}

	private void validationPrenom (String prenom, BusinessException be) {
		if (prenom == null || prenom.isEmpty() || prenom.length() > 30) {
			be.ajouterErreur(CodesErreurBll.UTILISATEUR_NOM_ERREUR);
		}
	}

	private void validationEmail (String email, BusinessException be) {
		if (email == null || email.isEmpty() || email.length() > 30) {
			be.ajouterErreur(CodesErreurBll.UTILISATEUR_EMAIL_ERREUR);
		}
	}

	private void validationTelephone (String tel, BusinessException be) {
		if (tel == null || tel.isEmpty() || tel.length() > 15) {
			be.ajouterErreur(CodesErreurBll.UTILISATEUR_TELEPHONE_ERREUR);
		}
	}
	
	private void validationRue (String rue, BusinessException be) {
		if (rue == null || rue.isEmpty() || rue.length() > 30) {
			be.ajouterErreur(CodesErreurBll.UTILISATEUR_RUE_ERREUR);
		}
	}
	
	
	private void validationCp (String cp, BusinessException be) {
		if (cp == null || cp.isEmpty() || cp.length() > 10) {
			be.ajouterErreur(CodesErreurBll.UTILISATEUR_CODE_POSTAL_ERREUR);
		}
	}
	
	private void validationVille (String ville, BusinessException be) {
		if (ville == null || ville.isEmpty()) {
			be.ajouterErreur(CodesErreurBll.UTILISATEUR_VILLE_ERREUR);
		}
	}
	
	private void validationPassword (String password, BusinessException be) {
		if (password == null || password.isEmpty()) {
			be.ajouterErreur(CodesErreurBll.UTILISATEUR_PASSWORD_ERREUR);
		}
	}
	
	private void validationNoUtilisateur (int noUtilisateur, BusinessException be) {
		if (noUtilisateur == 0 || noUtilisateur < 0) {
			be.ajouterErreur(CodesErreurBll.UTILISATEUR_NO_UTILISATEUR_ERREUR);
		}
	}
	
}

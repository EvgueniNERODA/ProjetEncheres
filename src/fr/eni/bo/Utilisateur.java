package fr.eni.bo;

import java.util.List;
/**
 * 
 * Création de la classe Utilisateur.
 * Elle permet la création d'un compte utilisateur sur le site 
 * d'enchère.
 *
 */
public class Utilisateur {
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean statut;
	private boolean administrateur;
	private List <Article> listeArticles;
	private List <Enchere>  listeEnchere;
	
	
/*************************************************CONSTRUCTEURS******************************************************/	
	public Utilisateur() {	
	}
	
/**
*** Constructeur pour passer un utilisateur à la BDD avec son id.
*** @param identifiant, noUtilisateur.
**/	
	public Utilisateur(int noUtilisateur) {
		this();
		this.noUtilisateur = noUtilisateur;
}

/**
*** Constructeur pour passer un utilisateur à la BDD avec son id et la valeur du statut.
*** @param identifiant, statut.
**/		
	
	public Utilisateur(int noUtilisateur, boolean statut) {
		this();
		this.noUtilisateur = noUtilisateur;
		this.statut = statut;
}

/**
*** Constructeur pour la vérification d'Email existant
*** @param identifiant, motdepasse, emailExiste
**/
	public Utilisateur(String identifiant, String motdepasse, boolean emailExiste) {
		if(emailExiste) {
			this.email = identifiant;
		}else {
			this.pseudo = identifiant;
		}	
		this.motDePasse = motdepasse;
	}

/**
*** Constructeur Utilisateur avec pseudo
*** @param pseudo
**/	
	public Utilisateur(String pseudo) {
		this.pseudo = pseudo;
	}

/**
*** Constructeur Utilisateur avec pseudo et noUtilisateur
*** @param pseudo noUtilisateur
**/
	public Utilisateur(String pseudo, int noUtilisateur) {
		this.pseudo = pseudo;
		this.noUtilisateur = noUtilisateur;
	}

/**
*** Constructeur Utilisateur avec pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse
*** @param pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse
**/

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse
			) {
		this();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = 100;
		this.statut = true;
		this.administrateur = false;
		
	}
	
/**
*** Constructeur Utilisateur avec noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse
*** @param noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse
**/

public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		this();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		
	}

/*************************************************GETTERS/SETTERS*****************************************************/	
	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public List<Article> getListeArticles() {
		return listeArticles;
	}

	public void setListeArticles(List<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}

	public List <Enchere> getListeEnchere() {
		return listeEnchere;
	}

	public void setListeEnchere(List<Enchere> enchere) {
		this.listeEnchere = enchere;
	}
	
	public boolean isStatut() {
			return statut;
		}
	
	//Setters pour changer le statut utilisateur en inactif
	public boolean isStatut(boolean nouveauStatut) {
			statut = false;
			return statut;
	}
	
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	

/****************************************************AFFICHAGE*******************************************************/	
		
	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit + ", statut="
				+ statut + ", administrateur=" + administrateur + ", listeArticles=" + listeArticles + "]";
	}
	
	
}

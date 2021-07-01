package fr.eni.bo;

import java.util.List;

import java.sql.Timestamp;

import java.time.LocalDate;
/**
 * 
 * Création de la classe Enchere.
 * Elle permet 
 *
 */
public class Enchere {
	private int no_enchere;
	private Timestamp dateEnchere;
	private int montant_enchere;
	private Utilisateur utilisateur;
	private Article article;
	
	
/*************************************************CONSTRUCTEURS**************************************************/	
	public Enchere() {
		
	}

	
	
	



	public Enchere(Article article) {
	this();
	this.article = article;
	}









public Enchere(Timestamp dateEnchere2, int montantPropose, Utilisateur encherisseur, Article article2) {
	this();
	this.dateEnchere = dateEnchere2;
	this.montant_enchere = montantPropose;
	this.utilisateur = encherisseur;
	this.article = article2;
	
}







/*************************************************GETTERS/SETTERS************************************************/	
	
	
	
	public int getNo_enchere() {
		return no_enchere;
	}


	public Utilisateur getUtilisateur() {
	return utilisateur;
}

public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}

public Article getArticle() {
	return article;
}

public void setArticle(Article article) {
	this.article = article;
}

	public void setNo_enchere(int no_enchere) {
		this.no_enchere = no_enchere;
	}


	public java.sql.Timestamp getDateEnchere() {
		return dateEnchere;
	}


	public void setDateEnchere(java.sql.Timestamp dateEnchere) {
		this.dateEnchere = dateEnchere;
	}


	public int getMontant_enchere() {
		return montant_enchere;
	}


	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}


	public Utilisateur getUtilisateurs() {
		return utilisateur;
	}


	public void setUtilisateurs(Utilisateur utilisateurs) {
		this.utilisateur = utilisateurs;
	} 
	
/**************************************************AFFICHAGE****************************************************/	
		@Override
		public String toString() {
			return "Enchere [no_enchere=" + no_enchere + ", dateEnchere=" + dateEnchere + ", montant_enchere="
					+ montant_enchere + "]";
		}



	
}

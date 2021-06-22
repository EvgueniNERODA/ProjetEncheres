package fr.eni.bo;

import java.util.List;
import java.time.LocalDate;
/**
 * 
 * Création de la classe Enchere.
 * Elle permet 
 *
 */
public class Enchere {
	private int no_enchere;
	private LocalDate dateEnchere;
	private int montant_enchere;
	private Utilisateur utilisateur;
	
	
/*************************************************CONSTRUCTEURS**************************************************/	
	public Enchere() {
		
	}

/*************************************************GETTERS/SETTERS************************************************/	
	public int getNo_enchere() {
		return no_enchere;
	}


	public void setNo_enchere(int no_enchere) {
		this.no_enchere = no_enchere;
	}


	public LocalDate getDateEnchere() {
		return dateEnchere;
	}


	public void setDateEnchere(LocalDate dateEnchere) {
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

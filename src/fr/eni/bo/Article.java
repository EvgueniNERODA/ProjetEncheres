package fr.eni.bo;

import java.util.List;
import java.time.LocalDate;
/**
 * 
 * Création de la classe ArticleVendu
 * Elle permet la creation d'un article afin de le mettre en vente sur
 * notre site d'enchère.
 * 
 */
public class Article {

	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private boolean etatVente = false;
	
	private Utilisateur utilisateur;
	private Enchere enchere;
	private List <Categorie> listeCategorie;
	private Retrait retrait;
	
/*************************************************CONSTRUCTEURS**************************************************/	
	public Article() {
		
	}

	
/*************************************************GETTERS/SETTERS************************************************/
	public int getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}


	public String getNomArticle() {
		return nomArticle;
	}


	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}


	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}


	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}


	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}


	public int getMiseAPrix() {
		return miseAPrix;
	}


	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}


	public int getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}


	public boolean isEtatVente() {
		return etatVente;
	}


	public void setEtatVente(boolean etatVente) {
		this.etatVente = etatVente;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Enchere getEnchere() {
		return enchere;
	}


	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}


	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}


	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}


	public Retrait getRetrait() {
		return retrait;
	}


	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

/***************************************************AFFICHAGE*********************************************************/
	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + "]";
	}
	
	
	
}

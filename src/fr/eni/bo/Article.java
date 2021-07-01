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
	
	private int idUtilisateur = 0;
	private Utilisateur utilisateur;
	private List <Enchere> listeEncheres;

	private Categorie categorie;
	private Retrait retrait;
	
	
/*************************************************CONSTRUCTEURS**************************************************/	
	public Article() {
		
	}


public Article(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
		int miseAPrix,Utilisateur utilisateur, Categorie categorie, Retrait retrait) {
	this();
	this.nomArticle = nomArticle;
	this.description = description;
	this.dateDebutEncheres = dateDebutEncheres;
	this.dateFinEncheres = dateFinEncheres;
	this.miseAPrix = miseAPrix;
	this.utilisateur = utilisateur;
	this.categorie = categorie;
	this.retrait = retrait;
}





public Article(String nomArticle, Categorie categorie, int miseAPrix, LocalDate dateFinEncheres, Utilisateur utilisateur) {
	this();
	this.nomArticle = nomArticle;
	this.categorie = categorie;
	this.miseAPrix = miseAPrix;
	this.dateFinEncheres = dateFinEncheres;
	this.utilisateur = utilisateur;
}


public Article(String nomArticle, Categorie categorie) {
	this();
	this.nomArticle = nomArticle;
	this.categorie = categorie;
}




public Article(int noArticle,String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
		int miseAPrix, int prixVente, Utilisateur utilisateur) {
	this();
	this.noArticle = noArticle;
	this.nomArticle = nomArticle;
	this.description = description;
	this.dateDebutEncheres = dateDebutEncheres;
	this.dateFinEncheres = dateFinEncheres;
	this.miseAPrix = miseAPrix;
	this.prixVente = prixVente;
	
	this.utilisateur = utilisateur;
}


public Article(Utilisateur utilisateur, String nomArticle, Categorie categorie) {
	this();
	this.utilisateur = utilisateur;
	this.nomArticle = nomArticle;
	this.categorie = categorie;
		
	
}





public Article(Utilisateur utilisateur, String nomArticle) {
	this();
	this.utilisateur = utilisateur;
	this.nomArticle = nomArticle;
	
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



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	


	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}


	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Retrait getRetrait() {
		return retrait;
	}


	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}
	
	
	
	
	
	/////////////////////////////supprimer si non utilisé//////////////

public int getIdUtilisateur() {
		return idUtilisateur;
	}



	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}



	




	



/***************************************************AFFICHAGE*********************************************************/
	
	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + ", idUtilisateur="
				+ idUtilisateur + ", utilisateur=" + utilisateur + ", listeEncheres=" + listeEncheres + ", categorie="
				+ categorie + ", retrait=" + retrait + "]";
	}
	
	
}

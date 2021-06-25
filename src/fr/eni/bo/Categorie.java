package fr.eni.bo;

import java.util.List;

/**
 * 
 * Création de la classe Categorie.
 * Elle permet la définition de la catégorie d'un article créée pour une mise 
 * aux enchères.
 *
 */
public class Categorie {
	private int noCategorie;
	private String libelle;
	private List <Article> listeArticles;
	

/*************************************************CONSTRUCTEURS****************************************************/	
	public Categorie() {
		
	}
	
	

	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}



/*************************************************GETTERS/SETTERS**************************************************/	
	public int getNoCotegorie() {
		return noCategorie;
	}

	public void setNoCotegorie(int noCotegorie) {
		this.noCategorie = noCotegorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

	

public List<Article> getListeArticles() {
		return listeArticles;
	}

	public void setListeArticles(List<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}

/***************************************************AFFICHAGE****************************************************/	
	@Override
	public String toString() {
		return "Categorie [noCotegorie=" + noCategorie + ", libelle=" + libelle + ", article=" + listeArticles
				+ "]";
	}
	
	
	
}

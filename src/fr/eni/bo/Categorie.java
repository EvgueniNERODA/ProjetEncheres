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
	private int noCotegorie;
	private String libelle;
	private List <Article> listeArticles;
	

/*************************************************CONSTRUCTEURS****************************************************/	
	public Categorie() {
		
	}

/*************************************************GETTERS/SETTERS**************************************************/	
	public int getNoCotegorie() {
		return noCotegorie;
	}

	public void setNoCotegorie(int noCotegorie) {
		this.noCotegorie = noCotegorie;
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
		return "Categorie [noCotegorie=" + noCotegorie + ", libelle=" + libelle + ", article=" + listeArticles
				+ "]";
	}
	
	
	
}

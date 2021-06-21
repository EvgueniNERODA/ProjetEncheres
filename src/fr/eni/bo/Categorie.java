package fr.eni.bo;

public class Categorie {
	private int noCotegorie;
	private String libelle;
	private ArticleVendu articleVendu;
	
	//constructeurs
	public Categorie() {
		
	}

	//getters/setters
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

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	//affichage
	@Override
	public String toString() {
		return "Categorie [noCotegorie=" + noCotegorie + ", libelle=" + libelle + ", articleVendu=" + articleVendu
				+ "]";
	}
	
	
	
}

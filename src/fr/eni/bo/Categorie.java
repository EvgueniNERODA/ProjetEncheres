package fr.eni.bo;
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
	private Article article;
	

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

	public Article getArticle() {
		return article;
	}

	public void setArticleVendu(Article article) {
		this.article = article;
	}

/***************************************************AFFICHAGE****************************************************/	
	@Override
	public String toString() {
		return "Categorie [noCotegorie=" + noCotegorie + ", libelle=" + libelle + ", article=" + article
				+ "]";
	}
	
	
	
}

package fr.eni.bo;

public class Retrait {

	private String rue;
	private int code_Postal;
	private String ville;
	private ArticleVendu articleARetirer;
	
	//constructeurs
	public Retrait() {
		
	}

	//getters/setters
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCode_Postal() {
		return code_Postal;
	}

	public void setCode_Postal(int code_Postal) {
		this.code_Postal = code_Postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public ArticleVendu getArticleARetirer() {
		return articleARetirer;
	}

	public void setArticleARetirer(ArticleVendu articleARetirer) {
		this.articleARetirer = articleARetirer;
	}
	
	
	
}


package fr.eni.bo;
/**
 * 
 * Création de la classe Retrait.
 * Elle permet de définir un lieu de retrait de l'enchère différent du
 * l'adresse initial d'un utilisateur.
 *
 */
public class Retrait {
	private int noRetrait;
	private String rue;
	private String code_Postal;
	private String ville;
	private Article articleARetirer;
	
/*************************************************CONSTRUCTEURS****************************************************/	
public Retrait() {
		
}



public Retrait(String rue, String code_Postal, String ville) {
	this();
	this.rue = rue;
	this.code_Postal = code_Postal;
	this.ville = ville;
}



/*************************************************GETTERS/SETTERS**************************************************/	
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_Postal() {
		return code_Postal;
	}

	public void setCode_Postal(String code_Postal) {
		this.code_Postal = code_Postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Article getArticleARetirer() {
		return articleARetirer;
	}

	public void setArticleARetirer(Article articleARetirer) {
		this.articleARetirer = articleARetirer;
	}
	
	

public int getNoRetrait() {
		return noRetrait;
	}



	public void setNoRetrait(int noRetrait) {
		this.noRetrait = noRetrait;
	}



/*************************************************AFFICHAGE**************************************************/	
	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", code_Postal=" + code_Postal + ", ville=" + ville + ", articleARetirer="
				+ articleARetirer + "]";
	}




	
	
	
}


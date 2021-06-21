package fr.eni.bo;
/**
 * 
 * Création de la classe Retrait.
 * Elle permet de définir un lieu de retrait de l'enchère différent du
 * l'adresse initial d'un utilisateur.
 *
 */
public class Retrait {

	private String rue;
	private int code_Postal;
	private String ville;
	private Article articleARetirer;
	
/*************************************************CONSTRUCTEURS****************************************************/	
	public Retrait() {
		
	}

/*************************************************GETTERS/SETTERS**************************************************/	
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

	public Article getArticleARetirer() {
		return articleARetirer;
	}

	public void setArticleARetirer(Article articleARetirer) {
		this.articleARetirer = articleARetirer;
	}

/*************************************************AFFICHAGE**************************************************/	
	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", code_Postal=" + code_Postal + ", ville=" + ville + ", articleARetirer="
				+ articleARetirer + "]";
	}
	
	
	
}


package fr.eni.bll;

public abstract class CodesErreurBll {

	/**
	 * liste des codes d'erreur possibles dans la bll
	 */
	
	//validations nouvel utilisateur
	public static final int UTILISATEUR_PSEUDO_ERREUR = 20_001;
	public static final int UTILISATEUR_NOM_ERREUR = 20_002;
	public static final int UTILISATEUR_PRENOM_ERREUR = 20_003;
	public static final int UTILISATEUR_EMAIL_ERREUR = 20_003;
	public static final int UTILISATEUR_TELEPHONE_ERREUR = 20_004;
	public static final int UTILISATEUR_RUE_ERREUR = 20_005;
	public static final int UTILISATEUR_CODE_POSTAL_ERREUR = 20_006;
	public static final int UTILISATEUR_VILLE_ERREUR = 20_007;
	public static final int UTILISATEUR_PASSWORD_ERREUR = 20_008;
	public static final int UTILISATEUR_NO_UTILISATEUR_ERREUR = 20_009;
	
	//validations nouvel article
	public static final int ARTICLE_DATE_ERREUR = 20_010;
	public static final int ARTICLE_DATE_FIN_ERREUR = 20_011;
	public static final int ARTICLE_MONTANT_ERREUR = 20_012;
	public static final int ARTICLE_NOM_ERREUR = 20_013;
	public static final int ARTICLE_DESCRIPTION_ERREUR = 20_014;
	public static final int ARTICLE_RUE_ERREUR = 20_015;
	public static final int ARTICLE_CP_ERREUR = 20_016;
	public static final int ARTICLE_VILLE_ERREUR = 20_017;
	
}

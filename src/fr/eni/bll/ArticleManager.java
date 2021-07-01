package fr.eni.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.bo.Article;
import fr.eni.bo.Categorie;
import fr.eni.dal.ArticleDAO;
import fr.eni.dal.DAOFactory;
import fr.eni.outils.BusinessException;

public class ArticleManager {

	/*************************************************
	 * CREATION-SINGLETON
	 ************************************************/
	private static ArticleManager instance;

	public static ArticleManager getInstance() {
		if (instance == null)
			instance = new ArticleManager();
		return instance;

	}

	/********************************
	 * METHODE-INSERTION-NOUVEL-ARTICLE
	 * @throws BusinessException 
	 ************************************************/
	public void inserNouvelArticle(Article nouvelArticle) throws BusinessException {

		// Validation des données
		BusinessException be = new BusinessException();
		validationDateDuJOur(nouvelArticle.getDateDebutEncheres(), be);
		validationDateDuJOur(nouvelArticle.getDateFinEncheres(), be);
		validationDateFinVente(nouvelArticle.getDateDebutEncheres(), nouvelArticle.getDateFinEncheres(), be);
		validationMontantPrix(nouvelArticle.getMiseAPrix(), be);
		validationNomArticle(nouvelArticle.getNomArticle(), be);
		validationDescriptionArticle(nouvelArticle.getDescription(), be);
		validationCPVendeur(nouvelArticle.getRetrait().getCode_Postal(), be);
		validationRueVendeur(nouvelArticle.getRetrait().getRue(), be);
		validationVilleVendeur(nouvelArticle.getRetrait().getVille(), be);

		if (be.hasErreurs()) {
			throw be;
		}
		ArticleDAO articleDAO = DAOFactory.getArticleDAO();
		articleDAO.insertNouvelArticle(nouvelArticle);
		

	}
	/*************************************************
	 * METHODE-SELECTION-ARTICLES-SELON-CATEGORIE
	 ************************************************/
	public List<Article> selectArticlesSelonCategorie(Article articleARechercher) {
		
		ArticleDAO articleDAO = DAOFactory.getArticleDAO();
		return DAOFactory.getArticleDAO().selectArticlesSelonCategorie(articleARechercher);
	}
	
	/*************************************************
	 * METHODE-SELECTION-TOUS-LES-ARTICLES-BY-MOT-CLE
	 ************************************************/	
	public List<Article> selectAllArticles(Article articleARechercher) {
		
		return DAOFactory.getArticleDAO().selectAllArticlesByMotCle(articleARechercher);
		
		
	}
	
	/*************************************************************
	 * METHODE-SELECTION-TOUS-LES-ARTICLES-BY-USER-AND-CATEGORIE
	 *************************************************************/	
	
	public List<Article> selectArticlesByUserAndCategorie(Article articleARechercher) {
		// TODO Auto-generated method stub
		return DAOFactory.getArticleDAO().selectArticlesByUserAndCategorie(articleARechercher);
	}
	
	
	/*************************************************
	 * METHODE-SELECTION-TOUS-LES-ARTICLES
	 ************************************************/	
	public List<Article> selectAllArticles() {
		
		return DAOFactory.getArticleDAO().selectAllArticles();
		
	}
	
	/*************************************************
	 * METHODE-SELECTION-ARTICLES-BY-ID
	 ************************************************/	
	
	public List<Article> selectArticleById(int idArticle) {
		
		return DAOFactory.getArticleDAO().selectArticleById(idArticle);
	}
	
	/*************************************************
	 * VALIDATIONS
	 ************************************************/
	private void validationDateDuJOur(LocalDate dateDebutVente, BusinessException be) {
		if (dateDebutVente.isBefore(LocalDate.now())) {
			be.ajouterErreur(CodesErreurBll.ARTICLE_DATE_ERREUR);
		}
	}
	
	private void validationDateFinVente (LocalDate dateDebutVente, LocalDate dateFinVente, BusinessException be) {
		if (dateFinVente.isBefore(dateDebutVente)) {
			be.ajouterErreur(CodesErreurBll.ARTICLE_DATE_FIN_ERREUR);
		}
		
	}
	
	private void validationMontantPrix (int montant, BusinessException be) {
		if (montant <= 0 ) {
			be.ajouterErreur(CodesErreurBll.ARTICLE_MONTANT_ERREUR);
		
		}
		
	}
	
	private void validationNomArticle(String nom, BusinessException be) {
		
		if (nom == null || nom.isEmpty() || nom.length() > 30) {
			be.ajouterErreur(CodesErreurBll.ARTICLE_NOM_ERREUR);
		}
	}
	
	private void validationDescriptionArticle(String description, BusinessException be) {
		if (description == null || description.isEmpty() || description.length() > 300) {
			be.ajouterErreur(CodesErreurBll.ARTICLE_DESCRIPTION_ERREUR);
		}
	}
	
	private void validationRueVendeur(String rue, BusinessException be) {
		if (rue == null || rue.isEmpty() || rue.length() > 30) {
			be.ajouterErreur(CodesErreurBll.ARTICLE_RUE_ERREUR);
		}
	}
	
	private void validationCPVendeur(String cp, BusinessException be) {
		if (cp == null || cp.isEmpty() || cp.length() > 10) {
			be.ajouterErreur(CodesErreurBll.ARTICLE_CP_ERREUR);
		}
	}
	
	private void validationVilleVendeur(String ville, BusinessException be) {
		if (ville == null || ville.isEmpty() || ville.length() > 30) {
			be.ajouterErreur(CodesErreurBll.ARTICLE_VILLE_ERREUR);
		}
	}

	

	

}

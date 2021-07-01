package fr.eni.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Article;
import fr.eni.bo.Categorie;
import fr.eni.bo.Retrait;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.ArticleDAO;
import fr.eni.dal.JdbcTools;



public class ArticleJdbcImplt implements ArticleDAO {
	
	private static final String INSERT_NEW_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie, no_retrait) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
	private static final String INSERT_NEW_RETRAIT = "INSERT INTO RETRAITS (rue, code_postal, ville) VALUES (?, ?, ?)";

	private static final String SELECT_ALL_ARTICLES_BY_MOT_CLE = "SELECT nom_article, prix_initial, date_fin_encheres, pseudo, no_categorie, date_debut_encheres, description, prix_vente,  no_article FROM ARTICLES_VENDUS AS a INNER JOIN UTILISATEURS AS u ON a.no_utilisateur=u.no_utilisateur  WHERE lower(nom_article) LIKE ? ";
	private static final String SELECT_ARTICLES_SELON_CATEGORIE_ET_MOT_CLE = "SELECT nom_article, prix_initial, date_fin_encheres, pseudo, no_categorie,date_debut_encheres, description, prix_vente, no_article FROM ARTICLES_VENDUS AS a INNER JOIN UTILISATEURS AS u ON a.no_utilisateur=u.no_utilisateur  WHERE lower(nom_article) LIKE ? AND no_categorie=? ";
	private static final String SLECT_ARTICLES_BY_USER_AND_CATEGORIES = "SELECT nom_article, prix_initial, date_fin_encheres, pseudo, no_categorie,date_debut_encheres, description, prix_vente, no_article, u.no_utilisateur FROM ARTICLES_VENDUS AS a INNER JOIN UTILISATEURS AS u ON a.no_utilisateur=u.no_utilisateur  WHERE lower(nom_article) LIKE ? AND u.no_utilisateur=?";

	
	private static final String SELECT_ALL_ARTICLES = "SELECT nom_article, prix_initial, date_fin_encheres, pseudo, description, date_debut_encheres, prix_vente, date_debut_encheres, description, prix_vente, no_article   FROM ARTICLES_VENDUS JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur=UTILISATEURS.no_utilisateur ";

	private static final String SELECT_ARTICLE_BY_ID ="SELECT * FROM ARTICLES_VENDUS JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur=UTILISATEURS.no_utilisateur JOIN RETRAITS ON ARTICLES_VENDUS.no_retrait=RETRAITS.no_retrait JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie=CATEGORIES.no_categorie WHERE no_article=?";
	
	@Override
	public void insertNouvelArticle(Article nouvelArticle) {
		try (Connection cnx = JdbcTools.getConnection()){
			
			cnx.setAutoCommit(false);
			
			PreparedStatement pstmnt = cnx.prepareStatement(INSERT_NEW_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmnt.setString(1, nouvelArticle.getRetrait().getRue());
			pstmnt.setString(2, nouvelArticle.getRetrait().getCode_Postal());
			pstmnt.setString(3, nouvelArticle.getRetrait().getRue());
			
			pstmnt.executeUpdate();
			
			
			
			
			ResultSet rSet = pstmnt.getGeneratedKeys();
			
			if (rSet.next()) {
				nouvelArticle.getRetrait().setNoRetrait(rSet.getInt(1));
			}
			
			PreparedStatement pstmtArticle = cnx.prepareStatement(INSERT_NEW_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmtArticle.setString(1, nouvelArticle.getNomArticle());
			pstmtArticle.setString(2, nouvelArticle.getDescription());
			pstmtArticle.setDate(3, Date.valueOf(nouvelArticle.getDateDebutEncheres()));
			pstmtArticle.setDate(4, Date.valueOf(nouvelArticle.getDateFinEncheres()));
			pstmtArticle.setInt(5, nouvelArticle.getMiseAPrix());
			pstmtArticle.setInt(6, nouvelArticle.getUtilisateur().getNoUtilisateur());
			pstmtArticle.setInt(7, nouvelArticle.getCategorie().getNoCategorie());
			pstmtArticle.setInt(8, nouvelArticle.getRetrait().getNoRetrait());
			
			
			pstmtArticle.executeUpdate();
			
			cnx.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public List <Article> selectArticlesSelonCategorie(Article articleArechercher) {
		List<Article> listeDesArticles = new ArrayList<>();
		try (Connection cnx = JdbcTools.getConnection()) {
			
			PreparedStatement psmt = cnx.prepareStatement(SELECT_ARTICLES_SELON_CATEGORIE_ET_MOT_CLE);
			String nomArtitle = "%"+articleArechercher.getNomArticle()+"%" ;
			psmt.setString(1,  nomArtitle);
			psmt.setInt(2, articleArechercher.getCategorie().getNoCategorie());
			
			
			
								
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) { 
				
				if (rs.getDate("date_debut_encheres").toLocalDate().isBefore((LocalDate.now())) || rs.getDate("date_debut_encheres").toLocalDate().isEqual(((LocalDate.now())))) {
					
					//si la date de fin de l'enchère est postérieure à la date du jour on ajoute à la liste
					if (rs.getDate("date_fin_encheres").toLocalDate().isAfter(LocalDate.now())  || rs.getDate("date_fin_encheres").toLocalDate().isEqual(LocalDate.now())) {
						Utilisateur utilisateur = new Utilisateur(rs.getString("pseudo"));
						listeDesArticles.add(new Article(rs.getInt("no_article"),rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), rs.getInt("prix_vente"), utilisateur ));
					}
			
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return listeDesArticles;
	}


	
	@Override
	public List<Article> selectAllArticlesByMotCle(Article articleArechercher) {
		
		List<Article> listeArticles = new ArrayList<>();
		
		try (Connection cnx = JdbcTools.getConnection()){

			PreparedStatement psmt = cnx.prepareStatement(SELECT_ALL_ARTICLES_BY_MOT_CLE);
			
			String nomArtitle = "%"+articleArechercher.getNomArticle()+"%" ;
			
			psmt.setString(1,  nomArtitle);

			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				//condition d'affichages des ventes en fonction de la date de début de l'enchère et de la date de fin de l'enchere

				if (rs.getDate("date_debut_encheres").toLocalDate().isBefore((LocalDate.now())) || rs.getDate("date_debut_encheres").toLocalDate().isEqual(((LocalDate.now())))) {
					
					//si la date de fin de l'enchère est postérieure à la date du jour on ajoute à la liste
					if (rs.getDate("date_fin_encheres").toLocalDate().isAfter(LocalDate.now()) || rs.getDate("date_fin_encheres").toLocalDate().isEqual(LocalDate.now())) {
						Utilisateur utilisateur = new Utilisateur(rs.getString("pseudo"));
						listeArticles.add(new Article(rs.getInt("no_article"),rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), rs.getInt("prix_vente"), utilisateur ));
					
					}
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeArticles;
	}  

	@Override
	public List<Article> selectAllArticles() {
		
		List<Article> listeArticles = new ArrayList<>();
	
		
		
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement psmt = cnx.prepareStatement(SELECT_ALL_ARTICLES);
	
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				//condition d'affichages des ventes en fonction de la date de début de l'enchère et de la date de fin de l'enchere

				if (rs.getDate("date_debut_encheres").toLocalDate().isBefore((LocalDate.now())) || rs.getDate("date_debut_encheres").toLocalDate().isEqual(((LocalDate.now())))) {
					
					//si la date de fin de l'enchère est postérieure à la date du jour on ajoute à la liste
					if (rs.getDate("date_fin_encheres").toLocalDate().isAfter(LocalDate.now()) || rs.getDate("date_fin_encheres").toLocalDate().isEqual(LocalDate.now())) {
						Utilisateur utilisateur = new Utilisateur(rs.getString("pseudo"));
						listeArticles.add(new Article(rs.getInt("no_article"),rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), rs.getInt("prix_vente"), utilisateur ));
					}
					
				}
				
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeArticles;
	}


	
	
	@Override
	public List<Article> selectArticlesByUserAndCategorie(Article articleARechercher) {
		List<Article> listeArticles = new ArrayList<>();
		
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement psmt = cnx.prepareStatement(SLECT_ARTICLES_BY_USER_AND_CATEGORIES);
			String nomArtitle = "%"+articleARechercher.getNomArticle()+"%" ;
			psmt.setString(1,  nomArtitle);
			psmt.setInt(2, articleARechercher.getUtilisateur().getNoUtilisateur());
			
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				//condition d'affichages des ventes en fonction de la date de début de l'enchère et de la date de fin de l'enchere

				if (rs.getDate("date_debut_encheres").toLocalDate().isBefore((LocalDate.now())) || rs.getDate("date_debut_encheres").toLocalDate().isEqual(((LocalDate.now())))) {
					
					//si la date de fin de l'enchère est postérieure à la date du jour on ajoute à la liste
					if (rs.getDate("date_fin_encheres").toLocalDate().isAfter(LocalDate.now()) || rs.getDate("date_fin_encheres").toLocalDate().isEqual(LocalDate.now())) {
						Utilisateur utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getInt("no_utilisateur"));
						listeArticles.add(new Article(rs.getInt("no_article"),rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), rs.getInt("prix_vente"), utilisateur ));
					}
					
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return listeArticles;
	} 
	
	/**************************************************METHODE-SELECT-ARTICLE-BY-ID*******************************************************/
	
	@Override
	public List<Article> selectArticleById(int id){
		
		List<Article> listeArticle = new ArrayList<>();
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement psmt = cnx.prepareStatement(SELECT_ARTICLE_BY_ID);
			
			psmt.setInt(1, id);
	
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur(rs.getString("pseudo"));
				Categorie categorie = new Categorie(rs.getString("libelle"));
				Retrait retrait = new Retrait(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				listeArticle.add(new Article(rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), utilisateur, categorie, retrait ));
			}
				
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeArticle;
	}
	
}

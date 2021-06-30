package fr.eni.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Article;
import fr.eni.bo.Categorie;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.ArticleDAO;
import fr.eni.dal.JdbcTools;
import sun.security.mscapi.CKeyPairGenerator.RSA;


public class ArticleJdbcImplt implements ArticleDAO {
	
	private static final String INSERT_NEW_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie, no_retrait, etat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	private static final String INSERT_NEW_RETRAIT = "INSERT INTO RETRAITS (rue, code_postal, ville) VALUES (?, ?, ?)";

	private static final String SELECT_ALL_ARTICLES_BY_MOT_CLE = "SELECT nom_article, prix_initial, date_fin_encheres, pseudo, no_categorie FROM ARTICLES_VENDUS AS a INNER JOIN UTILISATEURS AS u ON a.no_utilisateur=u.no_utilisateur  WHERE lower(nom_article) LIKE ?  AND  etat=2";
	private static final String SELECT_ARTICLES_SELON_CATEGORIE_ET_MOT_CLE = "SELECT nom_article, prix_initial, date_fin_encheres, pseudo, no_categorie FROM ARTICLES_VENDUS AS a INNER JOIN UTILISATEURS AS u ON a.no_utilisateur=u.no_utilisateur  WHERE lower(nom_article) LIKE ? AND no_categorie=? AND  etat=2";


	
	private static final String SELECT_ALL_ARTICLES = "SELECT nom_article, prix_initial, date_fin_encheres, pseudo FROM ARTICLES_VENDUS JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur=UTILISATEURS.no_utilisateur WHERE etat=2";

	
	
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
			pstmtArticle.setInt(9, nouvelArticle.isEtatVente());
			
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
			psmt.setInt(1, articleArechercher.getCategorie().getNoCategorie());
			String nomArtitle = "%"+articleArechercher.getNomArticle()+"%" ;
			
			psmt.setString(2,  nomArtitle);
								
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				Categorie categorie = new Categorie(rs.getInt("no_categorie"));
				Utilisateur utilisateur = new Utilisateur(rs.getString("pseudo"));
				listeDesArticles.add(new Article(rs.getString("nom_article"), categorie, rs.getInt("prix_initial"), rs.getDate("date_fin_encheres").toLocalDate(), utilisateur ));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			//TODO gestion des erreurs
		}
		System.out.println(listeDesArticles);
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
				Categorie categorie = new Categorie(rs.getInt("no_categorie"));
				Utilisateur utilisateur = new Utilisateur(rs.getString("pseudo"));
				listeArticles.add(new Article(rs.getString("nom_article"), categorie, rs.getInt("prix_initial"), rs.getDate("date_fin_encheres").toLocalDate(), utilisateur ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(listeArticles);
		return listeArticles;
	}  

	@Override
	public List<Article> selectAllArticles() {
		
		List<Article> listeArticles = new ArrayList<>();
		Utilisateur utilisateur = new Utilisateur();
		Article article = new Article();
		
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement psmt = cnx.prepareStatement(SELECT_ALL_ARTICLES);
	
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				
				utilisateur.setPseudo(rs.getString("pseudo"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setUtilisateur(utilisateur);
				
				listeArticles.add(article);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticles;
	} 
	
}

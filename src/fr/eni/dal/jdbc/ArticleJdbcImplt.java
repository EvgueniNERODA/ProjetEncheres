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
	
	private static final String SELECT_ARTICLES_SELON_CATEGORIE = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie=? AND  etat=2";
	
	
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
	public void selectArticlesSelonCategorie(Categorie categorie) {
		try (Connection cnx = JdbcTools.getConnection()) {
			
			PreparedStatement psmt = cnx.prepareStatement(SELECT_ARTICLES_SELON_CATEGORIE);
			psmt.setInt(1, categorie.getNoCategorie());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}  

	
	
	
}

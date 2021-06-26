package fr.eni.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.bo.Retrait;
import fr.eni.dal.JdbcTools;
import fr.eni.dal.RetraitDAO;

public class RetraitDAOImplt implements RetraitDAO {

	private static final String INSERT_NEW_RETRAIT = "INSERT INTO RETRAITS (rue, code_postal, ville) VALUES (?, ?, ?)";
	private static final String INSERT_NEW_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie, no_retrait, etat) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?) ";  

	
	
	
	/**
	 * méthode d'insertion d'un nouveau retrait
	 * 
	 */
	@Override
	public Retrait insertRetrait(Retrait retrait) {
		try (Connection cnx = JdbcTools.getConnection()){
			
			
			
			PreparedStatement pstmnt = cnx.prepareStatement(INSERT_NEW_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			//1.on ajoute le retrait
			
			pstmnt.setString(1, "rue");
			pstmnt.setString(2, "code_postal");
			pstmnt.setString(3, "ville");
			
			pstmnt.executeUpdate();
			
			
			/**	
			//2. on ajoute l'article
			
			PreparedStatement preparedStatement = cnx.prepareStatement(INSERT_NEW_ARTICLE);
			preparedStatement.setString(1, retrait.getArticleARetirer().getNomArticle() );
			preparedStatement.setString(2, retrait.getArticleARetirer().getDescription() );
			preparedStatement.setDate(3,  java.sql.Date.valueOf(retrait.getArticleARetirer().getDateDebutEncheres() ));
			preparedStatement.setInt(4, retrait.getArticleARetirer().getMiseAPrix());
			preparedStatement.setInt(5, retrait.getArticleARetirer().getUtilisateur().getNoUtilisateur()); //TODO vérifier si l'id est le bon
			preparedStatement.setInt(6, retrait.getArticleARetirer().getCategorie().getNoCotegorie()); //TODO vérifier si l'id est le bon
			preparedStatement.setInt(7, retrait.getArticleARetirer().isEtatVente());
*/
			
			
			
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retrait;
		
	}

}

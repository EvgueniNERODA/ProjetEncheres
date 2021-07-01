package fr.eni.dal.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;

import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Enchere;
import fr.eni.dal.EnchereDAO;
import fr.eni.dal.JdbcTools;
import fr.eni.dal.UtilisateurDAO;

/**
 * 
 * Classe EnchereDAOImplt.
 * Elle est utilisée pour la création des requêtes SQL pour la BDD Microsoft SQL Server.
 *
 */
public class EnchereDAOImplt implements EnchereDAO{

	private static final String FIND_ALL_ENCHERE = "SELECT * FROM ENCHERE";
	private static final String SELECT_ENCHERE_BY_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article=?";
	private static final String INSERT_NEW_ENCHERE = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES (?, ?, ?, ? )";

	
	
/*******************************************************METHODES-FIND-ALL-ENCHERE*************************************************************/
/**
* Méthode pour afficher un l'utilisateur présent en BDD via son no_utilisateur.
* Cette méthode est utilisée pour l'affichage des enchères en mode connecté. 

	public List<Enchere> fin_all_enchere() {
		
		List<Enchere> list = new ArrayList<>();
		
		try (Connection cnx = JdbcTools.getConnection()) {
			 PreparedStatement statement = cnx.prepareStatement(FIND_ALL_ENCHERE);
			 ResultSet rs = statement.executeQuery();
			 
			while (rs.next()) {
				Enchere enchere = new Enchere();
				enchere.setNo_enchere(rs.getInt("no_enchere"));
				enchere.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				
				
				list.add(enchere);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
*/
	
	
	
@Override
public Boolean selecEnchereByArticle(Enchere enchere) {
	boolean enchereExiste = false;
	
	try (Connection cnx = JdbcTools.getConnection()){
		PreparedStatement pmst = cnx.prepareStatement(SELECT_ENCHERE_BY_ARTICLE);
		pmst.setInt(1, enchere.getArticle().getNoArticle());
		
		ResultSet rs = pmst.executeQuery();
		
		if (rs.next()) {
			enchereExiste = true;
			return enchereExiste;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return null;
}



@Override
public Object insertNewEnchere(Enchere enchere) {
	try (Connection cnx = JdbcTools.getConnection()){
		PreparedStatement pstmnt = cnx.prepareStatement(INSERT_NEW_ENCHERE);
		pstmnt.setTimestamp(1, enchere.getDateEnchere());
		pstmnt.setInt(2, enchere.getMontant_enchere());
		pstmnt.setInt(3, enchere.getArticle().getNoArticle());
		pstmnt.setInt(4, enchere.getUtilisateur().getNoUtilisateur());
		
		pstmnt.executeUpdate();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}


	
}

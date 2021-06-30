package fr.eni.dal.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
/*******************************************************METHODES-FIND-ALL-ENCHERE*************************************************************/
/**
* Méthode pour afficher un l'utilisateur présent en BDD via son no_utilisateur.
* Cette méthode est utilisée pour l'affichage des enchères en mode connecté. 
*/
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


	
}

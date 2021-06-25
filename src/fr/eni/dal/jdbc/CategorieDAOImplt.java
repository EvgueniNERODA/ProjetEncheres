package fr.eni.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Categorie;
import fr.eni.dal.CategorieDAO;
import fr.eni.dal.JdbcTools;

public class CategorieDAOImplt implements CategorieDAO {
	
	
	private static final String INSERT_NEW_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie, no_retrait, etat) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?) ";  
	private static final String INSERT_NEW_RETRAIT = "INSERT INTO RETRAITS (rue, code_postal, ville) VALUES (?, ?, ?)";	
	private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM CATEGORIES";

	
	/*******************************************************METHODES-SELECTION-CATEGORIES***************************************************************/
	/**
	 * méthode de séléction de toutes les catégories présentes en BDD
	 * retourne une liste de catégories
	 */
	@Override
	public List selectCategories() {
		List<Categorie> listeCategories = new ArrayList();
		try (Connection cnx = JdbcTools.getConnection()) {
			Statement statement = cnx.createStatement();
			ResultSet rs = statement.executeQuery(SELECT_ALL_CATEGORIES);
			
			while (rs.next()) {
				Categorie categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
				listeCategories.add(categorie);
				
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return listeCategories;
	}

}

package fr.eni.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.JdbcTools;
import fr.eni.dal.UtilisateurDAO;

public class UtilisateurDAOImplt implements UtilisateurDAO {
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM UTILISATEUR WHERE email=? AND mot_de_passe =?";
	private static final String FIND_BY_PSEUDO = "SELECT * FROM UTILISATEUR WHERE pseudo=? AND mot_de_passe=?";
	
	@Override
	public boolean verifier(Utilisateur utilisateur) {
		boolean existe = false;

		if(utilisateur.getEmail() != null) {
			try(Connection cnx = JdbcTools.getConnection()) {
				PreparedStatement pstmt = cnx.prepareStatement(FIND_BY_EMAIL);
				pstmt.setString(1, utilisateur.getEmail());
				pstmt.setString(2, utilisateur.getMotDePasse());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt("idUtilisateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setCodePostal(rs.getString("codePostal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
					existe = true;
				}
			} catch (SQLException e) {
				
			}
		}else {
			try (Connection cnx = JdbcTools.getConnection()){
				PreparedStatement pstmt = cnx.prepareStatement(FIND_BY_PSEUDO);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getMotDePasse());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt("idUtilisateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setCodePostal(rs.getString("codePostal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
					existe = true;
				}
			} catch (SQLException e) {
				
			}
		}

		return existe;
	}

	@Override
	public Utilisateur selectPseudo(String pseudo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

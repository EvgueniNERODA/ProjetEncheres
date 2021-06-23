package fr.eni.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.JdbcTools;
import fr.eni.dal.UtilisateurDAO;
import sun.security.mscapi.CKeyPairGenerator.RSA;

public class UtilisateurDAOImplt implements UtilisateurDAO {
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe =?";
	private static final String FIND_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo=? AND mot_de_passe=?";

	private static final String SELECT_BY_MAIL = "SELECT email FROM UTILISATEURS WHERE email=?";
	private static final String SELECT_BY_PSEUDO = "SELECT pseudo FROM UTILISATEURS WHERE pseudo=?";
	private static final String INSERT_NEW_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	
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
					utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setCodePostal(rs.getString("code_postal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
					existe = true;
				}
			} catch (SQLException e) {
				//TODO : handle exception
				e.printStackTrace();
			}
		}else {
			try (Connection cnx = JdbcTools.getConnection()){
				PreparedStatement pstmt = cnx.prepareStatement(FIND_BY_PSEUDO);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getMotDePasse());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setCodePostal(rs.getString("code_postal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
					existe = true;
				}
			} catch (SQLException e) {
				//TODO : handle exception
				e.printStackTrace();
			}
		}

		return existe;
	}

	@Override
	public Utilisateur selectPseudo(String pseudo) {
		
		Utilisateur utilisateur = new Utilisateur();
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			pstmt.setString(1, pseudo);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			
			utilisateur = new Utilisateur(rs.getString("pseudo"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public Utilisateur selectMail(String email) {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_MAIL);
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			
			utilisateur = new Utilisateur(rs.getString("email"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public void insertNouvelUtilisateur(Utilisateur utilisateur) {
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_NEW_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.isAdministrateur());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	

}

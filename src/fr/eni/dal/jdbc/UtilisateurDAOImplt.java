package fr.eni.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.JdbcTools;

public class UtilisateurDAOImplt {
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM UTILISATEUR WHERE email=? AND motDePasse =?";
	private static final String FIND_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo=? AND motDePasse=?";
	
	
	public boolean verifier(Utilisateur utilisateur) throws BuisnessException {
		boolean existe = false;

		if(utilisateur.getEmail() != null) {
			try {
				PreparedStatement pstmt = connectionProvider.getInstance().prepareStatement(FIND_BY_EMAIL);
				pstmt.setString(1, utilisateur.getEmail());
				pstmt.setString(2, utilisateur.getMotDePasse());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					utilisateur.setIdUtilisateur(rs.getInt("idUtilisateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setCodePostal(rs.getString("codePostal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("motDePasse"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
					existe = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log = new Log(e.getMessage());
				BuisnessException buisnessException = new BuisnessException(e.getMessage(), e);
				throw buisnessException;
			}
		}else {
			try {
				PreparedStatement pstmt = connectionProvider.getInstance().prepareStatement(FIND_BY_PSEUDO);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getMotDePasse());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					utilisateur.setIdUtilisateur(rs.getInt("idUtilisateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setCodePostal(rs.getString("codePostal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("motDePasse"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
					existe = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log = new Log(e.getMessage());
				BuisnessException buisnessException = new BuisnessException(e.getMessage(), e);
				throw buisnessException;
			}
		}

		return existe;
	}
}

package fr.eni.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import fr.eni.bo.Utilisateur;
import fr.eni.dal.JdbcTools;
import fr.eni.dal.UtilisateurDAO;

/**
 * 
 * Classe UtilisateurDAOImplt.
 * Elle est utilisée pour la création des requêtes SQL pour la BDD Microsoft SQL Server.
 *
 */
public class UtilisateurDAOImplt implements UtilisateurDAO {
	
	private static final String FIND_USER = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String FIND_BY_EMAIL = "SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe =?";
	private static final String FIND_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo=? AND mot_de_passe=?";
	private static final String FIND_USER_BY_EMAIL_OR_PSEUDO ="SELECT statut FROM UTILISATEURS WHERE email=? OR pseudo=?";
	private static final String SELECT_BY_MAIL = "SELECT email FROM UTILISATEURS WHERE email=?";
	private static final String SELECT_BY_PSEUDO = "SELECT pseudo FROM UTILISATEURS WHERE pseudo=?";
	private static final String INSERT_NEW_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, statut) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	private static final String SELECT_ALL = "SELECT * FROM UTILISATEURS WHERE pseudo=?";
	private static final String UPDATE_USER_BY_ID = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, statut=? WHERE no_utilisateur=?";
	private static final String UPDATE_STATUT_USER = "UPDATE UTILISATEURS SET statut=? WHERE no_utilisateur=?";
	private static final String DELETE_USER_BY_ID = "DELETE UTILISATEURS WHERE no_utilisateur=?";

	
	
/*******************************************************METHODES-FINDUSER***************************************************************/
/**
* Méthode pour afficher un l'utilisateur présent en BDD via son no_utilisateur.
* Cette méthode est utilisée pour lors de l'affichage de la page modif profil sur le site d'enchère. 
*/
	@Override
	public Utilisateur find_user(int noUtilisateur) {
		Utilisateur utilisateur = new Utilisateur();
		
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(FIND_USER);
			pstmt.setInt(1, noUtilisateur);
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
				utilisateur.setStatut(rs.getBoolean("statut"));
			}
		} catch (SQLException e) {
			//TODO : handle exception
			e.printStackTrace();
		}
	return utilisateur;
}

/*******************************************************METHODES-VERIFIER***************************************************************/
/**
 * Méthode pour vérifier si l'utilisateur existe en BDD via son adresse mail ou son pseudo.
 * Cette méthode est utilisée pour la connexion sur le site d'enchère. 
 */
	
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

/*******************************************************METHODES-SELECTPSEUDO***************************************************************/
/**
* Méthode pour vérifier si le pseudo existe déjà BDD.
* Cette méthode est utilisée lors de la création d'un utilisateur sur le site d'enchère. 
*/
	@Override
	public String selectPseudo(String pseudo) {
		String pseudoBdd = "";
		
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			pstmt.setString(1, pseudo);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			pseudoBdd = rs.getString("pseudo");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pseudoBdd;
	}

/*******************************************************METHODES-SELECTMAIL***************************************************************/
/**
* Méthode pour vérifier si le mail existe déjà BDD.
* Cette méthode est utilisée lors de la création d'un utilisateur sur le site d'enchère. 
*/
	@Override
	public String selectMail(String email) {
		String mailBdd = "";
		
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_MAIL);
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			
			mailBdd = rs.getString("email");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mailBdd;
	}

/*************************************************METHODES-INSERTNOUVEL-UTILISATEUR***************************************************************/
/**
* Méthode pour inserer un nouvel utilisateur dans la BDD.
* Cette méthode est utilisée lors de la création d'un utilisateur sur le site d'enchère. 
*/
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
			pstmt.setBoolean(12, utilisateur.isStatut());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
/*************************************************METHODES-INSERTNOUVEL-UTILISATEUR***************************************************************/
/**
* Méthode pour afficher un l'utilisateur présent en BDD via son pseudo.
* Utilisée dans ServletInscription pour rappeler l'utilisateur nouvellement crée. 
*/
	@Override
	public Utilisateur selectAll(String pseudo) {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			pstmt.setString(1, pseudo);
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
				utilisateur.setStatut(rs.getBoolean("statut"));
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return utilisateur;
}


/*************************************************METHODES-UPDATE-USER-BY-ID***************************************************************/
/**
* Méthode pour modifier un utilisateur déjà présent en BDD.
* Cette méthode est utilisée lors de la modification d'un profil utilisateur. 
*/

	
	public void updateUserById(Utilisateur utilisateur) {
		
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_USER_BY_ID);
			
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setBoolean(10, utilisateur.isStatut());
			pstmt.setInt(11,utilisateur.getNoUtilisateur());
			pstmt.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

/*************************************************METHODES-DELETE-USER-BY-ID***************************************************************/
/**
* Méthode pour supprimer un utilisateur déjà présent en BDD.
* Cette méthode est utilisée lors de la suppression d'un compte dans la page modifProfil lorsqu'on est connecté
* en tant qu'Administrateur. 
*/
	@Override
	public void deleteUserById(Utilisateur utilisateur) {
		
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_USER_BY_ID);

			pstmt.setInt(1, utilisateur.getNoUtilisateur());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
/*************************************************METHODES-UPDATE-STATUT-USER-BY-ID***************************************************************/
/**
* Méthode pour mettre le statut d'un utilisateur déjà présent en BDD en inactif.
* Cette méthode est utilisée lors de la suppression d'un compte dans la page modifProfil lorsqu'on est pas connecté
* en tant qu'administrateur. 
*/
	@Override
	public void updateStatutUser(Utilisateur utilisateur, boolean nouveauStatut) {
		
		try (Connection cnx = JdbcTools.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_STATUT_USER);
		
		pstmt.setInt(1, utilisateur.getNoUtilisateur());
		pstmt.setBoolean(2, utilisateur.isStatut(nouveauStatut));
	
		pstmt.executeUpdate();
		
		}catch (SQLException e) {
		e.printStackTrace();
		}
	}
	
	
/*******************************************************METHODES-FIND-USER-BY-EMAIL-OR-PSEUDO***************************************************************/
/**
* Méthode pour afficher un l'utilisateur présent en BDD via son identifiant.
* Cette méthode est utilisée pour lors de la vérification d'un profil actif ou inactif. 
*/
	
	public Utilisateur find_user_by_email_or_pseudo(Utilisateur utilisateur){
		
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(FIND_USER_BY_EMAIL_OR_PSEUDO);
			pstmt.setString(1, utilisateur.getEmail());
			pstmt.setString(2, utilisateur.getPseudo());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				utilisateur.setStatut(rs.getBoolean("statut"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return utilisateur;
	}
	
	
	
	
}

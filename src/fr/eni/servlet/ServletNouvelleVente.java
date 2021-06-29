package fr.eni.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

import fr.eni.bll.ArticleManager;
import fr.eni.bll.CategorieManager;
import fr.eni.bll.RetraitManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Article;
import fr.eni.bo.Categorie;
import fr.eni.bo.Retrait;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.RetraitDAO;
import fr.eni.outils.BusinessException;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * méthode DO GET récupère uen liste de catégories et les affiche dans le
	 * sélécteur de la page Nouvelle vente récupère l'adresse du vendeur et
	 * l'affiche par défaut
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Categorie> listesCategories = CategorieManager.getInstance().selectCategories();

		request.setAttribute("listesCategories", listesCategories);

		// On récupère la session
		HttpSession session = request.getSession();
		int idUtilisateur = (int) session.getAttribute("noUtilisateur");

		// récupération de l'adresse du vendeur
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateurEnCours = new Utilisateur();

		try {
			utilisateurEnCours = utilisateurManager.find_user(idUtilisateur);
		} catch (BusinessException e) {

			e.printStackTrace();
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}

		// récupération de l'adresse du vendeur
		String rueDefaut = utilisateurEnCours.getRue();
		String cpDefaut = utilisateurEnCours.getCodePostal();
		String villeDefaut = utilisateurEnCours.getVille();

		request.setAttribute("rueDefaut", rueDefaut);
		request.setAttribute("cpDefaut", cpDefaut);
		request.setAttribute("villeDefaut", villeDefaut);

		// renvoi vers la page Nouvelle Vente
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp");
		rd.forward(request, response);

	}

	/**
	 * méthode DoPost récupères les information saisies par le vendeur les vérifie et insère un
	 * nouvel article
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// initialisation des variables
		String nomArticle = "";
		String description = "";
		Integer categorie = 0;
		int miseAPrix = 0;
		LocalDate dateDebutEnchere = null;
		LocalDate dateFinEnchere = null;
		String rue = "";
		String codePostal = "";
		String ville = "";

		// récupération saisie utilisateur
		nomArticle = request.getParameter("nom");
		description = request.getParameter("description");
		categorie = Integer.valueOf(request.getParameter("categorie"));
		miseAPrix = Integer.valueOf(request.getParameter("prixInitial"));
		dateDebutEnchere = LocalDate.parse(request.getParameter("dateDebut"));
		dateFinEnchere = LocalDate.parse(request.getParameter("dateFin"));

		// création instance catégorie
		Categorie novelleCategorie = new Categorie(categorie);
		novelleCategorie.setNoCategorie(categorie);

		// On récupère la session
		HttpSession session = request.getSession();
		int idUtilisateur = (int) session.getAttribute("noUtilisateur");

		// récupération de l'adresse du vendeur
		Utilisateur utilisateurEnCours = new Utilisateur();

		try {
			utilisateurEnCours = UtilisateurManager.getInstance().find_user(idUtilisateur);
		} catch (BusinessException e) {

			e.printStackTrace();
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}

		// remplissage des champs d'adresse si le vendeur n'a rien renseigné
		if (rue.isEmpty()) {
			rue = utilisateurEnCours.getRue();
		}
		if (codePostal.isEmpty()) {
			codePostal = utilisateurEnCours.getCodePostal();
		}
		if (ville.isEmpty()) {
			ville = utilisateurEnCours.getVille();
		}

		
		try {

			// création nouveau Retrait

			Retrait nouveauRetrait = new Retrait(rue, codePostal, ville);

			// insertion du nouvel article
			ArticleManager manager = new ArticleManager();
			Article nouvelArticle = new Article(nomArticle, description, dateDebutEnchere, dateFinEnchere, miseAPrix,
					utilisateurEnCours, novelleCategorie, nouveauRetrait);

			manager.inserNouvelArticle(nouvelArticle);

			//rediréctin vers la page d'accueil en mode connecté
			session.setAttribute("noUtilisateur", utilisateurEnCours.getNoUtilisateur());
			response.sendRedirect("./ServletAccueilConnecte");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

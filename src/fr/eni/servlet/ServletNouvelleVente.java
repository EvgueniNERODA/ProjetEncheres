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

import fr.eni.bll.ArticleManager;
import fr.eni.bll.CategorieManager;
import fr.eni.bll.RetraitManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Article;
import fr.eni.bo.Categorie;
import fr.eni.bo.Retrait;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.RetraitDAO;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategorieManager manager = new CategorieManager();
		// séléction des catégories présentes en BDD

		List<Categorie> listesCategories = CategorieManager.getInstance().selectCategories();
		System.out.println(listesCategories);
		
		int pos = listesCategories.indexOf("Ameublement");
		System.out.println(pos);
		request.setAttribute("listesCategories", listesCategories);
		

		// On récupère la session
		HttpSession session = request.getSession();
		//int idUtilisateur = (int) session.getAttribute("noUtilisateur");
		//System.out.println(idUtilisateur);
		
		int idUtilisateur = 2;
		
		

		// récupération de l'adresse du vendeur
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateurEnCours = utilisateurManager.find_user(idUtilisateur);
		System.out.println(utilisateurEnCours);
		String rueDefaut = utilisateurEnCours.getRue();
		String cpDefaut = utilisateurEnCours.getCodePostal();
		String villeDefaut = utilisateurEnCours.getVille();

		System.out.println(utilisateurEnCours);
		
		request.setAttribute("rueDefaut", rueDefaut);
		request.setAttribute("cpDefaut", cpDefaut);
		request.setAttribute("villeDefaut", villeDefaut);

		// renvoi vers la page Nouvelle Vente
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nomArticle = "";
		String description = "";
		int categorie = 0;
		int miseAPrix = 0;
		LocalDate dateDebutEnchere = null;
		LocalDate dateFinEnchere = null;
		String rue = "";
		String codePostal ="";
		String ville = "";
		
		
		//récupération saisie utilisateur
		nomArticle = request.getParameter("nom");
		description = request.getParameter("description");
		categorie =  Integer.valueOf(request.getParameter("categorie")) ;
		miseAPrix = Integer.valueOf(request.getParameter("prixInitial"));
		dateDebutEnchere = LocalDate.parse(request.getParameter("dateDebut"));
		dateFinEnchere = LocalDate.parse(request.getParameter("dateFin"));
		rue = request.getParameter("rue");
		codePostal = request.getParameter("cp");
		ville = request.getParameter("ville");
		
		
		System.out.println(categorie);
		
		//On récupère la session
				HttpSession session = request.getSession();
				int idUtilisateur = (int)session.getAttribute("noUtilisateur");	
		
		//insertion du nouvel article
		try {
		//insertion retrait
			RetraitManager retraitManager = new RetraitManager();
			Retrait nouveauRetrait = new Retrait(rue, codePostal, ville);
			retraitManager.insertRetrait(nouveauRetrait).getNoRetrait();
			
			System.out.println(nouveauRetrait.getNoRetrait());
						
			
			ArticleManager manager = new ArticleManager();
			Article nouvelArticle = new Article(nomArticle, description, dateDebutEnchere, dateFinEnchere, miseAPrix, idUtilisateur, categorie, nouveauRetrait.getNoRetrait());
		} catch (Exception e) {
			
		}
		
		
	}

}

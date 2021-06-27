package fr.eni.outils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Creation de la classe BusinessException
 * Classe de gestion des exceptions des implémentations.
 *
 */
public class BusinessException extends Exception {
	
	private List<Integer> listeCodesErreur;
		
		public BusinessException() {
			super();
			listeCodesErreur = new ArrayList<>();
		}
		
		public void ajouterErreur(int code) {
			if(!listeCodesErreur.contains(code)) {
				listeCodesErreur.add(code);
			}
		}
		
		public boolean hasErreurs() {
			return listeCodesErreur.size() > 0;
		}
	
		public List<Integer> getListeCodesErreur() {
			return listeCodesErreur;
	}
	
}

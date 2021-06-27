package fr.eni.dal;

public abstract class CodesResultatDAL {
	
		//Echec général lors de la tentative d'ajouter un objet null
		public static final int INSERT_OBJECT_NULL = 10_000;
		
		//Echec général  erreur non gérée à l'insertion (ex : erreur de connexion)
		public static final int INSERT_OBJECT_ECHEC = 10_001;
		
		//Echec de l'insertion d'un avis à cause de la note (non incluse entre 1 et 5)
		public static final int INSERT_AVIS_NOTE_ECHEC = 10_002;
}

package fr.eni.dal;

import fr.eni.bo.Enchere;

public interface EnchereDAO {

	Boolean selecEnchereByArticle(Enchere enchere);

	Object insertNewEnchere(Enchere enchere);

	
}

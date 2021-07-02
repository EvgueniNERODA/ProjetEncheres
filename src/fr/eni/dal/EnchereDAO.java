package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Enchere;

public interface EnchereDAO {

	Boolean selecEnchereByArticle(Enchere enchere);

	Object insertNewEnchere(Enchere enchere);

	List<Enchere> selectEnchereMaxById(int idArticle);

	
}

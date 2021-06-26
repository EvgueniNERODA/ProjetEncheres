package fr.eni.dal;

import fr.eni.bo.Retrait;

/**
 * 
 * Interface RetraitDAO.
 * permet de faire appel aux méthodes définies dans RetraitDAOImplt.
 *
 */
public interface RetraitDAO {

	Retrait insertRetrait(Retrait retrait);

}

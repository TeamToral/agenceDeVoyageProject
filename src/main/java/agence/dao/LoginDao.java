package agence.dao;

import agence.model.Login;

/**
 * Interface qui hérite de Dao afin de préciser quel sera le type de donnée
 * récupéré.
 * En l'occurrence : Login
 * De plus, on renseigne le type de la clé : ici, Integer
 * 
 * @author oxifou
 */

public interface LoginDao extends Dao<Login, Integer>
{
	
}

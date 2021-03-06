package agence.dao;

import java.util.List;

import agence.model.ClientPhysique;

/**
 * Contrat que tous les DAOs devront respecter.
 * 
 * @author ajc
 *
 * @param <T>
 * @param <PK>
 */
public interface Dao<ClientPhysique, Integer>
{
    /**
     * Retourne la liste de tous les objets métiers de la source de données
     * 
     * @return Liste des objets métiers de la source de données
     */
    List<ClientPhysique> findAll();

    /**
     * Retourne un objet métier en fonction de sa clé primaire
     * 
     * @param id
     *            Clé primaire
     * @return L'objet métier trouvé
     */
    ClientPhysique findById(Integer id);

}

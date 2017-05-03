/**
 * 
 */
package agence;

import java.util.List;
import agence.dao.AdresseDao;

import agence.dao.AdresseDaoSql;import agence.dao.AeroportDaoSql;import agence.dao.ClientMoralDaoSql;
import agence.dao.ClientPhysiqueDaoSql;
import agence.dao.PassagerDao;
import agence.dao.PassagerDaoSql;
import agence.dao.ReservationDao;
import agence.dao.ReservationDaoSql;import agence.dao.VilleDaoSql;import agence.model.Adresse;import agence.model.Aeroport;import agence.model.Client;
import agence.model.ClientMoral;
import agence.model.Passager;
import agence.model.ClientPhysique;
import agence.model.Reservation;import agence.model.Ville;import agence.model.ClientPhysique;
import agence.model.Reservation;

/**
 * Classe principale de test de récupération de données via la BDD
 * 
 * @author Seme
 */
public class MainDB
{

    
    public static void main(String[] args)
    {
        AdresseDao adresseDao = new AdresseDaoSql();
        // J'instancie le dao SQL des adresses
        // J'appelle la méthode findAll pour récupérer toutes les adresses
        // stockées en BDD
        List<Adresse> listeAdresses = adresseDao.findAll();
        Adresse adresse = adresseDao.findById(1);
        System.out.println(listeAdresses);

        // J'instancie le dao SQL de l'objet métier à récupérer
        PassagerDao passagerDao = new PassagerDaoSql();
        // J'appelle la méthode findAll pour récupérer tous les BO de ce type de
        // la BDD
        List<Passager> listePassagers = passagerDao.findAll();
        Passager passager = passagerDao.findById(1);
        System.out.println(passager);
        // J'instancie le dao SQL de l'objet métier à récupérer
        ReservationDao reservationDao = new ReservationDaoSql();
        // J'appelle la méthode findAll pour récupérer tous les BO de ce type de
        // la BDD
        List<Reservation> listeReservations = reservationDao.findAll();
        Reservation reservation = reservationDao.findById(10);
        listeReservations = reservationDao.findByPassager(passager);
        System.out.println(listeReservations);
       
        ClientPhysiqueDaoSql ClientPhysiqueDaoSql = new ClientPhysiqueDaoSql();
        // J'appelle la m�thode findAll pour r�cup�rer tous les BO de ce type de
        // la BDD
        List<ClientPhysique> listeClientPhysique = ClientPhysiqueDaoSql.findAll();
        ClientPhysique clientPhysique = ClientPhysiqueDaoSql.findById(50);
        System.out.println(clientPhysique);

        ClientMoralDaoSql ClientMoralDaoSql = new ClientMoralDaoSql();
        // J'appelle la m�thode findAll pour r�cup�rer tous les BO de ce type de
        // la BDD
        List<ClientMoral> listeClientMoral = ClientMoralDaoSql.findAll();
        ClientMoral clientMoral = ClientMoralDaoSql.findById(12);
       System.out.println(listeClientMoral);                VilleDaoSql villeDaoSql = new VilleDaoSql();		List<Ville> ListeVilles = villeDaoSql.findAll();		Ville ville = villeDaoSql.findById(1);		System.out.println(ListeVilles);		System.out.println(ville);		// Test sur aeroports		AeroportDaoSql aeroportSql = new AeroportDaoSql();		List<Aeroport> ListeAeroport = aeroportSql.findAll();		Aeroport aeroport = aeroportSql.findById(3);		System.out.println(ListeAeroport);		System.out.println(aeroport);				//List<Aeroport> aeroportByCommune = aeroportSql.findByCommune(ville);		//System.out.println(aeroportByCommune);    }
}

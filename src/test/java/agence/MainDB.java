/**
 * 
 */
package agence;

import java.util.List;

import agence.dao.AdresseDao;
import agence.dao.AdresseDaoSql;
import agence.dao.LoginDao;
import agence.dao.LoginDaoSql;
import agence.dao.PassagerDao;
import agence.dao.PassagerDaoSql;
import agence.dao.ReservationDao;
import agence.dao.ReservationDaoSql;
import agence.model.Adresse;
import agence.model.Login;
import agence.model.Passager;
import agence.model.Reservation;

/**
 * Classe principale de test de récupération de données via la BDD
 * 
 * @author Seme
 */
public class MainDB
{

    /**
     * Méthode principale qui va faire appel à toutes les méthodes de
     * récupération
     * de mes DAO SQL :
     * - findAll
     * - findById
     * 
     * @param args
     *            Arguments passés en paramètres d'entrée
     */
    public static void main(String[] args)
    {
        // J'instancie le dao SQL des adresses
        AdresseDao adresseDao = new AdresseDaoSql();
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

        // J'instancie le dao SQL de l'objet métier à récupérer
        ReservationDao reservationDao = new ReservationDaoSql();
        // J'appelle la méthode findAll pour récupérer tous les BO de ce type de
        // la BDD
        List<Reservation> listeReservations = reservationDao.findAll();
        Reservation reservation = reservationDao.findById(10);
        listeReservations = reservationDao.findByPassager(passager);
        
        // J'instancie le dao SQL de l'objetm�tier � r�cup�rer
        LoginDao loginDao = new LoginDaoSql();
        // J'appelle la méthode findAll pour récupérer tous les BO de ce type de
        // la BDD
        List<Login> listeLogin = loginDao.findAll();
        System.out.println(listeLogin);
        Login login = loginDao.findById(1);
        System.out.println(login);
        
        

    }

}

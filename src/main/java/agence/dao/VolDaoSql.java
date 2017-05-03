package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import agence.model.Aeroport;
import agence.model.Vol;

public class VolDaoSql implements VolDao {
	AeroportDao aeroportDao = new AeroportDaoSql();

	/*
	 * (non-Javadoc)
	 * 
	 * @see agence.dao.Dao#findAll()
	 */
	@Override
	public List<Vol> findAll() {
		// Initialiser ma liste d'objets métier
		List<Vol> listeBO = new ArrayList<>();
		// Init du format de la date
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
		try {
			/*
			 * Etape 0 : chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * Etape 1 : se connecter à la BDD
			 */
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user",
					"password");

			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM vol");

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				Vol bo = new Vol();

				// appel des mutateurs
				bo.setIdVol(resultSet.getInt("idVol"));
				// bo.setDate(simpleDateFormate
				// .parse(resultSet.getString("dateReservation")));
				bo.setDateDepart(resultSet.getDate("dateDepart"));
				bo.setDateArrivee(resultSet.getDate("dateArrivee"));
				bo.setHeureDepart(resultSet.getTime("heureDepart"));
				bo.setHeureArrivee(resultSet.getTime("heureArrivee"));
				bo.setAeroportDepart(aeroportDao.findById(resultSet.getInt("idAeroportDepart")));
				bo.setAeroportDepart(aeroportDao.findById(resultSet.getInt("idAeroportArrivee")));
				// j'ajoute l'objet métier ainsi muté à la liste des objets
				// métier
				listeBO.add(bo);
			}

			/*
			 * Etape 5 : je ferme la connexion à la BDD
			 */
			connexion.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// catch (ParseException e)
		// {
		// System.err.println("Impossible de parser la date.");
		// e.printStackTrace();
		// }
		// Je retourne la liste des passagers de la BDDonnéys
		return listeBO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see agence.dao.Dao#findById(java.lang.Object)
	 */
	@Override
	public Vol findById(Integer idVol) {
		// Initialiser mon bo
		Vol bo = null;
		// Init du format de la date
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
		try {
			/*
			 * Etape 0 : chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * Etape 1 : se connecter à la BDD
			 */
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user",
					"password");

			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Exécution de la requête SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Vol WHERE idVol = " + idVol);

			/*
			 * Etape 4 : Parcours des résultats
			 */
			if (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				bo = new Vol();
				// appel des mutateurs
				bo.setIdVol(resultSet.getInt("idVol"));
				// bo.setDate(simpleDateFormat
				// .parse(resultSet.getString("dateReservation")));
				bo.setDateDepart(resultSet.getDate("dateDepart"));
				bo.setDateArrivee(resultSet.getDate("dateArrivee"));
				bo.setHeureDepart(resultSet.getTime("heureDepart"));
				bo.setHeureArrivee(resultSet.getTime("heureArrivee"));
				bo.setAeroportDepart(aeroportDao.findById(resultSet.getInt("idAeroportDepart")));
				bo.setAeroportDepart(aeroportDao.findById(resultSet.getInt("idAeroportArrivee")));
			}

			/*
			 * Etape 5 : je ferme la connexion à la BDD
			 */
			connexion.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// catch (ParseException e)
		// {
		// System.err.println("Impossible de parser la date.");
		// e.printStackTrace();
		// }
		// Je retourne l'objet métier
		return bo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see agence.dao.ReservationDao#findByPassager(agence.model.Passager)
	 */

	public List<Vol> findByAeroport(Aeroport aeroport)
    {
        // Initialiser ma liste d'objets métier
        List<Vol> listeBO = new ArrayList<>();
        try
        {
            /*
             * Etape 0 : chargement du pilote
             */
            Class.forName("com.mysql.jdbc.Driver");

            /*
             * Etape 1 : se connecter à la BDD
             */
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/agence", "user", "password");

            /*
             * Etape 2 : Création du statement
             */
            Statement statement = connexion.createStatement();

            /*
             * Etape 3 : Exécution de la requête SQL
             */
            ResultSet resultSet = statement.executeQuery("SELECT * FROM vol WHERE idAeroportDepart = " + aeroport.getIdAero() + "OR WHERE idAeroportArrivee = " + aeroport.getIdAero() ) ;

            /*
             * Etape 4 : Parcours des résultats
             */
			while (resultSet.next()) {
                // Chaque ligne du tableau de résultat peut être exploitée
                // cad, on va récupérer chaque valeur de chaque colonne
                // je crée l'objet métier
            	 Vol bo = new Vol();
                 // appel des mutateurs
                 bo.setIdVol(resultSet.getInt("idVol"));
                 // bo.setDate(simpleDateFormat
                 // .parse(resultSet.getString("dateReservation")));
                 bo.setDateDepart(resultSet.getDate("dateDepart"));
                 bo.setDateArrivee(resultSet.getDate("dateArrivee"));
                 bo.setHeureDepart(resultSet.getTime("heureDepart"));
                 bo.setHeureArrivee(resultSet.getTime("heureArrivee"));
                 bo.setAeroportDepart(
                         aeroportDao.findById(resultSet.getInt("idAeroportDepart")));
                 bo.setAeroportDepart(
                         aeroportDao.findById(resultSet.getInt("idAeroportArrivee")));
                 // j'ajoute l'objet métier ainsi muté à la liste des objets
                 // métier
                // j'ajoute l'objet métier ainsi muté à la liste des objets
                // métier
                listeBO.add(bo);
            }

            /*
             * Etape 5 : je ferme la connexion à la BDD
             */
            connexion.close();
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Impossible de charger le pilote JDBC.");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la BDD.");
            e.printStackTrace();
        }
        // Je retourne la liste des passagers de la BDDonnéys
        return listeBO;
    }

}

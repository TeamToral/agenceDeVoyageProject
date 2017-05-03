package agence.dao;

import agence.model.CompagnieAerienne;
import agence.model.Vol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CompagnieAerienneDaoSql implements CompagnieAerienneDao {

	@Override
	public List<CompagnieAerienne> findAll() {
		// Initialiser ma liste d'objets métier
		List<CompagnieAerienne> listeBO = new ArrayList<>();
		VolDao volDao = new VolDaoSql();
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM compagnie_aerienne");

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				CompagnieAerienne bo = new CompagnieAerienne();
				// appel des mutateurs
				bo.setIdCAerienne(resultSet.getInt("id"));
				// bo.setDate(simpleDateFormat
				// .parse(resultSet.getString("dateReservation")));
				bo.setNom(resultSet.getString("nom"));
				bo.setVol(volDao.findById(resultSet.getInt("idVol")));
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
	public CompagnieAerienne findById(Integer idCAerienne) {
		// Initialiser mon bo
		CompagnieAerienne bo = null;
		VolDao volDao = new VolDaoSql();
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM vol WHERE idVol = " + idCAerienne);

			/*
			 * Etape 4 : Parcours des résultats
			 */
			if (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				// je crée l'objet métier
				bo = new CompagnieAerienne();
				// appel des mutateurs
				bo.setIdCAerienne(resultSet.getInt("id"));
				// bo.setDate(simpleDateFormat
				// .parse(resultSet.getString("dateReservation")));
				bo.setNom(resultSet.getString("nom"));
				bo.setVol(volDao.findById(resultSet.getInt("idVol")));
				// j'ajoute l'objet métier ainsi muté à la liste des objets
				// métier
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

	public List<CompagnieAerienne> findByVol(Vol vols) {
		// Initialiser ma liste d'objets métier
		List<CompagnieAerienne> listeBO = new ArrayList<>();
		VolDao volDao = new VolDaoSql();

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
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM CompagnieAerienne WHERE idVol = " + vols.getIdVol());

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet métier
				CompagnieAerienne bo = new CompagnieAerienne();
				// appel des mutateurs
				bo.setIdCAerienne(resultSet.getInt("id"));
				// bo.setDate(simpleDateFormat
				// .parse(resultSet.getString("dateReservation")));
				bo.setNom(resultSet.getString("nom"));
				bo.setVol(volDao.findById(resultSet.getInt("idVol")));
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
		// Je retourne la liste des passagers de la BDDonnéys
		return listeBO;
	}
}

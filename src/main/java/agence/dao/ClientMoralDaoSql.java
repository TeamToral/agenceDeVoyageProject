package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import agence.model.Client;
import agence.model.ClientMoral;
import agence.model.ClientMoral;

public class ClientMoralDaoSql implements ClientMoralDao {

	@Override
	public List<ClientMoral> findAll() {

		// Initialiser ma liste de passagers
		List<ClientMoral> listeClientsMoral = new ArrayList<>();
		try {
			/*
			 * Etape 0 : chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * Etape 1 : se connecter � la BDD
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM client");

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de r�sultat peut �tre exploit�
				// cad, on va r�cup�rer chaque valeur de chaque colonne
				// je cr�� l'objet passager
				ClientMoral clientMoral = new ClientMoral();

				if (resultSet.getString("siret") != null)

				{
					// appel du ou des mutateurs
					clientMoral.setSiret(resultSet.getInt("siret"));
					clientMoral.setIdClient(resultSet.getInt("idClient"));
					clientMoral.setNomClient(resultSet.getString("nom"));
					clientMoral.setNumTel(resultSet.getString("numTel"));
					clientMoral.setNumFax(resultSet.getString("numFax"));
					clientMoral.setEmail(resultSet.getString("eMail"));
					

					// j'ajoute l'objet clientMoral ainsi mut� � la liste des
					// CLients
					listeClientsMoral.add(clientMoral);
				}
				
				
			}
		
			/*
			 * Etape 5 : je ferme la connexion a� la BDD
			 */
			connexion.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter � la BDD.");
			e.printStackTrace();
		}
		// Je retourne la liste des clients de la BDD
		return listeClientsMoral;

	}

	@Override
	public ClientMoral findById(Integer id) {

		// Initialiser mon client physique
		ClientMoral clientMoral = new ClientMoral();

		try {
			/*
			 * Etape 0 : chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * Etape 1 : se connecter � la BDD
			 */
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user",
					"password");

			/*
			 * Etape 2 : Cr�ation du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : Ex�cution de la requ�te SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM client WHERE idClient = " + id);

			// Etape 4 : Parcours des r�sultats

			if (resultSet.next()) {
				// Chaque ligne du tableau de r�sultat peut être exploitée
				// cad, on va r�cup�rer chaque valeur de chaque colonne
				// je cr�� l'objet m�tier
				
				if (resultSet.getString("siret") != null)

				
				clientMoral = new ClientMoral();
				// appel des mutateurs
				clientMoral.setSiret(resultSet.getInt("siret"));
				clientMoral.setIdClient(resultSet.getInt("idClient"));
				clientMoral.setNomClient(resultSet.getString("nom"));
				clientMoral.setNumTel(resultSet.getString("numTel"));
				clientMoral.setNumFax(resultSet.getString("numFax"));
				clientMoral.setEmail(resultSet.getString("eMail"));
			}

			// Etape 5 : je ferme la connexion à la BDD

			connexion.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter � la BDD.");
			e.printStackTrace();
		}
		// Je retourne l'objet m�tier
		return clientMoral;
	}

}

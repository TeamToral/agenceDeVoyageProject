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
			 * Etape 1 : se connecter   la BDD
			 */
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user",
					"password");

			/*
			 * Etape 2 : CrÃ©ation du statement
			 */
			Statement statement = connexion.createStatement();

			/*
			 * Etape 3 : ExÃ©cution de la requÃªte SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM client");

			/*
			 * Etape 4 : Parcours des rÃ©sultats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut être exploité
				// cad, on va récupérer chaque valeur de chaque colonne
				// je créé l'objet passager
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
					

					// j'ajoute l'objet clientMoral ainsi muté à  la liste des
					// CLients
					listeClientsMoral.add(clientMoral);
				}
				
				
			}
		
			/*
			 * Etape 5 : je ferme la connexion a  la BDD
			 */
			connexion.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à  la BDD.");
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
			 * Etape 1 : se connecter à  la BDD
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM client WHERE idClient = " + id);

			// Etape 4 : Parcours des résultats

			if (resultSet.next()) {
				// Chaque ligne du tableau de résultat peut Ãªtre exploitÃ©e
				// cad, on va récupérer chaque valeur de chaque colonne
				// je créé l'objet métier
				
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

			// Etape 5 : je ferme la connexion Ã  la BDD

			connexion.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à  la BDD.");
			e.printStackTrace();
		}
		// Je retourne l'objet métier
		return clientMoral;
	}

}

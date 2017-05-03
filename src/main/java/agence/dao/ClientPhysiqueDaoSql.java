package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import agence.model.Client;
import agence.model.ClientPhysique;
import agence.model.Passager;

public class ClientPhysiqueDaoSql implements ClientPhysiqueDao {

	@Override
	public List<ClientPhysique> findAll() {

		// Initialiser ma liste de passagers
		List<ClientPhysique> listeCLientsPhysique = new ArrayList<>();
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
				ClientPhysique clientPhysique = new ClientPhysique();
				
				if (resultSet.getString("siret") == null)

				{
					// appel du ou des mutateurs
					clientPhysique.setPrenom(resultSet.getString("prenom"));
					clientPhysique.setIdClient(resultSet.getInt("idClient"));
					clientPhysique.setNomClient(resultSet.getString("nom"));
					clientPhysique.setNumTel(resultSet.getString("numTel"));
					clientPhysique.setNumFax(resultSet.getString("numFax"));
					clientPhysique.setEmail(resultSet.getString("email"));
				}

				// j'ajoute l'objet clientPhysique ainsi muté à  la liste des
				// passagers
				listeCLientsPhysique.add(clientPhysique);
			}

			/*
			 * Etape 5 : je ferme la connexion Ã  la BDD
			 */
			connexion.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à  la BDD.");
			e.printStackTrace();
		}
		// Je retourne la liste des passagers de la BDD
		return listeCLientsPhysique;

	}

	@Override
	public ClientPhysique findById(Integer id) {

		// Initialiser mon client physique
		ClientPhysique clientPhysique = new ClientPhysique();

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
				if (resultSet.getString("siret") == null)

				{
					// Chaque ligne du tableau de résultat peut Ãªtre exploitÃ©e
					// cad, on va récupérer chaque valeur de chaque colonne
					// je créé l'objet métier
					clientPhysique = new ClientPhysique();
					// appel des mutateurs
					clientPhysique.setPrenom(resultSet.getString("prenom"));
					clientPhysique.setIdClient(resultSet.getInt("idClient"));
					clientPhysique.setNomClient(resultSet.getString("nom"));
					clientPhysique.setNumTel(resultSet.getString("numTel"));
					clientPhysique.setNumFax(resultSet.getString("numFax"));
					clientPhysique.setEmail(resultSet.getString("eMail"));
				}

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
		return clientPhysique;
	}

}

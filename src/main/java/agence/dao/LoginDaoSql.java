package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import agence.model.Login;

public class LoginDaoSql implements LoginDao
{

	@Override
	public List<Login> findAll()
	{
		// Initialiser ma liste de login
		List<Login> listeLogin = new ArrayList<>();
		try
		{
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM login");

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next())
			{
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet login
				Login login = new Login();
				// appel des mutateurs
				login.setId(resultSet.getInt("id"));
				login.setLogin(resultSet.getString("login"));
				login.setMotDePasse(resultSet.getString("motDePasse"));
				login.setAdmin(resultSet.getBoolean("admin"));
				// j'ajoute l'objet login ainsi muté à la liste des logins
				listeLogin.add(login);
			}

			/*
			 * Etape 5 : je ferme la connexion à la BDD
			 */
			connexion.close();
		} catch (ClassNotFoundException e)
		{
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e)
		{
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// Je retourne la liste des logins de la BDDonnéys
		return listeLogin;
	}

	@Override
	public Login findById(Integer id)
	{
		// Initialiser ma liste de login
		Login login = new Login();
		try
		{
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM login");

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next())
			{
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				if (resultSet.getInt("id") == id)
				{
					// appel des mutateurs
					login.setId(resultSet.getInt("id"));
					login.setLogin(resultSet.getString("login"));
					login.setMotDePasse(resultSet.getString("motDePasse"));
					login.setAdmin(resultSet.getBoolean("admin"));
				}
			}

			/*
			 * Etape 5 : je ferme la connexion à la BDD
			 */
			connexion.close();
		} catch (ClassNotFoundException e)
		{
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} catch (SQLException e)
		{
			System.err.println("Impossible de se connecter à la BDD.");
			e.printStackTrace();
		}
		// Je retourne la liste des logins de la BDDonnéys
		return login;
	}

}

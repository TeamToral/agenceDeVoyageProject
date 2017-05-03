package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import agence.model.Client;
import agence.model.Passager;

public class ClientDaoSql implements ClientDao {

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
		
		// Initialiser ma liste de clients
	    List<Client> listeClients = new ArrayList<>();
	    try
	    {
	        /*
	         * Etape 0 : chargement du pilote
	         */
	        Class.forName("com.mysql.jdbc.Driver");

	        // Etape 1 : se connecter à la BDD
	        Connection connexion = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/agence", "user", "password");

	       // Etape 2 : création du statement
	        Statement statement = connexion.createStatement();

	        // Etape 3: Execution de la requete Sql
	        ResultSet resultSet = statement
	                .executeQuery("SELECT * FROM client");

	        // Etape 4: Parcours des résultats
	        while (resultSet.next())
	        {
	            // Chaque ligne du tableau de rÃ©sultat peut Ãªtre exploitÃ©e
	            // cad, on va récupérer chaque valeur de chaque colonne
	            // je créé l'objet client
	            Client client = new Client();
	           
	            // appel des mutateurs
	            passager.setIdPas(resultSet.getInt("idPassager"));
	            passager.setNom(resultSet.getString("nom"));
	            passager.setPrenom(resultSet.getString("prenom"));
	            passager.setAdresse(adresseDao.findById(resultSet.getInt("idAdd")));
	            // j'ajoute l'objet passager ainsi mutÃ© Ã  la liste des passagers
	            listePassagers.add(passager);
	        }

	        /*
	         * Etape 5 : je ferme la connexion Ã  la BDD
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
	        System.err.println("Impossible de se connecter Ã  la BDD.");
	        e.printStackTrace();
	    }
	    // Je retourne la liste des passagers de la BDDonnÃ©ys
	    return listePassagers;
	}

	@Override
	public Client findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

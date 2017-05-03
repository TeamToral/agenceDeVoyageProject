package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	        // Etape 1 : se connecter � la BDD
	        Connection connexion = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/agence", "user", "password");

	       // Etape 2 : cr�ation du statement
	        Statement statement = connexion.createStatement();

	        /*
	         * Etape 3 : Exécution de la requête SQL
	         */
	        ResultSet resultSet = statement
	                .executeQuery("SELECT * FROM passager");

	        /*
	         * Etape 4 : Parcours des résultats
	         */
	        while (resultSet.next())
	        {
	            // Chaque ligne du tableau de résultat peut être exploitée
	            // cad, on va récupérer chaque valeur de chaque colonne
	            // je crée l'objet passager
	            Passager passager = new Passager();
	            // appel des mutateurs
	            passager.setIdPas(resultSet.getInt("idPassager"));
	            passager.setNom(resultSet.getString("nom"));
	            passager.setPrenom(resultSet.getString("prenom"));
	            passager.setAdresse(adresseDao.findById(resultSet.getInt("idAdd")));
	            // j'ajoute l'objet passager ainsi muté à la liste des passagers
	            listePassagers.add(passager);
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
	    return listePassagers;
	}

	@Override
	public Client findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

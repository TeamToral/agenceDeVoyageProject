package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import agence.model.Aeroport;
import agence.model.Ville;

public class AeroportDaoSql implements AeroportDao {

	
	
	  @Override
	    public List<Aeroport> findAll()
	    {
	        // Initialiser ma liste de villes
	        List<Aeroport> listeAeroport = new ArrayList<>();
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
	            ResultSet resultSet = statement
	                    .executeQuery("SELECT * FROM aeroport");

	            /*
	             * Etape 4 : Parcours des résultats
	             */
	            while (resultSet.next())
	            {
	                // Chaque ligne du tableau de résultat peut être exploitée
	                // cad, on va récupérer chaque valeur de chaque colonne
	                // je crée l'objet ville
	                Aeroport aeroport = new Aeroport();
	                // appel des mutateurs
	                aeroport.setIdAero(resultSet.getInt("idAero"));
	                aeroport.setNom(resultSet.getString("nom"));
	                
	                // j'ajoute l'objet ville ainsi mut� � la liste des villes
	                listeAeroport.add(aeroport);
	            }

	            /*
	             * Etape 5 : je ferme la connexion � la BDD
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
	        return listeAeroport;
	    }

		@Override
		public Aeroport findById(Integer id) {
			 // Initialiser ma liste de villes
	        Aeroport aeroport = new Aeroport();
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
	            ResultSet resultSet = statement
	                    .executeQuery("SELECT * FROM aeroport WHERE idAero="+id);

	            /*
	             * Etape 4 : Parcours des résultats
	             */
	           if (resultSet.next())
	            {
	                // Chaque ligne du tableau de résultat peut être exploitée
	                // cad, on va récupérer chaque valeur de chaque colonne
	                // je crée l'objet ville
	               
	                // appel des mutateurs
	                aeroport.setIdAero(resultSet.getInt("idAero"));
	                aeroport.setNom(resultSet.getString("nom"));
	                
	                // j'ajoute l'objet ville ainsi mut� � la liste des villes
	                
	            }

	            /*
	             * Etape 5 : je ferme la connexion � la BDD
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
	        return aeroport;
		}
}

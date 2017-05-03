package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import agence.model.Ville;

public class VilleDaoSql implements VilleDao{

	
	 //VilleDao villeDao = new VilleDaoSql();

	    /*
	     * (non-Javadoc)
	     * @see agence.dao.Dao#findAll()
	     */
	    @Override
	    public List<Ville> findAll()
	    {
	        // Initialiser ma liste de villes
	        List<Ville> listeVille = new ArrayList<>();
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
	                    .executeQuery("SELECT * FROM ville");

	            /*
	             * Etape 4 : Parcours des résultats
	             */
	            while (resultSet.next())
	            {
	                // Chaque ligne du tableau de résultat peut être exploitée
	                // cad, on va récupérer chaque valeur de chaque colonne
	                // je crée l'objet ville
	                Ville ville = new Ville();
	                // appel des mutateurs
	                ville.setIdVille(resultSet.getInt("id"));
	                ville.setNom(resultSet.getString("nom"));
	                
	                // j'ajoute l'objet ville ainsi mut� � la liste des villes
	                listeVille.add(ville);
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
	        return listeVille;
	    }

		@Override
		public Ville findById(Integer id) {
			 // Initialiser ma liste de villes
	        Ville ville = new Ville();
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
	                    .executeQuery("SELECT * FROM ville WHERE id="+id);

	            /*
	             * Etape 4 : Parcours des résultats
	             */
	           if (resultSet.next())
	            {
	                // Chaque ligne du tableau de résultat peut être exploitée
	                // cad, on va récupérer chaque valeur de chaque colonne
	                // je crée l'objet ville
	               
	                // appel des mutateurs
	                ville.setIdVille(resultSet.getInt("id"));
	                ville.setNom(resultSet.getString("nom"));
	                
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
	        return ville;
		}
}

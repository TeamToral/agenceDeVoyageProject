package agence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import agence.model.Escale;
import agence.model.Login;
import agence.model.Vol;

public class EscaleDaoSql implements EscaleDao
{

	@Override
	public List<Escale> findAll()
	{
		// Initialiser ma liste de login
		List<Escale> listeEscale = new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM escale");

			/*
			 * Etape 4 : Parcours des résultats
			 */
			while (resultSet.next())
			{
				// Chaque ligne du tableau de résultat peut être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// je crée l'objet login
				Escale escale = new Escale();
				VolDao vol = new VolDaoSql();
				AeroportDao aero = new AeroportDaoSql();
				// appel des mutateurs
				escale.setIdEscale(resultSet.getInt("idEscale"));
				escale.setVol(vol.findById(resultSet.getInt("idVol")));
				escale.setAeroport(aero.findById(resultSet.getInt("idAeroport")));
				escale.setDateArrivee(resultSet.getDate("dateArrivee"));
				escale.setDateDepart(resultSet.getDate("dateDepart"));
				escale.setHeureDepart(resultSet.getTime("heureDepart"));
				escale.setHeureArrivee(resultSet.getTime("heureArrivee"));
				
				// j'ajoute l'objet login ainsi muté à la liste des logins
				listeEscale.add(escale);
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
		return listeEscale;
	}

	@Override
	public Escale findById(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

}

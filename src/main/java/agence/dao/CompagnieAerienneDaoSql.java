package agence.dao;

import agence.model.CompagnieAerienne;

public class CompagnieAerienneDaoSql implements CompagnieAerienneDao 
{
	VolDao volDao = new VolDaoSql();
	 @Override
	    public List<CompagnieAerienne> findAll()
	    {
	        // Initialiser ma liste d'objets métier
	        List<CompagnieAerienne> listeBO = new ArrayList<>();
	        // Init du format de la date
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
	                    .executeQuery("SELECT * FROM compagnie_aerienne");

	            /*
	             * Etape 4 : Parcours des résultats
	             */
	            while (resultSet.next())
	            {
	                // Chaque ligne du tableau de résultat peut être exploitée
	                // cad, on va récupérer chaque valeur de chaque colonne
	                // je crée l'objet métier
	                CompagnieAerienne bo = new CompagnieAerienne();
	                // appel des mutateurs
	                bo.setIdCAerienne(resultSet.getInt("id"));
	                // bo.setDate(simpleDateFormat
	                // .parse(resultSet.getString("dateReservation")));
	                bo.setNom(resultSet.getString("nom"));
	                bo.setNumero(resultSet.getString("numero"));
	                bo.setPassager(
	                        volDao.findById(resultSet.getInt("idVol")));
	                // j'ajoute l'objet métier ainsi muté à la liste des objets
	                // métier
	                listeBO.add(bo);
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
	     * @see agence.dao.Dao#findById(java.lang.Object)
	     */
	    @Override
	    public CompagnieAerienne findById(Integer idCAerienne)
	    {
	        // Initialiser mon bo
	        Reservation bo = null;
	        // Init du format de la date
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
	            Connection connexion = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/agence", "user", "password");

	            /*
	             * Etape 2 : Création du statement
	             */
	            Statement statement = connexion.createStatement();

	            /*
	             * Etape 3 : Exécution de la requête SQL
	             */
	            ResultSet resultSet = statement.executeQuery(
	                    "SELECT * FROM reservation WHERE idResa = " + id);

	            /*
	             * Etape 4 : Parcours des résultats
	             */
	            if (resultSet.next())
	            {
	                // Chaque ligne du tableau de résultat peut être exploitée
	                // cad, on va récupérer chaque valeur de chaque colonne
	                // je crée l'objet métier
	                bo = new Reservation();
	                // appel des mutateurs
	                bo.setIdRes(resultSet.getInt("idResa"));
	                // bo.setDate(simpleDateFormat
	                // .parse(resultSet.getString("dateReservation")));
	                bo.setDate(resultSet.getDate("dateReservation"));
	                bo.setNumero(resultSet.getString("numero"));
	                bo.setEtat(EtatReservation
	                        .permissiveValueOf(resultSet.getString("etat")));
	                bo.setPassager(
	                        passagerDao.findById(resultSet.getInt("idPassager")));
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
	     * @see agence.dao.ReservationDao#findByPassager(agence.model.Passager)
	     */
	    @Override
	    public List<Reservation> findByPassager(Passager passager)
	    {
	        // Initialiser ma liste d'objets métier
	        List<Reservation> listeBO = new ArrayList<>();
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
	            ResultSet resultSet = statement.executeQuery(
	                    "SELECT * FROM reservation WHERE idPassager = "
	                            + passager.getIdPas());

	            /*
	             * Etape 4 : Parcours des résultats
	             */
	            while (resultSet.next())
	            {
	                // Chaque ligne du tableau de résultat peut être exploitée
	                // cad, on va récupérer chaque valeur de chaque colonne
	                // je crée l'objet métier
	                Reservation bo = new Reservation();
	                // appel des mutateurs
	                bo.setIdRes(resultSet.getInt("idResa"));
	                bo.setDate(resultSet.getDate("dateReservation"));
	                bo.setNumero(resultSet.getString("numero"));
	                bo.setEtat(EtatReservation
	                        .permissiveValueOf(resultSet.getString("etat")));
	                bo.setPassager(passager);
	                // j'ajoute l'objet métier ainsi muté à la liste des objets
	                // métier
	                listeBO.add(bo);
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
	        return listeBO;
}

package agence.model;

public class Login
{
	private int id;
	private String login;
	private String motDePasse;
	private boolean admin;
	
	public Login()
	{
		
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin()
	{
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login)
	{
		this.login = login;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse()
	{
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse)
	{
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the admin
	 */
	public boolean isAdmin()
	{
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin)
	{
		this.admin = admin;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Login [id=" + id + ", login=" + login + ", motDePasse=" + motDePasse + ", admin=" + admin + "]";
	}
	
}

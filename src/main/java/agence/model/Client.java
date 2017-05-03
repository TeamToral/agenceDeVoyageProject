package agence.model;

public abstract class Client {

	private int idClient;

	// Nom du client
	private String nomClient;

	// Num de tel du client
	private String numTel;

	// Num de fax du client
	private String numFax;

	// email du client
	private String email;

	public Client(int idClient) {
		this.idClient = idClient;
	}
	

	/**
	 * @return the idClient
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param idClient
	 *            the idClient to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}

	/**
	 * @param nomClient
	 *            the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	/**
	 * @return the numTel
	 */
	public String getNumTel() {
		return numTel;
	}

	/**
	 * @param numTel
	 *            the numTel to set
	 */
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	/**
	 * @return the numFax
	 */
	public String getNumFax() {
		return numFax;
	}

	/**
	 * @param numFax
	 *            the numFax to set
	 */
	public void setNumFax(String numFax) {
		this.numFax = numFax;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", numTel=" + numTel + ", numFax=" + numFax
				+ ", email=" + email + "]";
	}

}

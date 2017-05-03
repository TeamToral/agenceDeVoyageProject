package agence.model;

public class ClientPhysique extends Client {

	private String prenom;
	
	public ClientPhysique(String prenom)
    {
		super();
        this.prenom = prenom;
    }

    // constructeurs
    
    public ClientPhysique() {
		// TODO Auto-generated constructor stub
    	super();
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "ClientPhysique [idClient=" + idClient + ", nomClient=" + nomClient + ", prenom=" + prenom + ", numTel=" + numTel + ", numFax=" + numFax
				+ ", email=" + email + "]";
	}
	
    
}

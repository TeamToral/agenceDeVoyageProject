package agence.model;

public class ClientMoral extends Client {

	private String siret;
	
	public ClientMoral(String siret)
    {
        this.siret = siret;
    }

   // constructeurs
    
    public ClientMoral() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the siret
	 */
	public String getSiret() {
		return siret;
	}

	/**
	 * @param siret the siret to set
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientMoral [siret=" + siret + "]";
	}
		
	
	
}

package agence.model;

public class ClientMoral extends Client {

	private int siret;
	
	public ClientMoral(int siret)
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
	public int getSiret() {
		return siret;
	}

	/**
	 * @param siret the siret to set
	 */
	public void setSiret(int siret) {
		this.siret = siret;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientMoral [siret=" + siret + ", idClient=" + idClient + ", nomClient=" + nomClient + ", numTel="
				+ numTel + ", numFax=" + numFax + ", email=" + email + "]";
	}
		
	
	
}

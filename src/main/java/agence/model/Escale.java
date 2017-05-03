package agence.model;

import java.sql.Time;
import java.util.Date;

public class Escale
{
	private int idEscale;
	private Date dateDepart;
	private Date dateArrivee;
	private Time heureDepart;
	private Time heureArrivee;
	
	private Vol vol;
	private Aeroport aeroport;
	
	public Escale()
	{
		
	}

	/**
	 * @return the idEscale
	 */
	public int getIdEscale()
	{
		return idEscale;
	}

	/**
	 * @param idEscale the idEscale to set
	 */
	public void setIdEscale(int idEscale)
	{
		this.idEscale = idEscale;
	}

	/**
	 * @return the dateDepart
	 */
	public Date getDateDepart()
	{
		return dateDepart;
	}

	/**
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(Date dateDepart)
	{
		this.dateDepart = dateDepart;
	}

	/**
	 * @return the dateArrivee
	 */
	public Date getDateArrivee()
	{
		return dateArrivee;
	}

	/**
	 * @param dateArrivee the dateArrivee to set
	 */
	public void setDateArrivee(Date dateArrivee)
	{
		this.dateArrivee = dateArrivee;
	}

	/**
	 * @return the heureDepart
	 */
	public Time getHeureDepart()
	{
		return heureDepart;
	}

	/**
	 * @param heureDepart the heureDepart to set
	 */
	public void setHeureDepart(Time heureDepart)
	{
		this.heureDepart = heureDepart;
	}

	/**
	 * @return the heureArrivee
	 */
	public Time getHeureArrivee()
	{
		return heureArrivee;
	}

	/**
	 * @param heureArrivee the heureArrivee to set
	 */
	public void setHeureArrivee(Time heureArrivee)
	{
		this.heureArrivee = heureArrivee;
	}

	/**
	 * @return the vol
	 */
	public Vol getVol()
	{
		return vol;
	}

	/**
	 * @param vol the vol to set
	 */
	public void setVol(Vol vol)
	{
		this.vol = vol;
	}

	/**
	 * @return the aeroport
	 */
	public Aeroport getAeroport()
	{
		return aeroport;
	}

	/**
	 * @param aeroport the aeroport to set
	 */
	public void setAeroport(Aeroport aeroport)
	{
		this.aeroport = aeroport;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Escale [idEscale=" + idEscale + ", dateDepart=" + dateDepart + ", dateArrivee=" + dateArrivee
				+ ", heureDepart=" + heureDepart + ", heureArrivee=" + heureArrivee + ", a�roport=" + aeroport.getNom() + ", vol=" + vol.getIdVol() + "]";
	}
	
	
}

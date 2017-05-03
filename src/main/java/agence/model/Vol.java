package agence.model;

import java.sql.Date;
import java.sql.Time;

public class Vol 
{
	private int idVol;
	private Date dateDepart;
	private Date dateArrivee;
	private Time heureDepart;
	private Time heureArrivee;
	private Aeroport aeroportArrivee;
	private Aeroport aeroportDepart;
	
	public int getIdVol() {
		return idVol;
	}
	public void setIdVol(int idVol) {
		this.idVol = idVol;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Date getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public Time getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}
	public Time getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(Time heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	
	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}
	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}
	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}
	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}
	@Override
	public String toString() {
		return "Vol [idVol=" + idVol + ", dateDepart=" + dateDepart + ", dateArrivee=" + dateArrivee + ", heureDepart="
				+ heureDepart + ", heureArrivee=" + heureArrivee + ", aeroportArrivee=" + aeroportArrivee
				+ ", aeroportDepart=" + aeroportDepart + "]";
	}
	
	
}

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
	@Override
	public String toString() {
		return "Vol [idVol=" + idVol + ", dateDepart=" + dateDepart + ", dateArrivee=" + dateArrivee + ", heureDepart="
				+ heureDepart + ", heureArrivee=" + heureArrivee + "]";
	}
	
}

package agence.model;

public class CompagnieAerienne 
{
	private int idCAerienne;
	private String nom;
	private Vol vols;
	public int getIdCAerienne() {
		return idCAerienne;
	}
	public void setIdCAerienne(int idCAerienne) {
		this.idCAerienne = idCAerienne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Vol getVol() {
		return vols;
	}
	public void setVol(Vol vols) {
		this.vols = vols;
	}
	@Override
	public String toString() {
		return "CompagnieAerienne [idCAerienne=" + idCAerienne + ", nom=" + nom + ", vols=" + vols + "]";
	}
	 
}

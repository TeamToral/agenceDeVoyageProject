package agence.model;

public class Aeroport {

	private int idAero;
	private String nom;
	private Ville ville;
	
	//Constructeur par défault sans paramètre
	public Aeroport() {
		
	}
	// Constructeur avec deu paramètres, id et nom
	public Aeroport(int idAero, String nom) {
		super();
		this.idAero = idAero;
		this.nom = nom;
	}
	//Getter et Setter idAero
	public int getIdAero() {
		return idAero;
	}
	public void setIdAero(int idAero) {
		this.idAero = idAero;
	}
	
	//Getter et Setter nom
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Aeroport [idAero=" + idAero + ", nom=" + nom + "]";
	}
	
}

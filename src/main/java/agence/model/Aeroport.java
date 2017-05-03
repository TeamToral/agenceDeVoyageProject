package agence.model;

public class Aeroport {

	private int idAero;
	private String nom;
	
	//Constructeur par d�fault sans param�tre
	public Aeroport() {
		
	}
	// Constructeur avec deu param�tres, id et nom
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
	
}

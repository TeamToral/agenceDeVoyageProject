package agence.model;

public class CompagnieAerienneVol 
{
	private String numero;
	private Boolean ouvert;
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Boolean getOuvert() {
		return ouvert;
	}
	public void setOuvert(Boolean ouvert) {
		this.ouvert = ouvert;
	}
	@Override
	public String toString() {
		return "CompagnieAerienneVol [numero=" + numero + ", ouvert=" + ouvert + "]";
	}
	
}

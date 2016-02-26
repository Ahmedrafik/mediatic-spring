package fr.iocean.application.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column
	private int numero;
	@Column
	private String adresse;
	@Column
	private int codePostal;
	@Column
	private String ville;
	
	public Adresse(){
	}
	
	public Adresse(int numero, String adresse, int codePostal, String ville){
		this.numero = numero;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville; 
	}
	

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}
	
	
	
}

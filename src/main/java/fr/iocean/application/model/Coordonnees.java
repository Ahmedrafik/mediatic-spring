package fr.iocean.application.model;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.Email;

@Embeddable
public class Coordonnees {

	private String nom;

	private String prenom;

	@Email
	private String email;

	public Coordonnees() {
	}

	public Coordonnees(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}

}

package fr.iocean.application.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;

@Entity
public class Utilisateur implements IoEntity {

	private static final long serialVersionUID = 7991372331623137021L;

	@Id
	@GeneratedValue
	private Long id;

	private String login;

	private String password;
	
	private int authentification;

	@Embedded
	@Valid
	private Coordonnees coordonnees;
	
	public Utilisateur(String nom, String prenom, String email, String login, String password, int auth) {
		Coordonnees coordonnees = new Coordonnees(nom, prenom, email);
		this.coordonnees = coordonnees;
		this.authentification = auth;
	}

	public Utilisateur() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAuthentification() {
		return authentification;
	}

	public void setAuthentification(int authentification) {
		this.authentification = authentification;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	@Override
	public String toString() {
		return "Utilisateur [login=" + login + ", password=" + password + ", authentification=" + authentification
				+ "]";
	}

}

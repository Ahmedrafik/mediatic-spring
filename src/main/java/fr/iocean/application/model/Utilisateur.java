package fr.iocean.application.model;

import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.Valid;

@Entity
public class Utilisateur implements IoEntity {

	private static final long serialVersionUID = 7991372331623137021L;

	@Id
	@GeneratedValue
	private Long id;

	private String login;

	private String password;

	@Embedded
	@Valid
	private Coordonnees coordonnees;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Credential> credentials;

	public Utilisateur(String nom, String prenom, String email, String login, String password) {
		this.login = login;
		this.password = password;
		Coordonnees coordonnees = new Coordonnees(nom, prenom, email);
		this.coordonnees = coordonnees;
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

	public List<Credential> getCredentials() {
		return credentials;
	}

	public void setCredentials(List<Credential> credentials) {
		this.credentials = credentials;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", login=" + login + ", password=" + password + ", coordonnees=" + coordonnees
				+ ", credentials=" + credentials + "]";
	}

}

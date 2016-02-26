package fr.iocean.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import fr.iocean.application.exception.LoginException;
import fr.iocean.application.utilitaires.Utilitaires;


@Entity
@Table(name="utilisateur")
public class Utilisateur extends Personne implements IoEntity {
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "niveau_acces")
	private int authentification;
	
	
	
	
	public Utilisateur(String nom, String prenom, String email , String login, String password, int auth){
		super(nom, prenom, email);
		this.login = login;
		try{
			Utilitaires.verifierPassword(password);
		}
		catch(Exception e){
			System.out.println("Password incorect !!");
		}
		this.password = password;
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
	public String toString() {
		return "Utilisateur [login=" + login + ", password=" + password + ", authentification=" + authentification
				+ "]";
	}
	
	
	
	// methode 
	public static void login(String login,String mdp) throws LoginException {
		//TODO : Appeller la BDD.
	
		
		if(login==null||mdp==null||Utilitaires.verifierPassword(mdp)==false)
		{
			throw new LoginException(); 
		}
	}	
	
	
	
	
	

}

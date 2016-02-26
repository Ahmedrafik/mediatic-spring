package fr.iocean.application.exception;

public class LoginException extends Exception {

	public LoginException() {
		super("Mauvaise combinaison login/mot de passe");
	}

}
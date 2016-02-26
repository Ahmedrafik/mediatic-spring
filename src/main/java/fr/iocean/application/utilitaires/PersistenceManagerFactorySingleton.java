package fr.iocean.application.utilitaires;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManagerFactorySingleton {

	private static EntityManagerFactory emf;

	public static EntityManagerFactory instance() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("unit");
		}
		return emf;
	}

}

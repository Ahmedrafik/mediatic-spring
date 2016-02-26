package fr.iocean.application.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.iocean.application.model.Adherent;
import fr.iocean.application.model.Cotisation;
import fr.iocean.application.utilitaires.PersistenceManagerFactorySingleton;

public class CotisationDAO {

	/**
	 * methode de creation d'une cotisation
	 * @param cotisation
	 * @return
	 */
	public Cotisation saveCotisation(Cotisation cotisation){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cotisation);
		em.getTransaction().commit();
		em.close();
		return cotisation;
	}
	
	/**
	 * Modification d'une cotisation
	 * @param cotisation
	 * @return
	 */
	public Cotisation updateCotisation(Cotisation cotisation){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(cotisation);
		em.getTransaction().commit();
		em.close();
		return cotisation;
	}
	
	
	/**
	 * recupere une cotisation par son id
	 * @param id
	 * @return
	 */
	public Cotisation getCotisation(Long id){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		Cotisation cotisation = em.find(Cotisation.class, id);
		em.close();
		return cotisation;
	}
	
	
	/**
	 * recupere tous les cotisations d'un adherent
	 * @return
	 */
	public List<Cotisation> getAllCotisation(Adherent adh){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		Long adhid = adh.getId();
		TypedQuery<Cotisation> queryGetAll = em.createQuery(
				"select c from Cotisation c"
				+ "join Adherent.cotisation "
				+ "where Adherent.id = :adhid", Cotisation.class);
		queryGetAll.setParameter("adhid", adhid);
		List<Cotisation> allCotis = queryGetAll.getResultList();
		em.close();
		return allCotis;
	}
	
	
	
	/**
	 * supprimer une cotisation
	 */
	public void removeCotisation(Long id){
		
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		Cotisation cot = em.find(Cotisation.class, id);
		em.remove(cot);
		em.close();
	}
	
}

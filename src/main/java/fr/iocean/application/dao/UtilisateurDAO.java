package fr.iocean.application.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.iocean.application.model.Utilisateur;
import fr.iocean.application.utilitaires.PersistenceManagerFactorySingleton;

public class UtilisateurDAO {
	
	/**
	 * methode de creation d'un utilisateur
	 * @param utilisateur
	 * @return
	 */
	public Utilisateur saveUtilisateur(Utilisateur utilisateur){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(utilisateur);
		em.getTransaction().commit();
		em.close();
		return utilisateur;
	}
	
	/**
	 * update utilisateur
	 * @param utilisateur
	 * @return
	 */
	public Utilisateur updateUtilisateur(Utilisateur utilisateur){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(utilisateur);
		em.getTransaction().commit();
		em.close();
		return utilisateur;
	}
	
	
	/**
	 * recupere un utilsateur par son id
	 * @param id
	 * @return
	 */
	public Utilisateur getUtilisateur(Long id){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		em.close();
		return utilisateur;
	}
	
	
	/**
	 * recupere tous les utilsateurs
	 * @return
	 */
	public List<Utilisateur> getAllUtilisateur(){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		TypedQuery<Utilisateur> queryGetAll = em.createQuery(
				"select u from utilisateur u", Utilisateur.class);
		List<Utilisateur> allUtilisateurs = queryGetAll.getResultList();
		em.close();
		return allUtilisateurs;
	}
	
	
	
	/**
	 * supprimer un utilsateur
	 */
	public void removeUtilisateur(Long id){
		
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		Utilisateur usr = em.find(Utilisateur.class, id);
		em.remove(usr);
		em.close();
	}
	
	
	

}

package fr.iocean.application.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.iocean.application.model.Adherent;
import fr.iocean.application.utilitaires.PersistenceManagerFactorySingleton;

public class AdherentDAO {

	/**
	 * creer un utilsateur
	 * @param adh
	 * @return
	 */
	public Adherent saveAdherent(Adherent adh){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(adh);
		em.getTransaction().commit();
		em.close();
		return adh;
	}
	
	/**
	 * recupere un adherent par id
	 * @param id
	 * @return
	 */
	public Adherent getAdherent(Long id){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		Adherent adh = em.find(Adherent.class, id);
		em.close();
		return adh;
	}
	
	/**
	 * update adherent
	 * @param adh
	 * @return
	 */
	public Adherent updateAdherent(Adherent adh){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(adh);
		em.getTransaction().commit();
		em.close();
		return adh;
	}
	
	
	/**
	 * recuper tous les adherents
	 */
	public List<Adherent> getAllAdherent(){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		TypedQuery<Adherent> queryGetAll = em.createQuery(
				"select a from Adherent a", Adherent.class);
		List<Adherent> allAdherent = queryGetAll.getResultList();
		em.close();
		return allAdherent;
	}
	
	
	
	/**
	 * supprimer un adherent
	 */
	public void removeAdherent(Long id){
		
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		Adherent adh = em.find(Adherent.class, id);
		em.remove(adh);
		em.close();
	}
	
	
	
	
	/**
	 * recuper la liste des adherents par filtre
	 */
	public List<Adherent> getAdherentByName(String filter){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		TypedQuery<Adherent> query = em.createQuery(
				"select a from Adherent a where nom like :filter", Adherent.class);
		query.setParameter("filter", "%" + filter + "%");
		List<Adherent> adherents = query.getResultList();
		
		return adherents;
	}
	
	/**
	 * 
	 */
/*	public List<Object> getListeFiltre(String[] filter,String[] titre)
	{
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		String requete = "select a from adherent a" ;
		for( clef -> value : filter){
			if(value!=null){requete+= " AND " + key + " = " + value  }
		}
		
		for( clef -> value : tris){
			if(value!=null){requete+= ", " + key + " = " + value  }
		}		
	}*/
	
	
	
}

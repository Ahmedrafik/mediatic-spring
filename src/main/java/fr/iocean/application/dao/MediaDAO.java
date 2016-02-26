package fr.iocean.application.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.iocean.application.model.Media;
import fr.iocean.application.utilitaires.PersistenceManagerFactorySingleton;

public class MediaDAO {

	/**
	 * creer un media
	 * @param adh
	 * @return
	 */
	public Media saveMedia(Media media){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(media);
		em.getTransaction().commit();
		em.close();
		return media;
	}
	
	/**
	 * recupere un media par id
	 * @param id
	 * @return
	 */
	public Media getAdherent(Long id){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		Media media = em.find(Media.class, id);
		em.close();
		return media;
	}
	
	
	
	/**
	 * update un media
	 * @param adh
	 * @return
	 */
	public Media updateAdherent(Media media){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(media);
		em.getTransaction().commit();
		em.close();
		return media;
	}
	
	
	/**
	 * recuper tous les medias
	 */
	public List<Media> getAllAdherent(){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		TypedQuery<Media> queryGetAll = em.createQuery(
				"select m from Media m", Media.class);
		List<Media> listMedia = queryGetAll.getResultList();
		em.close();
		return listMedia;
	}
	
	
	
	/**
	 * supprimer un media
	 */
	public void removeAdherent(Long id){
		
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		Media media = em.find(Media.class, id);
		em.remove(media);
		em.close();
	}
	
	
	
	
	/**
	 * recuper la liste des medias par filtre
	 */
	public List<Media> getAdherentByName(String filter){
		EntityManagerFactory emf = PersistenceManagerFactorySingleton.instance();
		EntityManager em = emf.createEntityManager();
		TypedQuery<Media> query = em.createQuery(
				"select m from Media m where titre like :filter", Media.class);
		query.setParameter("filter", "%" + filter + "%");
		List<Media> mediaList = query.getResultList();
		
		return mediaList;
	}
	
	
	

	
	
}

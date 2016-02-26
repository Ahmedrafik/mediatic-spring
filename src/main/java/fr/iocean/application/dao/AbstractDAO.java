package fr.iocean.application.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.iocean.application.model.IoEntity;

@Repository
public abstract class AbstractDAO<T extends IoEntity> {
	
	
	private Class<T> entityClass;
	
	@PostConstruct
	public void initEntityClass(){
		entityClass = getEntityClass();
	}
	
	protected abstract Class<T> getEntityClass();
	
	@PersistenceContext
	protected EntityManager em;

	protected Session getSession() {
		return em.unwrap(Session.class);
	}
	
	public void save(T entity){
		em.persist(entity);
	}
	
	public T findOne(Long id){
		return em.find(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getSession().createCriteria(entityClass).list();
	}
	
	public void delete(T entity){
		em.remove(entity);
	}
	
}

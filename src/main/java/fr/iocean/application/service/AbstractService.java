package fr.iocean.application.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import fr.iocean.application.dao.AbstractDAO;
import fr.iocean.application.exception.NotFoundException;
import fr.iocean.application.model.IoEntity;


@Service
public abstract class AbstractService<T extends IoEntity, U extends AbstractDAO<T>> {

	private U dao;

	/**
	 * nbrResultats : nombre de résultats par page
	 */
	@Value("${app.query.nbrResultats}")
	private int nbrResultats; 
	
	protected abstract U getDao();
	
	@PostConstruct
	protected void init(){
		this.dao = getDao();
	}
	
	public void save(T entity){
		dao.save(entity);
	}

	public List<T> findAll(){
		return dao.findAll();
	}
	
	
	public T findById(long id) throws NotFoundException{
		return dao.findOne(id);
	}

	public T update(T entity)  throws NotFoundException{
		return dao.save(entity);
	}

	public void delete(Long id) throws NotFoundException{
		dao.delete(this.findById(id));
	}
	
	/**
	 * Récupère le nombre d'objets par page.
	 * @return nbrResultats
	 */
	public int getNbrResultats() {
		return nbrResultats;
	}

}

package fr.iocean.application.service;

import java.util.List;
import org.springframework.stereotype.Service;

import fr.iocean.application.dao.AbstractDAO;
import fr.iocean.application.exception.NotFoundException;
import fr.iocean.application.model.IoEntity;


@Service
public interface IService<T extends IoEntity, U extends AbstractDAO<T>> {

	protected U dao;
	
	
	void save(T entity);

	List<T> findAll();

	T findById(long id) throws NotFoundException;

	T update(T entity)  throws NotFoundException;

	void delete(Long id) throws NotFoundException;

}

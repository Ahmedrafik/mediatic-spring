package fr.iocean.application.service;

import java.util.List;
import fr.iocean.application.model.IoEntity;


public interface IService<T extends IoEntity> {

	void saveUser(T t);

	List<T> findAllUser();

	T findById(long id);

	T update(T t);

	void delete(Long id);

}

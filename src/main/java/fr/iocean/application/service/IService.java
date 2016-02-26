package fr.iocean.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.iocean.application.model.IoEntity;

@Service
public interface IService<T extends IoEntity> {

	void save(T t);

	List<T> findAllUser();

	T findById(long id);

	T update(T t);

	void delete(Long id);

}

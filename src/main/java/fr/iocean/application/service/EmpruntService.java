package fr.iocean.application.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.iocean.application.dao.EmpruntDAO;
import fr.iocean.application.model.Emprunt;

public class EmpruntService extends AbstractService<Emprunt, EmpruntDAO>{

	@Autowired
	private EmpruntDAO empruntDao;

	@Override
	protected EmpruntDAO getDao() {
		return empruntDao;
	}
	
	
}

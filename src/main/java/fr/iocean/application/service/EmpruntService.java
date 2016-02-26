package fr.iocean.application.service;

import fr.iocean.application.dao.EmpruntDAO;
import fr.iocean.application.model.Emprunt;

public class EmpruntService extends AbstractService<Emprunt, EmpruntDAO>{

	private EmpruntDAO empruntDao;

	@Override
	protected EmpruntDAO getDao() {
		return empruntDao;
	}
	
	
}

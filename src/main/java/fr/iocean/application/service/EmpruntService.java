package fr.iocean.application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.iocean.application.dao.EmpruntDAO;
import fr.iocean.application.model.Emprunt;


@Service
@Transactional
public class EmpruntService extends AbstractService<Emprunt, EmpruntDAO> {

	@Autowired
	private EmpruntDAO empruntDAO;
	
	@Override
	protected EmpruntDAO getDao() {
		return empruntDAO;
	}

}
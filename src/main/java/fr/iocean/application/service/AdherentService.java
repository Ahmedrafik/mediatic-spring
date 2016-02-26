package fr.iocean.application.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.iocean.application.dao.AdherentDAO;
import fr.iocean.application.model.Adherent;

@Service
@Transactional
public class AdherentService extends AbstractService<Adherent, AdherentDAO> {

	@Autowired
	private AdherentDAO adherentDao;
	
	@Override
	protected AdherentDAO getDao() {
		return this.adherentDao;
	}
	
	@Autowired
	@Qualifier(value="adherentdao")
	public void setAdherentDao(AdherentDAO adherentDao) {
		this.adherentDao = adherentDao;
	}

	

	
}

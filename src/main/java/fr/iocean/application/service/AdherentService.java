package fr.iocean.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.iocean.application.dao.AdherentDAO;
import fr.iocean.application.exception.NotFoundException;
import fr.iocean.application.model.Adherent;

@Service
@Transactional
public class AdherentService implements IService<Adherent> {

	@Autowired
	private AdherentDAO adherentDao;
	
	public AdherentDAO getAdherentDao() {
		return adherentDao;
	}

	@Autowired
	@Qualifier(value="adherentdao")
	public void setAdherentDao(AdherentDAO adherentDao) {
		this.adherentDao = adherentDao;
	}

	@Override
	public void save(Adherent entity) {
		adherentDao.save(entity);		
	}

	@Override
	public List<Adherent> findAll() {
		return adherentDao.findAll();
	}

	@Override
	public Adherent findById(long id) throws NotFoundException {
		return adherentDao.findOne(id);
	}

	@Override
	public Adherent update(Adherent entity) throws NotFoundException {
		return adherentDao.save(entity);
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		adherentDao.delete(findById(id));
	}
	
}

package fr.iocean.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.iocean.application.dao.CotisationDAO;
import fr.iocean.application.model.Adherent;
import fr.iocean.application.model.Cotisation;
import fr.iocean.application.typeEnum.TypeCotisation;

@Service
@Transactional
public class CotisationService extends AbstractService<Cotisation, CotisationDAO>{

	@Autowired
	private CotisationDAO cotisationDao;
	
	@Override
	protected CotisationDAO getDao() {
		return cotisationDao;
	}
	
	@Qualifier(value="cotisationdao")
	public void setCotisationDao(CotisationDAO cotisationDao) {
		this.cotisationDao = cotisationDao;
	}
	
	public List<Adherent> getAdherentByCotisation(TypeCotisation cotisation){
		return this.getDao().getAdherentByCotisation(cotisation);
	}

	
}

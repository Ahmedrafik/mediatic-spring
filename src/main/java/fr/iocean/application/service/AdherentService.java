package fr.iocean.application.service;

import java.util.ArrayList;
import java.util.List;

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
	
	@Qualifier(value="adherentdao")
	public void setAdherentDao(AdherentDAO adherentDao) {
		this.adherentDao = adherentDao;
	}
	
	public List<Adherent> getAdherentByName(String filter){
		return this.adherentDao.getAdherentByName(filter);
	}
	
	public List<Adherent> getAdherentById(Long id){
		return this.adherentDao.getAdherentById(id);
	}
	
	public List<Adherent> getAdherentByFilters(String name, Long id){
		List<Adherent> listName = this.getAdherentByName(name);
		List<Adherent> listId = this.getAdherentById(id);
		List<Adherent> filterList = new ArrayList<Adherent>();
		
		for(Adherent adh : listName){
			if(listId.contains(adh)){
				filterList.add(adh);
			}
		}
		
		return filterList;
		
	}
}

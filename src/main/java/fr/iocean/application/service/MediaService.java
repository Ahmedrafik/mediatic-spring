package fr.iocean.application.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.dao.MediaDAO;
import fr.iocean.application.model.Media;

@Service
@Transactional
public class MediaService extends AbstractService<Media, MediaDAO> {

	@Autowired
	private MediaDAO mediaDAO;

	public List<Media> findByFilters(String titre,String auteur,String typeMedia,String orderField,String orderDirection,int page) {
		
		// Création de la hashmap
		HashMap<String,String> filters = new HashMap<String,String>();
		if(titre!=""){filters.put("titre", titre);}
		if(auteur!=""){filters.put("auteur", auteur);}
		if(typeMedia!=""){filters.put("typeMedia", typeMedia);}
		
		// Autres params
		int offset = page * getNbrResultats();
		return mediaDAO.findByFilters(filters,orderField,orderDirection,offset,getNbrResultats());
	}
	

	
//	public Optional<Media> findByLogin(String login) {
//		return mediaDAO.findOneByLogin(login);
//	}

	@Override
	protected MediaDAO getDao() {
		return mediaDAO;
	}

}

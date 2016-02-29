package fr.iocean.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.iocean.application.dao.MediaDAO;
import fr.iocean.application.model.Media;
import fr.iocean.application.model.Utilisateur;

@Service
@Transactional
public class MediaService extends AbstractService<Media, MediaDAO> {

	@Autowired
	private MediaDAO mediaDAO;

//	public List<Media> findByFilters(String[]filters, String[order, orderField, orderDirection, offset, limit) {
//		return mediaDAO.findByFilters(filters, order, orderField, orderDirection, offset, limit);
//	}
	

	
//	public Optional<Media> findByLogin(String login) {
//		return mediaDAO.findOneByLogin(login);
//	}

	@Override
	protected MediaDAO getDao() {
		return mediaDAO;
	}

}

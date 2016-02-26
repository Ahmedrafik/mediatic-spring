package fr.iocean.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.iocean.application.dao.UtilisateurDAO;
import fr.iocean.application.exception.NotFoundException;
import fr.iocean.application.model.Utilisateur;

@Service
@Transactional
public class UtilisateurService implements IService<Utilisateur> {

	@Autowired
	private UtilisateurDAO utilisateurDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void save(Utilisateur entity) {
		utilisateurDAO.save(entity);
	}

	@Override
	public List<Utilisateur> findAllUser() {
		return utilisateurDAO.findAll();
	}

	@Override
	public Utilisateur findById(long id) throws NotFoundException {

		Utilisateur utilsateur = utilisateurDAO.findOne(id);
		if (utilsateur == null) {
			throw new NotFoundException();
		}
		return utilsateur;
	}

	@Override
	public Utilisateur update(Utilisateur entity) throws NotFoundException {
		if (utilisateurDAO.findOne(entity.getId()) == null) {
			throw new NotFoundException();
		}
		return utilisateurDAO.save(entity);
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		Utilisateur utilisateur = utilisateurDAO.findOne(id);
		if (utilisateur == null) {
			throw new NotFoundException();
		}
		utilisateurDAO.delete(utilisateur);
	}

	public Optional<Utilisateur> findByLogin(String login) {
		return utilisateurDAO.findOneByLogin(login);
	}

}

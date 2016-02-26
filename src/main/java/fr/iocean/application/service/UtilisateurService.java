package fr.iocean.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.dao.UtilisateurDAO;
import fr.iocean.application.model.Utilisateur;

@Service
@Transactional
public class UtilisateurService {
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	
	
	public Optional<Utilisateur> findByLogin(String login) {
	
		return null;
	}
	

}

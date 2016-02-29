package fr.iocean.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import fr.iocean.application.dao.UtilisateurDAO;
import fr.iocean.application.model.Credential;
import fr.iocean.application.model.Utilisateur;


@Service
@Transactional
public class UtilisateurService extends AbstractService<Utilisateur, UtilisateurDAO> implements UserDetailsService {

	@Autowired
	private UtilisateurDAO utilisateurDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	/**
	 * surcharge de la methode save pour le cryptage du mp utilsateur
	 */
	@Override
	public void save(Utilisateur utilisateur) {
		if(!StringUtils.isEmpty(utilisateur.getPassword()))
			utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		utilisateurDAO.save(utilisateur);
	}

	
	
	public Optional<Utilisateur> findByLogin(String login) {
		return utilisateurDAO.findOneByLogin(login);
	}

	@Override
	protected UtilisateurDAO getDao() {
		return utilisateurDAO;
	}

	
	
	
	@Override
	public UserDetails loadUserByUsername(final String username) {

		Optional<Utilisateur> option = utilisateurDAO.findOneByLogin(username);
		if (option.isPresent()) {
			Utilisateur utilisateur = option.get();
			List<GrantedAuthority> rules = this.getUserCredentials(utilisateur);
			return new org.springframework.security.core.userdetails.User(utilisateur.getLogin(), utilisateur.getPassword(), rules);
		}
		throw new UsernameNotFoundException("username.not.found");
	}
	
	

	public List<GrantedAuthority> getUserCredentials(Utilisateur utilisateur) {

		List<GrantedAuthority> rules = new ArrayList();
		List<Credential> credentials = utilisateur.getCredentials();

		if (CollectionUtils.isEmpty(credentials)) {
			for (Credential credential : credentials) {
				rules.add(new SimpleGrantedAuthority(credential.getCode()));
			}
		}
		return rules;
	}
	
	
	
	
	
}

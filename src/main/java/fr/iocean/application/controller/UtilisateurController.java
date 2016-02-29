package fr.iocean.application.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import fr.iocean.application.exception.NotFoundException;
import fr.iocean.application.model.Utilisateur;
import fr.iocean.application.service.UtilisateurService;


@RestController
@RequestMapping("api/utilsateur")
public class UtilisateurController {


	@Autowired
	UtilisateurService utilisateurService;
	
	
	/**
	 * CREATE USER
	 * 
	 * @param resource
	 */
	@PreAuthorize("hasRole('R_ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid Utilisateur resource) {
		utilisateurService.save(resource);
	}

	
	/**
	 * UPDATE USER
	 * @param id
	 * @param user
	 */
	@PreAuthorize("hasRole('R_ADMIN')")
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("id") long id, @RequestBody @Valid Utilisateur utilisateur) throws NotFoundException{
		utilisateur.setId(id);
		return utilisateurService.update(utilisateur);
	}
	

	
	/**
	 * FIND ALL USERS
	 * @return
	 */
	@PreAuthorize("hasRole('R_ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		List<Utilisateur> users = utilisateurService.findAll();
		if (users.isEmpty()) {
			return null;

		} else {
			return users;
		}
	}
	

	/**
	 * FIND USER BY ID
	 * 
	 * @param id
	 * @return
	 */
	@PreAuthorize("hasRole('R_ADMIN')")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur findById(@PathVariable Long id) throws NotFoundException {
		return utilisateurService.findById(id);
	}

	
	

	/**
	 * DELETE USER
	 * 
	 * @param id
	 */
	@PreAuthorize("hasRole('R_ADMIN')")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") long id) throws NotFoundException{
		utilisateurService.delete(id);
	}

}

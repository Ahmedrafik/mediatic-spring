package fr.iocean.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/emprunts")
public class EmpruntController {
	
	
	@Autowired
	UtilisateurService utilisateurService;
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid Utilisateur resource) {
		utilisateurService.save(resource);
	}

	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("id") long id, @RequestBody @Valid Utilisateur utilisateur) throws NotFoundException{
		utilisateur.setId(id);
		return utilisateurService.update(utilisateur);
	}
	

	
	@RequestMapping(method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		List<Utilisateur> users = utilisateurService.findAll();
		if (users.isEmpty()) {
			return null;

		} else {
			return users;
		}
	}
	

	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur findById(@PathVariable Long id) throws NotFoundException {
		return utilisateurService.findById(id);
	}


	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") long id) throws NotFoundException{
		utilisateurService.delete(id);
	}


	
}

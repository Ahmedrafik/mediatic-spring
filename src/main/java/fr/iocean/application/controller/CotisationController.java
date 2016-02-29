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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.iocean.application.exception.NotFoundException;
import fr.iocean.application.model.Adherent;
import fr.iocean.application.model.Cotisation;
import fr.iocean.application.service.CotisationService;

@RestController
@RequestMapping("api/cotisation")
public class CotisationController {

	@Autowired
	private CotisationService cotisationService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('R_ADMIN', 'R_UTILISATEUR')")
	public void create(@RequestBody @Valid Cotisation cotisation){
		cotisationService.save(cotisation);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('R_ADMIN', 'R_UTILISATEUR', 'R_STAGIAIRE')")
	public Cotisation findById(@PathVariable Long id) throws NotFoundException {
		return cotisationService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('R_ADMIN', 'R_UTILISATEUR', 'R_STAGIAIRE')")
	public List<Cotisation> findAll(){
		return cotisationService.findAll();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('R_ADMIN', 'R_UTILISATEUR')")
	public void update(@PathVariable Long id, @RequestBody @Valid Cotisation cotisation){
		cotisationService.save(cotisation);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('R_ADMIN', 'R_UTILISATEUR')")
	public void delete(@PathVariable Long id) throws NotFoundException{
		Cotisation userToRemove = this.findById(id);
		cotisationService.delete(userToRemove.getId());
	}
}

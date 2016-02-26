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
import fr.iocean.application.service.AdherentService;

@RestController
@RequestMapping("/api/adherents")
public class AdherentController {

	@Autowired
	private AdherentService adherentService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ADMIN')")
	public void create(@RequestBody @Valid Adherent adherent){
		adherentService.save(adherent);
	}
	
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN','CONSULTE')")
	public Adherent findById(@PathVariable Long id) throws NotFoundException {
		return adherentService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN','CONSULTE')")
	public List<Adherent> findAll(){
		return adherentService.findAll();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('ADMIN')")
	public void update(@PathVariable Long id, @RequestBody @Valid Adherent adherent){
		adherentService.save(adherent);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('ADMIN')")
	public void delete(@PathVariable Long id) throws NotFoundException{
		Adherent userToRemove = this.findById(id);
		adherentService.delete(userToRemove.getId());
	}
}

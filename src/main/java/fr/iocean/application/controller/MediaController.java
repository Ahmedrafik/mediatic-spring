package fr.iocean.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.iocean.application.exception.NotFoundException;
import fr.iocean.application.model.Media;
import fr.iocean.application.service.MediaService;

@RestController
@RequestMapping("api/medias/")
public class MediaController {
	
	@Autowired
	private MediaService mediaService;
	
	
	/**
	 * CREATE MEDIA
	 * 
	 * @param resource
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid Media resource) {
		mediaService.save(resource);
	}
	
	/**
	 * UPDATE MEDIA
	 * @param id
	 * @param user
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Media update(@PathVariable("id") long id, @RequestBody @Valid Media media) throws NotFoundException{
		media.setId(id);
		return mediaService.update(media);
	}
	
	/**
	 * FIND ALL MEDIAS
	 * @return List<Media>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Media> findAll(
			@RequestParam(value="titre",defaultValue="") String titre,
			@RequestParam(value="auteur",defaultValue="") String auteur,
			@RequestParam(value="typemedia",defaultValue="") String typeMedia,
			@RequestParam(value="orderfield",defaultValue="titre") String orderField,
			@RequestParam(value="orderdirection",defaultValue="ASC") String orderDirection,
			@RequestParam(value="p",defaultValue="0") int page
			){
		
		System.out.println("titre :" + titre + "auteur :" + auteur + "type de media :" + typeMedia);
		List<Media> medias = mediaService.findByFilters(titre,auteur,typeMedia,orderField,orderDirection,page);
		
		return medias;
		//return new ArrayList<>();
//		List<Media> users = mediaService.findAll();
//		if (users.isEmpty()) {
//			return null;
//
//		} else {
//			return users;
//		}
	}

	/**
	 * FIND MEDIA BY ID
	 * 
	 * @param id
	 * @return Media
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public Media findById(@PathVariable Long id) throws NotFoundException {
		return mediaService.findById(id);
	}

	
	/**
	 * DELETE MEDIA
	 * 
	 * @param id
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") long id) throws NotFoundException{
		mediaService.delete(id);
	}	
}

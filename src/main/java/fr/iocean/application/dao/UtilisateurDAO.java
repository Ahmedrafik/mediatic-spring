package fr.iocean.application.dao;

import org.springframework.stereotype.Repository;

import fr.iocean.application.model.Utilisateur;


@Repository
public class UtilisateurDAO  extends AbstractDAO<Utilisateur> {

	@Override
	protected Class<Utilisateur> getEntityClass() {
		return Utilisateur.class;
	}
	



}

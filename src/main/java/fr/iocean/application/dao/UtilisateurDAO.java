package fr.iocean.application.dao;

import java.util.Optional;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import fr.iocean.application.model.Utilisateur;


@Repository
public class UtilisateurDAO extends AbstractDAO<Utilisateur> {

	@Override
	protected Class<Utilisateur> getEntityClass() {
		return Utilisateur.class;
	}

	@Transactional
	public Optional<Utilisateur> findOneByLogin(String login) {

		TypedQuery<Utilisateur> query = em.createQuery("from Utilisateur where login=:login", Utilisateur.class);
		query.setParameter("login", login);
		Utilisateur utilisateur = query.getSingleResult();
		return Optional.of(utilisateur);
	}

}

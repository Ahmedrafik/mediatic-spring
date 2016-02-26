package fr.iocean.application.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.iocean.application.model.Emprunt;

@Repository
public class EmpruntDAO extends AbstractDAO<Emprunt>{

	@Override
	protected Class<Emprunt> getEntityClass() {
		return Emprunt.class;
	}

	
	/**
	 * recuper la liste des emprunts par adherent
	 * @param Long id de l'adh�rent
	 * @return emprunts
	 */
	public List<Emprunt> getEmpruntsByAdherentId(Long adherent_id){
		TypedQuery<Emprunt> query = em.createQuery(
				"select e from emprunt e where adherent_id = :filter", Emprunt.class);
		query.setParameter("filter", adherent_id);
		List<Emprunt> emprunts = query.getResultList();
		
		return emprunts;
	}


	/**
	 * recuper la liste des emprunts par media
	 * @param Long id du media
	 * @return emprunts
	 */
	public List<Emprunt> getEmpruntsByMediaId(Long media_id){
		TypedQuery<Emprunt> query = em.createQuery(
				"select e from emprunt e where media_id = :filter", Emprunt.class);
		query.setParameter("filter", media_id);
		List<Emprunt> emprunts = query.getResultList();
		
		return emprunts;
	}
}

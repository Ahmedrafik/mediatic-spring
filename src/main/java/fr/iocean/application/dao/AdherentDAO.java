package fr.iocean.application.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.iocean.application.model.Adherent;

@Repository
public class AdherentDAO extends AbstractDAO<Adherent>{

	@Override
	protected Class<Adherent> getEntityClass() {
		return Adherent.class;
	}
	
	/**
	 * recuper la liste des adherents par filtre
	 */
	public List<Adherent> getAdherentByName(String filter){
		TypedQuery<Adherent> query = em.createQuery(
				"from Adherent where nom like :filter", Adherent.class);
		query.setParameter("filter", "%" + filter + "%");
		List<Adherent> adherents = query.getResultList();
		return adherents;
	}
	
	public List<Adherent> getAdherentById(Long idFilter){
		TypedQuery<Adherent> query = em.createQuery(
				"from Adherent where left(id, :size) =  :filter", Adherent.class);
		query.setParameter("size", "%" + idFilter.toString().length() + "%");
		query.setParameter("filter",  "%" + idFilter + "%");
		List<Adherent> adherents = query.getResultList();
		return adherents;
	}

	
	
	
}

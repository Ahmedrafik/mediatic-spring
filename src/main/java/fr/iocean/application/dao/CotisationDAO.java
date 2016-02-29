package fr.iocean.application.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.iocean.application.model.Adherent;
import fr.iocean.application.model.Cotisation;
import fr.iocean.application.typeEnum.TypeCotisation;

@Repository
public class CotisationDAO extends AbstractDAO<Cotisation>{

	@Override
	protected Class<Cotisation> getEntityClass() {
		return Cotisation.class;
	}
	
	public List<Adherent> getAdherentByCotisation(TypeCotisation cotisation){
		TypedQuery<Adherent> query = em.createQuery("select c.adherents from Cotisation c where c.typecotisation=:cotisation", Adherent.class);
		query.setParameter("cotisation", cotisation);
		return query.getResultList();
	}

}

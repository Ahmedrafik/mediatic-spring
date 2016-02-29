package fr.iocean.application.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.model.Emprunt;


@Repository
public class EmpruntDAO extends AbstractDAO<Emprunt> {

	@Override
	protected Class<Emprunt> getEntityClass() {

		return Emprunt.class;
	}
	
		
	@Transactional
	public List<Emprunt> getEmpruntByAdherent(long idAdherent) {

		TypedQuery<Emprunt> query = em.createQuery("select e.media from Emprunt e where e.id=:idAdherent", Emprunt.class);
		query.setParameter("idAdherent", idAdherent);
		List<Emprunt> emprunts = query.getResultList();
		return emprunts;
	}
	
	
	@Transactional
	public List<Emprunt> getEmpruntByMedia(long idMedia) {

		TypedQuery<Emprunt> query = em.createQuery("select e.adherent from Emprunt e where e.id=:idMedia", Emprunt.class);
		query.setParameter("idMedia", idMedia);
		List<Emprunt> emprunts = query.getResultList();
		return emprunts;
	}
	
	
	@Transactional
	public List<Emprunt> getEmpruntByDate(LocalDate date_emprunt) {

		TypedQuery<Emprunt> query = em.createQuery("from Emprunt where date_emprunt=:date_emprunt", Emprunt.class);
		query.setParameter("date_emprunt", date_emprunt);
		List<Emprunt> emprunts = query.getResultList();
		return emprunts;
	}

	

}

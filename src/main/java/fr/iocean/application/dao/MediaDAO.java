package fr.iocean.application.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.model.Media;

@Repository
public class MediaDAO extends AbstractDAO<Media>{
	
	@Override
	protected Class<Media> getEntityClass() {
		return Media.class;
	}
	
	/**
	 * 
	 * @param HashMap<String,String> filters (key : nom attribut, value : valeur de mon filtre)
	 * @param String orderField
	 * @Param String orderDirection
	 * @Param int offset : géré à partir de la pagination
	 * @Param int limit
	 * @return ArrayList<Media>
	 */
	
	@Transactional
	public List<Media> findByFilters(HashMap<String,String> filters,String orderField,String orderDirection,int offset, int limit) {
	// Premier passage dans le HashMap: je construis ma requete
		String maRequete = "FROM Media";
		if(filters.size()>0){
			int i = 0;
			for(Entry<String,String> entry : filters.entrySet()){
				if(i==0){maRequete += " WHERE ";}else{
					maRequete += " AND ";
				}
				maRequete += entry.getKey() + " LIKE '%:"  + entry.getKey() + "%'";
				i++;
			}
		}
		// 
		if(orderField!= null && orderField != ""){
			maRequete += " ORDER BY :orderField"; 
			if(orderField=="ASC"){ maRequete += " ASC";}else{
				maRequete += " DESC";
			}
		}
		if(limit!=0){
			maRequete += " LIMIT " + limit;
		}
		if(offset!=0){
			maRequete += " OFFSET " + offset;
		}
		
		System.out.println("requete sql : " + maRequete);
		TypedQuery<Media> query = em.createQuery(maRequete, Media.class);
		
	// Second passage : je sécurise les valeurs.
		
		if(filters.size()>0){
			for(Entry<String,String> entry : filters.entrySet()){
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		if(orderField!= null && orderField != ""){
			query.setParameter(":orderField",orderField);
			if(orderField =="DESC"){
				query.setParameter(":orderDirection","DESC");
			}else{
				query.setParameter(":orderDirection","ASC");
			}
		}
		
		// J'effectue ma recherche
		
		List<Media> medias = query.getResultList();
		
		return medias;
	}	

		
	
}

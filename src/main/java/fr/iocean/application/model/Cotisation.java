package fr.iocean.application.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.iocean.application.typeEnum.TypeCotisation;

@Entity
public class Cotisation implements IoEntity {
	
	private static final long serialVersionUID = 3107277028575102667L;

	@Id
	@GeneratedValue
	private long id;
	
	private float montant;
	
	private LocalDate dateCotisation;
	
	@Enumerated(value = EnumType.STRING)
	private TypeCotisation typeCotisation;
	
	@OneToMany (mappedBy="cotisation")
	private List<Adherent> adherents;
	
	// Constructeurs
	
	public Cotisation(){
	}
	
	public Cotisation(float montant, LocalDate date,TypeCotisation typeCotisation){ /* todo : eventuel try catch pour v�rif l'existance du type cotisation */
		this.montant = montant;
		this.dateCotisation = date;
		this.typeCotisation = typeCotisation;
	}
	
	// Getteurs 
	
	public float getMontant() {
		return montant;
	}

	public LocalDate getDateCotisation() {
		return dateCotisation;
	}

	public LocalDate getFinAdhesion(){
		return dateCotisation.plusYears(1); 
	}
	
	public TypeCotisation getTypeCotisation() {
		return typeCotisation;
	}
	
	// Setteurs 
	
	public void setMontant(float montant) {
		this.montant = montant;
	}

	public void setDateCotisation(LocalDate dateCotisation) {
		this.dateCotisation = dateCotisation;
	}
	
	public void setTypeCotisation(TypeCotisation typeCotisation) {
		this.typeCotisation = typeCotisation;
	}

	// Méthodes
	
	public static boolean isUpToDateCotisation(Adherent adh){
		return adh.getCotisation().getDateCotisation().plusYears(1L).isAfter(LocalDate.now());
	}
	
	@Override
	public String toString() {
		return "Cotisation [montant=" + montant + ", dateCotisation=" + dateCotisation + ", typeCotisation="
				+ typeCotisation + "]";
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

}

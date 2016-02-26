package fr.iocean.application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
public class Adherent implements IoEntity {
	private static final long serialVersionUID = 4924955615780825914L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	@Valid
	private Coordonnees coordonnees;
	
	private LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	private Cotisation cotisation;
	
	@OneToMany(mappedBy = "adherent", fetch = FetchType.EAGER)
	private List<Emprunt> listeEmprunt = new ArrayList<>();

	public Adherent() {
	}
	
	public Adherent(String nom, String prenom, String email, LocalDate date, Adresse adresse, Cotisation cotisation) {
		Coordonnees coordonnees = new Coordonnees(nom, prenom, email);
		this.coordonnees = coordonnees;
		this.dateNaissance = date;
		this.adresse = adresse;
		this.cotisation = cotisation;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Cotisation getCotisation() {
		return cotisation;
	}

	public void setCotisation(Cotisation cotisation) {
		this.cotisation = cotisation;
	}

	public List<Emprunt> getListeEmprunt() {
		return listeEmprunt;
	}

	public void setListeEmprunt(List<Emprunt> listeEmprunt) {
		this.listeEmprunt = listeEmprunt;
	}
	
	public int nbMedias(){
		return this.listeEmprunt != null ? this.listeEmprunt.size() : 0;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	@Override
	public String toString() {
		return super.toString() + "Adherent [dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", cotisation=" + cotisation
				+ ", listeEmprunt=" + listeEmprunt + "]";
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

}

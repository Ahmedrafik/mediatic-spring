package fr.iocean.application.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="adherent")
public class Adherent extends Personne implements IoEntity{
	private static final long serialVersionUID = 4924955615780825914L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "date_naissance")
	private LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	private Cotisation cotisation;
	
	@OneToMany(mappedBy = "adherent", fetch = FetchType.EAGER)
	private List<Emprunt> listeEmprunt;

	// Constructeurs

	public Adherent() {
	}
	
	public Adherent(String nom, String prenom, String mail, LocalDate date, Adresse adresse, Cotisation cotisation) {
		super(nom, prenom, mail);
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
	
	public void addEmprunt(Emprunt emprunt){
		if(emprunt != null){
			this.listeEmprunt.add(emprunt);
		}
	}
	
	public int nbMedias(){
		if(this.getListeEmprunt() == null){
			return 0;
		}
		else{
			return this.getListeEmprunt().size();
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Adherent [dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", cotisation=" + cotisation
				+ ", listeEmprunt=" + listeEmprunt + "]";
	}




}

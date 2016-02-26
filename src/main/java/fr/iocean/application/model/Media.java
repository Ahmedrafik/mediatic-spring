package fr.iocean.application.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.iocean.application.typeEnum.TypeMedia;

@Entity
@Table(name="media")
public class Media {

	// Attributs 
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String titre;
	@Column
	private String auteur;
	
	@OneToMany(mappedBy="media")
	private List<Emprunt> listEmprunts;
	
	@Column
	private LocalDate dateEmprunt;
	
	@Column
	@Enumerated(value = EnumType.STRING)
	private TypeMedia typeMedia;
	
	// Constructeur

	public Media(){
	}
	
	public Media(String titre, String auteur, LocalDate dateEmprunt, TypeMedia typeMedia) {
		this.titre = titre;
		this.auteur = auteur;
		this.dateEmprunt = dateEmprunt;
		this.typeMedia = typeMedia;
	}

	
	public Long getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public List<Emprunt> getListEmprunts() {
		return listEmprunts;
	}

	public void setListEmprunts(List<Emprunt> listEmprunts) {
		this.listEmprunts = listEmprunts;
	}

	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public TypeMedia getTypeMedia() {
		return typeMedia;
	}

	public void setTypeMedia(TypeMedia typeMedia) {
		this.typeMedia = typeMedia;
	}
	
	public void addEmprunt(Emprunt e){
		this.listEmprunts.add(e);
	}

	@Override
	public String toString() {
		return "Media [titre=" + titre + ", auteur=" + auteur + ", listEmprunts=" + listEmprunts + ", dateEmprunt="
				+ dateEmprunt + ", typeMedia=" + typeMedia + "]";
	}
	
	
	
}

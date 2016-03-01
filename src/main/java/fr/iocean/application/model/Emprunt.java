package fr.iocean.application.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Emprunt implements IoEntity {
	
	private static final long serialVersionUID = 6401065246919493368L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Adherent adherent;
	
	@ManyToOne
	private Media media;
	
	private Date date_emprunt;
	
	private Date date_retour;
	
	public Emprunt(){}
	
	public Emprunt(Adherent adherent, Media media, Date date_emprunt) {
		this.adherent = adherent;
		this.media = media;
		this.date_emprunt = date_emprunt;
		this.date_retour = null;
	}
	public Emprunt(Adherent adherent, Media media, Date date_emprunt, Date date_retour) {
		this.adherent = adherent;
		this.media = media;
		this.date_emprunt = date_emprunt;
		this.date_retour = date_retour;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public Date getDate_emprunt() {
		return date_emprunt;
	}

	public void setDate_emprunt(Date date_emprunt) {
		this.date_emprunt = date_emprunt;
	}

	public Date getDate_retour() {
		return date_retour;
	}

	public void setDate_retour(Date date_retour) {
		this.date_retour = date_retour;
	}

	@Override
	public String toString() {
		return "Emprunt [adherent=" + adherent.getCoordonnees().getNom() + ", media=" + media.getTitre() + ", date_emprunt=" + date_emprunt
				+ ", date_retour=" + date_retour + "]";
	}

	

	

}

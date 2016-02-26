package fr.iocean.application.utilitaires;

import java.util.Comparator;

import fr.iocean.application.model.Media;

public class MediasComparatorTitre implements Comparator<Media> {

	public int compare(Media o1, Media o2) {
		return o1.getTitre().compareTo(o2.getTitre());
	}

}

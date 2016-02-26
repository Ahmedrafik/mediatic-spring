package fr.iocean.application.utilitaires;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import fr.iocean.application.model.Adherent;
import fr.iocean.application.model.Emprunt;
import fr.iocean.application.model.Media;

public class Utilitaires {

	public static boolean verifierMail(String email) {
		String regex = "[^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$]";
		return regex.matches(email);
	}

	public static String getDateFrancais(LocalDate maDate) {
		return maDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("fr")));
	}

	public static boolean verifierPassword(String password) {
		return (password.length() >= 6);

	}

	public static void sortMediasDate(Adherent ad) {
		EmpruntComparatorDate comparator = new EmpruntComparatorDate();
		ad.getListeEmprunt().sort(comparator);
	}

	public static void sortMediasTitle(Adherent ad) {
		MediasComparatorTitre comparator = new MediasComparatorTitre();
		ArrayList<Media> listMedia = new ArrayList<Media>();
		for(Emprunt emp : ad.getListeEmprunt()){
			listMedia.add(emp.getMedia());
		}
		listMedia.sort(comparator);
	}

}

package persistence;

import java.util.ArrayList;
import java.util.List;

import model.Utente;
import model.Video;

public class DBManager {
	private static DBManager instance = null;
	
	List<Utente> utenti;
	List<Video> video;
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
		utenti = new ArrayList<Utente>();
		video = new ArrayList<Video>();
		aggiungiVideo(new Video("https://www.youtube.com/embed/6hgVihWjK2c?rel=0","v1"));
		aggiungiVideo(new Video("https://www.youtube.com/embed/6hgVihWjK2c?rel=0","v1"));
		aggiungiVideo(new Video("https://www.youtube.com/embed/6hgVihWjK2c?rel=0","v1"));
	}
	
	public void inserisciUtente(Utente u) {
		utenti.add(u);
	}

	public Utente login(String email, String password) {
		if (email.equals("kristian@reale.it") && password.equals("kristian")) {
			Utente u = new Utente();
			u.setEmail("kristian@reale.it");
			u.setPassword("kristian");
			return u;
		}
		return null;
	}
	
	public void aggiungiVideo(Video v) {
		video.add(v);
	}

	public List getVideo() {
		return video;
	}
}

package persistence;

import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.OpzioniRisposte;
import model.Utente;
import model.Video;

public class DBManager {
	private static DBManager instance = null;
	
	List<Utente> utenti;
	ArrayList<Video> video;
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
		utenti = new ArrayList<Utente>();
		video = new ArrayList<Video>();
		aggiungiVideo(new Video("https://www.youtube.com/embed/ODmuRSPTipI","dogso","","",new Categoria("recenti"),null));
		aggiungiVideo(new Video("https://www.youtube.com/embed/5TKseKToQ6c","spa","Questa è la descrizione","DIFFICILE",new Categoria("recenti"),new OpzioniRisposte("corretta", "errata")));
		aggiungiVideo(new Video("https://www.youtube.com/embed/9H4ahHuTGbI","fallo di mani","","",new Categoria("recenti"),null));
		aggiungiVideo(new Video("../video/video1.mp4","fallo di mani","","",new Categoria("recenti"),null));
		
	
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

	public ArrayList<Video> getVideo() {
		return video;
	}
}

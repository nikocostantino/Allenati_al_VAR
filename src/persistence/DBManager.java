package persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Categoria;
import model.OpzioniRisposte;
import model.Utente;
import model.Video;

public class DBManager {
	private static DBManager instance = null;
	
	private List<Utente> utenti;
	
	private HashMap<Utente, ArrayList<Video>> video_preferiti;

	private ArrayList<Video> video;
	
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
		utenti = new ArrayList<Utente>();
		video_preferiti = new HashMap<Utente, ArrayList<Video>>();
		utenti.add(new Utente());
		utenti.get(0).setNome("kristian");
		utenti.get(0).setCognome("reale");
		utenti.get(0).setEmail("kristian@reale.it");
		utenti.get(0).setPassword("kristian");
		video = new ArrayList<Video>();

		aggiungiVideo(new Video("https://www.youtube.com/embed/ODmuRSPTipI","dogso","","",new Categoria("recenti"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("https://www.youtube.com/embed/5TKseKToQ6c","Stopping Promise Attack","Questa è la descrizione","DIFFICILE",new Categoria("recenti"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("https://www.youtube.com/embed/9H4ahHuTGbI","fallo di mani","","",new Categoria("recenti"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("../video/video1.mp4","fallo di mani","","",new Categoria("recenti"),new OpzioniRisposte("corretta", "errata"),true));

		
		video_preferiti.put(utenti.get(0), new ArrayList<Video>());
		
	}
	
	public void inserisciUtente(Utente u) {
		utenti.add(u);
	}

	public Utente login(String email, String password) {
		for(int i=0; i<utenti.size(); i++)
		{	
			if (email.equals(utenti.get(i).getEmail()) && password.equals(utenti.get(i).getPassword())) {
				Utente u = new Utente();
				u.setEmail(utenti.get(i).getEmail());
				u.setPassword(utenti.get(i).getPassword());
				return u;
			}
		}
		return null;
	}
	
	public void aggiungiVideo(Video v) {
		video.add(v);
	}

	public ArrayList<Video> getVideo() {
		return video;
	}
	
	public List<Utente> getUtenti() {
		return utenti;
	}
	
	public void aggiungiAiPreferiti(Utente user, Video v) {
		video_preferiti.get(user).add(v);
	}
	
	public ArrayList<Video> getPreferiti(Utente user){
		return video_preferiti.get(user);
	}
}

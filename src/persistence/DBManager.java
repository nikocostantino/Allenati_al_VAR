package persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import model.Categoria;
import model.OpzioniRisposte;
import model.Utente;
import model.Video;

public class DBManager {
	private static DBManager instance = null;
	
	private List<Utente> utenti;
	
	

	private ArrayList<Video> video;

	private ArrayList<Video> piu_visti;

	private ArrayList<Video> recenti;
	
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
		utenti = new ArrayList<Utente>();
		utenti.add(new Utente());
		utenti.get(0).setNome("kristian");
		utenti.get(0).setCognome("reale");
		utenti.get(0).setEmail("kristian@reale.it");
		utenti.get(0).setPassword("kristian");
		video = new ArrayList<Video>();
		piu_visti = new ArrayList<Video>();
		recenti = new ArrayList<Video>();
		aggiungiVideo(new Video("ODmuRSPTipI","https://www.youtube.com/embed/ODmuRSPTipI","DOGSO","Questo è un video sul DOGSO","NORMALE",new Categoria("DOGSO"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("5TKseKToQ6c","https://www.youtube.com/embed/5TKseKToQ6c","SPA","Questo è un video sulla SPA","DIFFICILE",new Categoria("SPA"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("9H4ahHuTGbI","https://www.youtube.com/embed/9H4ahHuTGbI","FALLO DI MANI","Questo è un video sul fallo di mani","DIFFICILE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("rBCCKH-anBQ","https://www.youtube.com/embed/rBCCKH-anBQ","NEW ENGLAND REVOLUTION VS COLORADO RAPIDS - DOGSO","Questo è un video sul DOGSO","NORMALE",new Categoria("DOGSO"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("K6T__X9t2Fc","https://www.youtube.com/embed/K6T__X9t2Fc","COLUMBUS CREW vs HOUSTON DYNAMO - OFFSIDE and DOGSO","Questo è un video sul DOGSO","NORMALE",new Categoria("DOGSO"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("FkhRBitSt70","https://www.youtube.com/embed/FkhRBitSt70","ATLANTA UNITED vs ORLANDO CITY - DOGSO","Questo è un video sul DOGSO","NORMALE",new Categoria("DOGSO"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("9VJljTFfPhk","https://www.youtube.com/embed/9VJljTFfPhk","PHILADELPHIA UNION vs NY RED BULLS - SPA","Questo è un video sulla SPA","NORMALE",new Categoria("SPA"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("32MCGRKo83M","https://www.youtube.com/embed/32MCGRKo83M","D.C. UNITED vs PHILADELPHIA UNION - FALLO DI MANI","Questo è un video sul fallo di mani","DIFFICILE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("yX79G9nyn1s","https://www.youtube.com/embed/yX79G9nyn1s","PHILADELPHIA UNION vs COLORADO RAPIDS - FALLO DI MANI","Questo è un video sul fallo di mani","DIFFICILE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),false));
		
		aggiungiVideo(new Video("","../video/video1.mp4","CORIGLIANO vs NOLA - DOGSO","Questo è un video sul DOGSO","FACILE",new Categoria("DOGSO"),new OpzioniRisposte("corretta", "errata"),true));
		aggiungiVideo(new Video("","../video/video2.mp4","FALLO DI MANI IN AREA DI RIGORE","Questo è un video sul fallo di mani","FACILE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),true));
		aggiungiVideo(new Video("","../video/video3.mp4","SAN LUCA - BOCALE - SPA","Questo è un video sulla SPA","FACILE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),true));
		aggiungiVideo(new Video("","../video/video4.mp4","FALLO DI MANI IN SERIE D","Questo è un video sul fallo di mani","FACILE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),true));
		aggiungiVideo(new Video("","../video/video5.mp4","SAN LUCA - MORRONE - GRAVE FALLO DI GIOCO","Questo è un video su un grave fallo di gioco","FACILE",new Categoria("FALLO DI GIOCO"),new OpzioniRisposte("corretta", "errata"),true));
		aggiungiVideo(new Video("","../video/video6.mp4","FALLO DI MANI CON VISUALE SULL'AA","Questo è un video sul fallo di mani","NORMALE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),true));
		aggiungiVideo(new Video("","../video/video7.mp4","FALLO DI MANI CON GIOCATA","Questo è un video sul fallo di mani","NORMALE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),true));
		aggiungiVideo(new Video("","../video/video8.mp4","FALLO DI MANI NON PUNIBILE","Questo è un video sul fallo di mani","FACILE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),true));
		aggiungiVideo(new Video("","../video/video9.mp4","DOGSO CON FALLO DI MANI","Questo è un video sul fallo di mani","FACILE",new Categoria("DOGSO"),new OpzioniRisposte("corretta", "errata"),true));
		aggiungiVideo(new Video("","../video/video10.mp4","FALLO DI GIOCO","Questo è un video su fallo di gioco","FACILE",new Categoria("FALLO DI GIOCO"),new OpzioniRisposte("corretta", "errata"),true));
		
		/*
		aggiungiVideo(new Video("ODmuRSPTipI","DOGSO","Questo è un video sul DOGSO","NORMALE",new Categoria("DOGSO"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("5TKseKToQ6c","SPA","Questo è un video sulla SPA","DIFFICILE",new Categoria("SPA"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("9H4ahHuTGbI","FALLO DI MANI","Questo è un video sul fallo di mani","DIFFICILE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("../video/video1.mp4","CORIGLIANO vs NOLA - DOGSO","Questo è un video sul DOGSO","FACILE",new Categoria("DOGSO"),new OpzioniRisposte("corretta", "errata"),true));
		aggiungiVideo(new Video("rBCCKH-anBQ","NEW ENGLAND REVOLUTION VS COLORADO RAPIDS - DOGSO","Questo è un video sul DOGSO","NORMALE",new Categoria("DOGSO"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("K6T__X9t2Fc","COLUMBUS CREW vs HOUSTON DYNAMO - OFFSIDE and DOGSO","Questo è un video sul DOGSO","NORMALE",new Categoria("DOGSO"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("FkhRBitSt70","ATLANTA UNITED vs ORLANDO CITY - DOGSO","Questo è un video sul DOGSO","NORMALE",new Categoria("DOGSO"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("9VJljTFfPhk","PHILADELPHIA UNION vs NY RED BULLS - SPA","Questo è un video sulla SPA","NORMALE",new Categoria("SPA"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("32MCGRKo83M","D.C. UNITED vs PHILADELPHIA UNION - FALLO DI MANI","Questo è un video sul fallo di mani","DIFFICILE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),false));
		aggiungiVideo(new Video("yX79G9nyn1s","PHILADELPHIA UNION vs COLORADO RAPIDS - FALLO DI MANI","Questo è un video sul fallo di mani","DIFFICILE",new Categoria("FALLO DI MANI"),new OpzioniRisposte("corretta", "errata"),false));
*/
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
	public void eliminaVideo(String url)
	{
		for(int i=0; i<video.size(); i++)
		{
			if(video.get(i).getUrl().equals(url))
			{
				video.remove(i);
			}
		}
		
		for(int i=0; i<recenti.size(); i++)
		{
			if(recenti.get(i).getUrl().equals(url))
			{
				recenti.remove(i);
			}
		}
		
		for(int i=0; i<piu_visti.size(); i++)
		{
			if(piu_visti.get(i).getUrl().equals(url))
			{
				piu_visti.remove(i);
			}
		}
	}

	public ArrayList<Video> getPiuVisti() {
		
		int totaleVisualizzazioni = 0;
		
		for (Video video : video) {
			totaleVisualizzazioni+= video.getVisualizzazioni();
		}
		int mediaVisualizzazioni = totaleVisualizzazioni / video.size();
		
		
		for (Video video : video) {
			if(video.getVisualizzazioni() > mediaVisualizzazioni) {
				piu_visti.add(video);
			}
		}
		
		return piu_visti;
	}

	public ArrayList<Video> getRecenti() {
		
		return recenti;
	}

	public void aggiornaRecenti(Video videoChiesto) {
		
		if(recenti.size()>15)
			recenti.remove(15);
		
		if(!recenti.contains(videoChiesto))
			recenti.add(0, videoChiesto);
	}
}

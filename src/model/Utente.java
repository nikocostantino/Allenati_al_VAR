package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Utente {
	private String nome;
	private String cognome;
	private String password;
	private String email;
	private ArrayList<Video> video_preferiti;

	public Utente() {
		this.video_preferiti = new ArrayList<Video>();
	}
	
	public Utente(String nome, String cognome, String password, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
		this.video_preferiti = new ArrayList<Video>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public ArrayList<Video> getPreferiti(){
		return video_preferiti;
	}
	
	public void aggiungiAiPreferiti(Video v) {
		if(!video_preferiti.contains(v))
			video_preferiti.add(v);
		else
			video_preferiti.remove(v);
	}
}

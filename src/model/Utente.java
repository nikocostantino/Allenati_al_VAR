package model;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.tools.javac.code.Attribute.Array;

public class Utente {
	private String nome;
	private String cognome;
	private String password;
	private String email;
	private ArrayList<Video> video_preferiti;
	private ArrayList<ProvaAutovalutazione> storico;

	public Utente() {
		this.video_preferiti = new ArrayList<Video>();
		this.storico = new ArrayList<ProvaAutovalutazione>();
	}
	
	public Utente(String nome, String cognome, String password, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
		this.video_preferiti = new ArrayList<Video>();
		this.storico = new ArrayList<ProvaAutovalutazione>();
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

	public ArrayList<ProvaAutovalutazione> getStorico() {
		return storico;
	}
	
	public void aggiungiAlloStorico(ProvaAutovalutazione provaAutovalutazione) {
		storico.add(provaAutovalutazione);
	}

	public ArrayList<Video> trovaStorico(String data) {
		for (ProvaAutovalutazione provaAutovalutazione : storico) {
			if(provaAutovalutazione.getData().toString().equals(data)) {
				
				System.out.println(data);
				System.out.println(provaAutovalutazione.getData().toString());
				
				return provaAutovalutazione.getVideo();
				
				
			}
				
		}
		return null;
	}
}

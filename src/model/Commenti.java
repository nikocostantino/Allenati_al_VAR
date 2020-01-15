package model;

import java.util.ArrayList;
import java.util.Date;

import persistence.DBManager;

public class Commenti {

	private Long id;
	private ArrayList<String> lista_commenti;
	
	public Commenti() {
		lista_commenti = new ArrayList<String>();
	}
	
	public ArrayList<String> getLista_commenti() {
		return lista_commenti;
	}
	
	public void aggiungiCommento(String nome, String cognome, String testo, String data) {
		lista_commenti.add(nome + " " + cognome + ": " + testo + "\n" + data);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

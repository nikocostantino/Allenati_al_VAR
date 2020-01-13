package model;

import java.util.ArrayList;

import persistence.DBManager;

public class Commenti {

	private ArrayList<String> lista_commenti;
	
	public Commenti() {
		lista_commenti = new ArrayList<String>();
	}
	
	public ArrayList<String> getLista_commenti() {
		return lista_commenti;
	}
	
	public void aggiungiCommento(String testo) {
		lista_commenti.add(testo);
	}
}

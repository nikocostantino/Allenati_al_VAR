package model;

import java.util.ArrayList;

public class Commenti {

	private Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

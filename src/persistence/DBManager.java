package persistence;

import java.util.ArrayList;
import java.util.List;

import model.Utente;

public class DBManager {
	private static DBManager instance = null;
	
	List<Utente> utenti;
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
		utenti = new ArrayList<Utente>();
	}
	
	public void inserisciUtente(Utente u) {
		utenti.add(u);
	}
}

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

	public Utente login(String email, String password) {
		if (email.equals("kristian@reale.it") && password.equals("kristian")) {
			Utente u = new Utente();
			u.setEmail("kristian@reale.it");
			u.setPassword("kristian");
			return u;
		}
		return null;
	}
}

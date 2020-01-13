package persistence;

import java.util.ArrayList;

import model.Esito;

public interface EsitoDAO {

	public void save(Esito esito);  // Create
	public ArrayList<Esito> findByPrimaryKey(String id);     // Retrieve
	public ArrayList<Esito> findAll();       
	public void update(Esito esito); //Update
	public void delete(Esito esito); //Delete	
}

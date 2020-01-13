package persistence;

import java.util.ArrayList;

import model.Categoria;

public interface CategoriaDAO {
	

	public void save(Categoria categoria);  // Create
	public Categoria findByPrimaryKey(String nome);    // Retrieve
	public ArrayList<Categoria> findAll();       
	public void update(Categoria categoria); //Update
	public void delete(Categoria categoria); //Delete	

}

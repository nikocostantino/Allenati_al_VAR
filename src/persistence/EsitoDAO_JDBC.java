package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Esito;

public class EsitoDAO_JDBC implements EsitoDAO{

	@Override
	public void save(Esito esito) {
		//problemi con la query
		
	}

	@Override
	public ArrayList<Esito> findByPrimaryKey(String id) {
		//problemi con la query
		return null;
	}

	@Override
	public ArrayList<Esito> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Esito esito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Esito esito) {
		// TODO Auto-generated method stub
		
	}

}

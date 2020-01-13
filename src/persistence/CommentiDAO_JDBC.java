package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Commenti;
import model.Commenti;
import model.Video;

public class CommentiDAO_JDBC implements CommentiDAO {

	@Override
	public void save(String commento, String url) {
		Connection connection = null;
		try {
			connection = DBManager.getInstance().getConnection();
			String insert = "insert into commenti(commento,fk_utente, fk_video) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, commento);
			statement.setString(2, DBManager.getInstance().getUtenteCorrente().getEmail());
			statement.setString(3, url);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	@Override
	public Commenti findByPrimaryKey(String id) {
		Connection connection = null;
		Commenti commenti = new Commenti();
		try {
			connection = DBManager.getInstance().getConnection();
			PreparedStatement statement;
			String query = "select * from commenti where fk_video = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				commenti.aggiungiCommento(result.getString("commento"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return commenti;
	}

	@Override
	public ArrayList<Commenti> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String commento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String commento) {
		// TODO Auto-generated method stub

	}

}

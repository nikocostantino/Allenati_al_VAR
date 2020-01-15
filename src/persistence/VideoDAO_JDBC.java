package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Categoria;
import model.Commenti;
import model.OpzioniRisposte;
import model.Video;



public class VideoDAO_JDBC implements VideoDAO{

	
	public final String query_findAll = "SELECT * FROM video";
	
	
	@Override
	public Video findByPrimaryKey(String matricola) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Video> findAll() {
		Connection connection = null;
		ArrayList<Video> lista_video = new ArrayList<Video>();
		try {
			connection = DBManager.getInstance().getConnection();
			Video video = null;
			PreparedStatement statement;
			
			statement = connection.prepareStatement(query_findAll);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				video = new Video();
				video.setId(result.getString("id"));				
				video.setUrl(result.getString("url"));
				video.setNome(result.getString("nome"));
				video.setDescrizione(result.getString("descrizione"));
				video.setDifficolta(result.getString("difficoltà"));
				video.setVisualizzazioni(result.getInt("visualizzazioni"));
				
				video.setRisposte(new OpzioniRisposte(result.getString("rispostaCorretta"), result.getString("rispostaErrata"), null));
				
				video.setCategoria(new Categoria(result.getString("categoria")));
				
				video.setCommenti(DBManager.getInstance().getCommentiDAO().findByPrimaryKey(result.getString("url")));
				
				lista_video.add(video);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return lista_video;
	}
	
	@Override
	public void save(Video video) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(Video video) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Video video) {
		// TODO Auto-generated method stub
		
	}

	public boolean esisteVideo(String urlNuovo) {
		Connection connection = null;
	
		try {
			connection = DBManager.getInstance().getConnection();
			
			PreparedStatement statement;
			statement = connection.prepareStatement("SELECT nome FROM video WHERE url=?");
			statement.setString(1, urlNuovo);

			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean esisteNome(String nomeNuovo) {
		Connection connection = null;
		
		try {
			connection = DBManager.getInstance().getConnection();
			
			PreparedStatement statement;
			statement = connection.prepareStatement("SELECT * FROM video WHERE nome=?");
			statement.setString(1, nomeNuovo);

			ResultSet result = statement.executeQuery();
			if(result.next()) {
				System.out.println(result.getString("nome"));
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
}

package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.Categoria;
import model.Commenti;
import model.OpzioniRisposte;
import model.Video;



public class VideoDAO_JDBC implements VideoDAO{

	
	public final String query_findAll = "SELECT id, url, v.nome as nomeVideo, descrizione, difficoltà, visualizzazioni, rispostaCorretta, rispostaErrata, c.nome AS nomeCategoria FROM video v JOIN categoria c ON v.url=c.fk_video";
	public final String query_risposta_corretta = "SELECT * FROM video WHERE url=?";
	
	
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
				video.setNome(result.getString("nomeVideo"));
				video.setDescrizione(result.getString("descrizione"));
				video.setDifficolta(result.getString("difficoltà"));
				video.setVisualizzazioni(result.getInt("visualizzazioni"));
				
				video.setRisposte(new OpzioniRisposte(result.getString("rispostaCorretta"), result.getString("rispostaErrata"), null));
				
				video.setCategoria(new Categoria(result.getString("nomeCategoria")));
				
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
		Connection connection = null;
		try {
			connection = DBManager.getInstance().getConnection();
			String insert = "insert into video(id, url, nome, descrizione, difficoltà, visualizzazioni,rispostaCorretta, rispostaErrata) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, video.getId());
			statement.setString(2, video.getUrl());
			statement.setString(3, video.getNome());
			statement.setString(4, video.getDescrizione());
			statement.setString(5, video.getDifficolta());
			statement.setInt(6, 0);
			statement.setString(7, video.getRisposte().getOpzioneCorretta());
			statement.setString(8, video.getRisposte().getOpzioneErrata());
			statement.setString(9, video.getCategoria().get(0).getNome());
			statement.executeUpdate();
			
			String insertCategoria = "insert into categoria(nome,fk_video,fk_utente,data) values (?,?,?,?)";
			PreparedStatement statementCategoria = connection.prepareStatement(insertCategoria);
			statementCategoria.setString(1, video.getCategoria().get(0).getNome());
			statementCategoria.setString(2, video.getUrl());
			statementCategoria.setString(3, DBManager.getInstance().getUtenteCorrente().getEmail());
			statementCategoria.setString(4, new Date().toLocaleString());
			
			statementCategoria.executeUpdate();
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
	public void update(Video video) {
		Connection connection = null;
		try {
			connection = DBManager.getInstance().getConnection();
			String update = "UPDATE video SET nome=?, descrizione=?, difficoltà=?, rispostacorretta=?, rispostaerrata=? WHERE url=?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setString(1, video.getNome());
			statement.setString(2, video.getDescrizione());
			statement.setString(3, video.getDifficolta());
			statement.setString(4, video.getRisposte().getOpzioneCorretta());
			statement.setString(5, video.getRisposte().getOpzioneErrata());
			statement.setString(6, video.getCategoria().get(0).getNome());
			statement.setString(7, video.getUrl());
			
			statement.executeUpdate();
			
			String updateCategoria = "UPDATE categoria SET nome=? WHERE fk_video=?";
			PreparedStatement statementCategoria = connection.prepareStatement(updateCategoria);
			statementCategoria.setString(1, video.getCategoria().get(0).getNome());
			statementCategoria.setString(2, video.getUrl());
			
			statementCategoria.executeUpdate();
			
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
	public void delete(String url) {
		Connection connection = null;
		
		try {
			connection = DBManager.getInstance().getConnection();
			
			PreparedStatement statement;
			statement = connection.prepareStatement("DELETE FROM video WHERE url=?");
			statement.setString(1, url);

			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	@Override
	public boolean esisteNomeModifica(String modificaNome, String url) {
		Connection connection = null;
		
		try {
			connection = DBManager.getInstance().getConnection();
			
			PreparedStatement statement;
			statement = connection.prepareStatement("SELECT * FROM video WHERE nome=? AND url!=?");
			statement.setString(1, modificaNome);
			statement.setString(2, url);

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
	
	@Override
	public String getRispostaCorretta(String url) {
		
		Connection connection = null;
		String risposta_corretta = null;
		try {
			connection = DBManager.getInstance().getConnection();
			PreparedStatement statement;
			
			statement = connection.prepareStatement(query_risposta_corretta);
			statement.setString(1, url);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				risposta_corretta = result.getString("rispostaCorretta");
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
		return risposta_corretta;
	}
	
	public int updateVisualizzazioni(String url) {
		Connection connection = null;
		int visualizzazioni = 0;
		try {
			connection = DBManager.getInstance().getConnection();
			
			String numeroVisualizzazioni = "SELECT visualizzazioni FROM video WHERE url = ?";
			PreparedStatement statementNumeroVisualizzazioni = connection.prepareStatement(numeroVisualizzazioni);
			statementNumeroVisualizzazioni.setString(1, url);
			ResultSet resNumeroVisualizzazioni = statementNumeroVisualizzazioni.executeQuery();
			if(resNumeroVisualizzazioni.next()) {
				visualizzazioni = resNumeroVisualizzazioni.getInt(1);
			}
			
			String update = "UPDATE video SET visualizzazioni = ? WHERE url=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, ++visualizzazioni );
			statement.setString(2, url);
			
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
		
		return visualizzazioni;
	}
	
	@Override
	public ArrayList<Video> getRicercaPerFiltri(String categoria, int durataMinima, int durataMassima, String dataMinima, String dataMassima, String difficoltà) {
		
		Connection connection = null;
		ArrayList<Video> lista_video = new ArrayList<Video>();
		try {
			connection = DBManager.getInstance().getConnection();
			
			Video video = null;
			String query_filtri = "SELECT * FROM video v JOIN categoria c ON v.url=c.fk_video WHERE c.nome=? AND v.difficoltà=?";
			PreparedStatement statement = connection.prepareStatement(query_filtri);
			statement.setString(1, categoria);
			statement.setString(2, difficoltà);
			
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
				video.setCategoria(new Categoria(result.getString("nome")));
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
}

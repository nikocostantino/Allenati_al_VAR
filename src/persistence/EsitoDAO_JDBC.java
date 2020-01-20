package persistence;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Categoria;
import model.Esito;
import model.OpzioniRisposte;
import model.Video;

public class EsitoDAO_JDBC implements EsitoDAO{

	private static int id = 0;
	
	
	@Override
	public void save(Esito esito) {
		Connection connection = null;
	
		try {
				connection = DBManager.getInstance().getConnection();
				
				
				String maxID = "SELECT MAX(id) FROM esiti";
				PreparedStatement statementMaxID = connection.prepareStatement(maxID);
				ResultSet resMaxID = statementMaxID.executeQuery();
				
				if(resMaxID.next()) {
					id = resMaxID.getInt(1);
					id++;
				}
				
				String insert = "INSERT INTO esiti(id, fk_video, data, risultato, fk_utente, risposta_utente) VALUES (?,?,?,?,?,?)";
				PreparedStatement statement = connection.prepareStatement(insert);
				for (Video video : esito.getVideo()) {
					
					statement.setInt(1, id);
					statement.setString(2, video.getUrl());
					statement.setDate(3, new java.sql.Date(esito.getData().getTime()));
					statement.setBoolean(4, esito.getRisultato());
					statement.setString(5, DBManager.getInstance().getUtenteCorrente().getEmail());
					statement.setBoolean(6, video.getRisposte().getRispostaUtente());
					
					statement.executeUpdate();	
				}
				
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			id++;
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
	}

	@Override
	public ArrayList<Esito> findByPrimaryKey(String email) {
		Connection connection = null;
		ArrayList<Esito> storico = new ArrayList<Esito>();
		try {
			connection = DBManager.getInstance().getConnection();
			PreparedStatement statement;
			String query = "SELECT e.id as idEsito, risultato, url, v.nome as nomeVideo, descrizione, difficoltà, visualizzazioni, rispostaCorretta, rispostaErrata, risposta_utente, c.nome as nomeCategoria, e.data as dataEsito FROM esiti e JOIN video v ON e.fk_video=v.url JOIN categoria c ON c.fk_video=v.url WHERE e.fk_utente = ? ORDER BY e.id";
			
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			
			ResultSet result = statement.executeQuery();
			
			Esito esito = null;
			while(result.next()) {
	
				boolean esiste = false;
				for (Esito e : storico) {
					if(e.getId()==result.getInt("idEsito")) {
						esiste = true;
					}
						
				}
				if(!esiste) {
					esito = new Esito();
					esito.setId(result.getInt("idEsito"));
					esito.setData(result.getDate("dataEsito"));
					esito.setRisultato(result.getBoolean("risultato"));
				}
				Video video = new Video();
				video.setUrl(result.getString("url"));
				video.setNome(result.getString("nomeVideo"));
				video.setDescrizione(result.getString("descrizione"));
				video.setDifficolta(result.getString("difficolt�"));
				video.setVisualizzazioni(result.getInt("visualizzazioni"));
				video.setCategoria(new Categoria(result.getString("nomeCategoria")));
				video.setCommenti(DBManager.getInstance().getCommentiDAO().findByPrimaryKey(result.getString("url")));
				video.setRisposte(new OpzioniRisposte(result.getString("rispostaCorretta"), result.getString("rispostaErrata"), result.getBoolean("risposta_utente")));
				
				esito.getVideo().add(video);
				
				if(!storico.contains(esito)) {
					storico.add(esito);
				}
				
				
				
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
		
		
		return storico;
	}

	@Override
	public ArrayList<Esito> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Esito esito) {
		
	}

	@Override
	public void delete(String url) {
		Connection connection = null;
		
		try {
			connection = DBManager.getInstance().getConnection();
			
			PreparedStatement statement;
			statement = connection.prepareStatement("DELETE FROM esiti WHERE fk_video=?");
			statement.setString(1, url);

			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override
	public ArrayList<Video> getEsito(String email, int id_esito) {
		Connection connection = null;
		Esito esito = new Esito();
		try {
			connection = DBManager.getInstance().getConnection();
			PreparedStatement statement;
			String query = "SELECT e.id as idEsito, risultato, url, v.nome as nomeVideo, descrizione, difficoltà, visualizzazioni, rispostaCorretta, rispostaErrata, risposta_utente, c.nome as nomeCategoria, e.data as dataEsito FROM esiti e JOIN video v ON e.fk_video=v.url JOIN categoria c ON c.fk_video=v.url WHERE e.fk_utente = ? AND e.id = ? ORDER BY e.id";
			
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setInt(2, id_esito);
			
			ResultSet result = statement.executeQuery();
			
			
			while(result.next()) {
				
				esito.setId(result.getInt("idEsito"));
				esito.setData(result.getDate("dataEsito"));
				esito.setRisultato(result.getBoolean("risultato"));

				Video video = new Video();
				video.setUrl(result.getString("url"));
				video.setNome(result.getString("nomeVideo"));
				video.setDescrizione(result.getString("descrizione"));
				video.setDifficolta(result.getString("difficolt�"));
				video.setVisualizzazioni(result.getInt("visualizzazioni"));
				video.setCategoria(new Categoria(result.getString("nomeCategoria")));
				video.setCommenti(DBManager.getInstance().getCommentiDAO().findByPrimaryKey(result.getString("url")));
				video.setRisposte(new OpzioniRisposte(result.getString("rispostaCorretta"), result.getString("rispostaErrata"), result.getBoolean("risposta_utente")));
				
				esito.getVideo().add(video);
				
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
		
		
		
		return esito.getVideo();
		
	}

}

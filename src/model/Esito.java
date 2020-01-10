package model;

import java.util.ArrayList;
import java.util.Date;

public class Esito {

	private Long id;
	private ArrayList<Video> video;
	private Date data;
	private Boolean risultato;
	
	
	public Esito(ArrayList<Video> video) {
	
		this.video = video;
		data = new Date();
		risultato = true;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Video> getVideo() {
		return video;
	}

	public void setVideo(ArrayList<Video> video) {
		this.video = video;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Boolean getRisultato() {
		return risultato;
	}

	public void setRisultato(Boolean risultato) {
		this.risultato = risultato;
	}
	
	
}

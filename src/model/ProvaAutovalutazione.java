package model;

import java.util.ArrayList;
import java.util.Date;

public class ProvaAutovalutazione {

	private ArrayList<Video> video;
	private Date data;
	private Boolean risultato;
	
	public ProvaAutovalutazione(ArrayList<Video> video) {
	
		this.video = video;
		data = new Date();
		risultato = true;
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

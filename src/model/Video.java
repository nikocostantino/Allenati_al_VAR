package model;

import persistence.DBManager;

public class Video {

	private String id;
	private String url;
	private String nome;
	private String descrizione;
	private String difficolta;
	private int visualizzazioni;
	private Categoria categoria;
	private Commenti commenti;
	private OpzioniRisposte risposte;
	private Boolean locale;


	public Video(String id,String url, String nome, String descrizione, String difficolta, Categoria categoria, OpzioniRisposte risposte, Boolean locale) {
		this.id = id;
		this.url = url;
		this.nome = nome;
		this.descrizione = descrizione;
		this.difficolta = difficolta;
		this.visualizzazioni = 0;
		this.categoria = categoria;
		this.commenti = new Commenti();
		this.risposte = risposte;
		this.categoria.addVideo(this);
		this.locale = locale;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDifficolta() {
		return difficolta;
	}

	public void setDifficolta(String difficolta) {
		this.difficolta = difficolta;
	}

	public int getVisualizzazioni() {
		return visualizzazioni;
	}

	public void setVisualizzazioni(int visualizzazioni) {
		this.visualizzazioni = visualizzazioni;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Commenti getCommenti() {
		return commenti;
	}

	public void setCommenti(Commenti commenti) {
		this.commenti = commenti;
	}

	public OpzioniRisposte getRisposte() {
		return risposte;
	}

	public void setRisposte(OpzioniRisposte risposte) {
		this.risposte = risposte;
	}
	
	public Boolean getLocale() {
		return locale;
	}

	public void setLocale(Boolean locale) {
		this.locale = locale;
	}

	public Boolean isPreferito() {
		return DBManager.getInstance().getUtenti().get(0).getPreferiti().contains(this);
	}
}

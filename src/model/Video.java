package model;

public class Video {

	private String url;
	private String nome;
	private String descrizione;
	private String difficolta;
	private int visualizzazioni;
	private Categoria categoria;
	private Commenti commenti;
	private OpzioniRisposte risposte;
	
	public Video(String url, String nome, String descrizione, String difficolta, Categoria categoria, OpzioniRisposte risposte) {
		this.url = url;
		this.nome = nome;
		this.descrizione = descrizione;
		this.difficolta = difficolta;
		this.visualizzazioni = 0;
		this.categoria = categoria;
		this.commenti = new Commenti();
		this.risposte = risposte;
		
		this.categoria.addVideo(this);
		
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
	
	
}

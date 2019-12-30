package model;

public class OpzioniRisposte {
	
	private String opzioneCorretta;
	private String opzioneErrata;
	private Boolean rispostaUtente; //true se l'utente ha inserito la risposta corretta
	
	

	public OpzioniRisposte(String opzioneCorretta, String opzioneErrata) {
		
		this.opzioneCorretta = opzioneCorretta;
		this.opzioneErrata = opzioneErrata;
		this.rispostaUtente = false;
	}

	public String getOpzioneCorretta() {
		return opzioneCorretta;
	}
	
	public String getOpzioneErrata() {
		return opzioneErrata;
	}
	public Boolean getRispostaUtente() {
		return rispostaUtente;
	}

	public void setRispostaUtente(Boolean rispostaUtente) {
		this.rispostaUtente = rispostaUtente;
	}
}

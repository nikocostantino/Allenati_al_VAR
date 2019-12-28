package model;

public class OpzioniRisposte {
	
	private String opzioneCorretta;
	private String opzioneErrata;
	
	public OpzioniRisposte(String opzioneCorretta, String opzioneErrata) {
		
		this.opzioneCorretta = opzioneCorretta;
		this.opzioneErrata = opzioneErrata;
	}

	public String getOpzioneCorretta() {
		return opzioneCorretta;
	}
	
	public String getOpzioneErrata() {
		return opzioneErrata;
	}
}

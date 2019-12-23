package model;

public class OpzioniRisposte {
	
	private String opzioneCorretta;
	private String opzioneErrata;
	
	public OpzioniRisposte(String opzioneCorretta, String opzioneErrata) {
		
		this.opzioneCorretta = opzioneCorretta;
		this.opzioneErrata = opzioneErrata;
	}

	public String getCorretta() {
		return opzioneCorretta;
	}
	
	public String getErrata() {
		return opzioneErrata;
	}
}

package model;

import java.util.ArrayList;

public class Categoria {

	private ArrayList<Video> video;
	private String nome;
	
	public Categoria(String nome) {
		video = new ArrayList<Video>();
		this.nome = nome;
	}
	
	public void addVideo(Video v) {
		video.add(v);
	}
	
	public String getNome() {
		return nome;
	}
	
}

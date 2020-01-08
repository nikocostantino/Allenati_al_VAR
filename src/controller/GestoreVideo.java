package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import model.OpzioniRisposte;
import model.Video;
import persistence.DBManager;

public class GestoreVideo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url=req.getParameter("eliminaVideo");
		if(url!=null)
		{
			DBManager.getInstance().eliminaVideo(url);
		}
		
		String nuovoVideo=req.getParameter("aggiungiVideo");
		if(nuovoVideo.equals("true"))
		{
			String link = req.getParameter("link");
			String nome = req.getParameter("nome");
			String categoria = req.getParameter("categoria");
			String gradoDifficolta = req.getParameter("grado di difficolt�");
			String rispostaCorretta = req.getParameter("opzione di risposta corretta");
			String rispostaErrata = req.getParameter("opzione di risposta errata");
			String descrizione = req.getParameter("descrizione");	
			
			Video V = new Video("1", link, nome, descrizione, gradoDifficolta, new Categoria(categoria), new OpzioniRisposte(rispostaCorretta, rispostaErrata), false);
			DBManager.getInstance().aggiungiVideo(V);
			
			
		}
		RequestDispatcher rd = req.getRequestDispatcher("/html/home");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

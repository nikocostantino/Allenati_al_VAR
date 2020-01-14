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
		String nuovoVideo=req.getParameter("aggiungiVideo");
		String urlNuovo = req.getParameter("urlNuovo");
		String nomeNuovo = req.getParameter("nomeNuovo");
		
		if(url!=null)
		{
			DBManager.getInstance().eliminaVideo(url);
		
			req.getSession().setAttribute("eliminaVideo", url);

			RequestDispatcher rd = req.getRequestDispatcher("/html/home");
			rd.forward(req, resp);
		
			req.getSession().removeAttribute("eliminaVideo");

		}
		
		else if(nuovoVideo!=null && nuovoVideo.equals("true"))
		{
			String link = req.getParameter("link");
			String nome = req.getParameter("nome");
			String categoria = req.getParameter("categoria");
			String gradoDifficolta = req.getParameter("grado di difficolt�");
			String rispostaCorretta = req.getParameter("opzioneRispostaCorretta");
			String rispostaErrata = req.getParameter("opzioneRispostaErrata");
			String descrizione = req.getParameter("descrizione");	
			Video V = new Video(link.substring(30), link, nome, descrizione, gradoDifficolta, new Categoria(categoria), new OpzioniRisposte(rispostaCorretta, rispostaErrata), false);
			DBManager.getInstance().aggiungiVideo(V);

					
			req.getSession().setAttribute("link", V);
			
			RequestDispatcher rd = req.getRequestDispatcher("/html/pagina_video?url="+link);
			rd.forward(req, resp);
			
			req.getSession().removeAttribute("link");
		}
		else if(urlNuovo!=null)
		{
			System.out.println(urlNuovo);
			if(urlNuovo.matches("https://www.youtube.com/embed/(.*)") == false)
			{
				
				resp.getOutputStream().println(
						"<div id='formatErrato' class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Formato video non valido!</strong></div>"
						);
			}
			else
			{
				if(DBManager.getInstance().getVideoDAO().esisteVideo(urlNuovo))
				{
					resp.getOutputStream().println(
							"<div id='formatErrato' class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Il video &egrave; gi&agrave; presente!</strong></div>"
							);
				}
				else
				{
					resp.getOutputStream().println("urlCorretto");
				}
			}
		}
		else if(nomeNuovo!=null && nomeNuovo!="")
		{
			if(DBManager.getInstance().getVideoDAO().esisteNome(nomeNuovo))
			{
				resp.getOutputStream().println(
						"<div id='formatErrato' class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Nome gi&agrave; utilizzato!</strong></div>"
						);
			}
			else
			{
				resp.getOutputStream().println("nomeCorretto");

			}

		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

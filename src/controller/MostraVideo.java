package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.AddPortOffsetRule;

import model.Video;
import persistence.DBManager;

public class MostraVideo extends HttpServlet{

	
	Video videoChiesto = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("pagina_video.jsp");
		String url = req.getParameter("url");
		
		if(url!=null) {
			req.getSession().setAttribute("url", req.getParameter("url"));
			for (Video video : DBManager.getInstance().getVideo()) {
				if(video.getUrl().equals(req.getParameter("url"))){
					req.getSession().setAttribute("id", video.getId());
					if(video.getLocale()==true)
						req.getSession().setAttribute("locale", true);
				}
				
			}
			ArrayList<Video> video = DBManager.getInstance().getVideo();
			
			for(Video v : video) {
				if(v.getUrl().equals(url))
					videoChiesto = v;			
			}
			videoChiesto.setVisualizzazioni(videoChiesto.getVisualizzazioni()+1); 
			req.getSession().setAttribute("nome", videoChiesto.getNome());
			req.getSession().setAttribute("descrizione", videoChiesto.getDescrizione());
			req.getSession().setAttribute("categoria", videoChiesto.getCategoria().getNome());
			req.getSession().setAttribute("difficolta", videoChiesto.getDifficolta());
			req.getSession().setAttribute("visualizzazioni", videoChiesto.getVisualizzazioni());
			req.getSession().setAttribute("rispostaCorretta", videoChiesto.getRisposte().getOpzioneCorretta());
			req.getSession().setAttribute("rispostaErrata", videoChiesto.getRisposte().getOpzioneErrata());
			req.getSession().setAttribute("isPreferito", videoChiesto.isPreferito());
			
		}
		if(req.getParameter("addPreferiti") != null) {
			DBManager.getInstance().getUtenti().get(0).aggiungiAiPreferiti(videoChiesto);
			req.getSession().setAttribute("isPreferito", videoChiesto.isPreferito());
		}
		
		videoChiesto.getCommenti().aggiungiCommento(req.getParameter("commento"));
		req.getSession().setAttribute("lista_commenti", videoChiesto.getCommenti().getLista_commenti());
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}

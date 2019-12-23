package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Video;
import persistence.DBManager;

public class MostraVideo extends HttpServlet{

	
	private Video videoChiesto = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("pagina_video.jsp");
		String url = req.getParameter("url");
		
		if(url!=null) {
			req.getSession().setAttribute("url", req.getParameter("url"));
			ArrayList<Video> video = DBManager.getInstance().getVideo();
			
			for(Video v : video) {
				if(v.getUrl().equals(url))
					videoChiesto = v;			
			}
			req.getSession().setAttribute("nome", videoChiesto.getNome());
			req.getSession().setAttribute("descrizione", videoChiesto.getDescrizione());
			req.getSession().setAttribute("categoria", videoChiesto.getCategoria().getNome());
			req.getSession().setAttribute("difficolta", videoChiesto.getDifficolta());
			req.getSession().setAttribute("rispostaCorretta", videoChiesto.getRisposte().getCorretta());
			req.getSession().setAttribute("rispostaErrata", videoChiesto.getRisposte().getErrata());
			
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

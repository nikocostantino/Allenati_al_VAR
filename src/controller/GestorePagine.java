package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProvaAutovalutazione;
import model.Video;
import persistence.DBManager;

public class GestorePagine extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String pagina = req.getParameter("pagina");
		if(pagina.equals("preferiti")) {
			ArrayList<Video> preferiti = DBManager.getInstance().getUtenti().get(0).getPreferiti();
			req.getSession().setAttribute("video_preferiti",preferiti);
		}
		else if(pagina.contentEquals("storico")) {
			req.getSession().setAttribute("storico",DBManager.getInstance().getUtenti().get(0).getStorico());
		}
		else if(pagina.contentEquals("registrati")){
			//operzioni per la pagina di registrazione
			RequestDispatcher rd = req.getRequestDispatcher(pagina+".html");
			rd.forward(req, resp);
			return;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(pagina+".jsp");
		rd.forward(req, resp);
	}

}

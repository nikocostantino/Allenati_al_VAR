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

public class Ricerca extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("textRicerca", req.getParameter("textRicerca") );
		String textRicerca = req.getParameter("textRicerca");
		
		ArrayList<Video> video = DBManager.getInstance().getVideo(); 
		ArrayList<Video> risultatoRicerca = new ArrayList<Video>();
		
		
		for(int i=0; i<video.size(); i++) {
			if(video.get(i).getNome().equals(textRicerca)) {
				risultatoRicerca.add(video.get(i));
			}
		}
		
		req.getSession().setAttribute("risultatoRicerca", risultatoRicerca);
		
		RequestDispatcher rd = req.getRequestDispatcher("risultatoRicerca.jsp");
		rd.forward(req, resp);
	}
}

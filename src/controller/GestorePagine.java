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

public class GestorePagine extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ArrayList<Video> preferiti = DBManager.getInstance().getPreferiti(DBManager.getInstance().getUtenti().get(0));
		req.getSession().setAttribute("video_preferiti",preferiti);
		RequestDispatcher rd = req.getRequestDispatcher(req.getHttpServletMapping().getPattern().replace("/html/", "")+".jsp");
		rd.forward(req, resp);
	}

}

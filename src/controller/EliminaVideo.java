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

public class EliminaVideo extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String url = req.getParameter("url");
		DBManager.getInstance().eliminaVideo(url);
		RequestDispatcher rd = req.getRequestDispatcher("/html/home");
		rd.forward(req, resp);
		
		
	}
}

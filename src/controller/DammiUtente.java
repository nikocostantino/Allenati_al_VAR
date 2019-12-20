package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;

public class DammiUtente extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		resp.getWriter().println("<h1>Hello World!!</h1>");
		RequestDispatcher rd = req.getRequestDispatcher("ottieniUtenti.html");
		rd.forward(req, resp);
//		rd.include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utente s = (Utente) req.getSession().getAttribute("utenteRegistrato");
		
		resp.getWriter().println("utente " + s.getCognome());
	}
}

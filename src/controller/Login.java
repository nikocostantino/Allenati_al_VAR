package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistence.DBManager;


public class Login extends HttpServlet{
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("sono qui GET");

				RequestDispatcher rd = req.getRequestDispatcher("/index");
				rd.forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			Utente utente = DBManager.getInstance().login(email, password);
			if (utente != null) {
				req.getSession().setAttribute("utente", utente);
				RequestDispatcher rd = req.getRequestDispatcher("/home");
				rd.forward(req, resp);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("/html/error_page.html");
				rd.forward(req, resp);
			}
			
		}
}

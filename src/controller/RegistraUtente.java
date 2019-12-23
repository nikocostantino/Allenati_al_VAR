package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistence.DBManager;

public class RegistraUtente extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confPassword = req.getParameter("conferma_password");
		
		
		if(password.equals(confPassword))  //ovviamente devo controllare anche altri parametri
		{
			Utente ut = new Utente();
			ut.setNome(nome);
			ut.setCognome(cognome);
			ut.setPassword(password);
			ut.setEmail(email);
			
			DBManager.getInstance().inserisciUtente(ut);
			
			req.setAttribute("utenteRegistrato", ut);
			
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
			
			System.out.println(email + " "  + nome + " " + cognome);
		}
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("error_page.html");
			rd.forward(req, resp);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}

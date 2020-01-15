package controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import model.Video;
import persistence.DBManager;


public class Login extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RequestDispatcher rd = req.getRequestDispatcher("/index");
			rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if (req.getParameter("login")!= null && req.getParameter("login").equals("true")) {

			String email = req.getParameter("email");
			String password = req.getParameter("password");
			Utente utente = DBManager.getInstance().login(email,password);

			if (utente != null) {
				DBManager.getInstance().setUtenteCorrente(utente);
				req.getSession().setAttribute("utente", utente);
						
				DBManager.getInstance().setUtenteCorrente(utente);
				RequestDispatcher rd = req.getRequestDispatcher("/html/home");
				rd.forward(req, resp);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("/html/error_page.html");
				rd.forward(req, resp);
			}
		}
		else if (req.getParameter("registrazione")!= null && req.getParameter("registrazione").equals("true")){
			
			String nome = req.getParameter("nome");
			String cognome = req.getParameter("cognome");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String confPassword = req.getParameter("conferma_password");
			String amministratore = req.getParameter("amministratore");
			
			
			if(password.equals(confPassword))
			{
				Utente user = new Utente(nome,cognome,email,password,amministratore);
				user.setNome(nome);
				user.setCognome(cognome);
				user.setPassword(password);
				user.setEmail(email);
				user.setAmministratore(amministratore);
				DBManager.getInstance().inserisciUtente(user);
				
				req.setAttribute("utenteRegistrato", user);
				
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);
				
			}
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("error_page.html");
				rd.forward(req, resp);
			}
			
		}
	}
}
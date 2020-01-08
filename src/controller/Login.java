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
		
		
		
		if(req.getParameter("login").equals("true")) {
			
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			Utente utente = DBManager.getInstance().login(email, password);
			if (utente != null) {
				req.getSession().setAttribute("utente", utente);

				//resp.sendRedirect(".");
				List<Video> video = DBManager.getInstance().getVideo();
				req.getSession().setAttribute("video", video);
				List<Video> piu_visti = DBManager.getInstance().getPiuVisti();
				req.getSession().setAttribute("video_piu_visti", piu_visti);
				List<Video> recenti = DBManager.getInstance().getRecenti();
				req.getSession().setAttribute("video_recenti", recenti);

				RequestDispatcher rd = req.getRequestDispatcher("/html/home");
				rd.forward(req, resp);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("/html/error_page.html");
				rd.forward(req, resp);
			}
		}
		else if (req.getParameter("registrazione").equals("true")){
			
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
				
			}
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("error_page.html");
				rd.forward(req, resp);
			}
			
		}
	}
}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
			System.out.println("ciao");
			RequestDispatcher rd = req.getRequestDispatcher("html/home.html");
=======
			System.out.println("sono nella do get di home");
			RequestDispatcher rd = req.getRequestDispatcher("home2.html");
>>>>>>> branch 'master' of https://github.com/nikocostantino/Allenati_al_VAR
			rd.forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
}

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OpzioniRisposte;
import model.Video;
import persistence.DBManager;

public class ProvaAutovalutazione extends HttpServlet {

	ArrayList<Video> videoProva = new ArrayList<Video>();
	ArrayList<Boolean> risposteProva = new ArrayList<Boolean>();
	Random random = new Random();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("prova_autovalutazione.jsp");

		if (req.getParameter("risposta") == null) {

			while (videoProva.size() <= 3) {
				int indice = random.nextInt(DBManager.getInstance().getVideo().size());
				while (videoProva.contains(DBManager.getInstance().getVideo().get(indice))) {
					indice = random.nextInt(DBManager.getInstance().getVideo().size());
				}
				videoProva.add(DBManager.getInstance().getVideo().get(indice));
			}
			req.getSession().setAttribute("videoProva", videoProva);
		} else {
			if (req.getParameter("risposta").equals("corretta"))
				risposteProva.add(true);
			else
				risposteProva.add(false);

			videoProva.remove(0);

			if (videoProva.isEmpty()) {
				rd = req.getRequestDispatcher("esito.jsp");
				req.getSession().setAttribute("risposteProva", risposteProva);
			}

		}

		rd.forward(req, resp);
	}

}

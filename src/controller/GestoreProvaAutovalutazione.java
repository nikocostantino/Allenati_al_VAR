package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OpzioniRisposte;
import model.ProvaAutovalutazione;
import model.Video;
import persistence.DBManager;

public class GestoreProvaAutovalutazione extends HttpServlet {

	private ArrayList<Video> videoProva = new ArrayList<Video>();
	private ArrayList<Video> esito = new ArrayList<Video>();
	private Random random = new Random();
	private int risposteErrate;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("prova_autovalutazione.jsp");

		if (req.getParameter("risposta") == null) {
			esito.clear();
			risposteErrate = 0;
			if(DBManager.getInstance().getVideo().size()<10) {
				rd = req.getRequestDispatcher("error_page.html");
				rd.forward(req, resp);
				return;
			}
			while (videoProva.size() <= 9) {
				int indice = random.nextInt(DBManager.getInstance().getVideo().size());
				while (videoProva.contains(DBManager.getInstance().getVideo().get(indice))) {
					indice = random.nextInt(DBManager.getInstance().getVideo().size());
				}
				videoProva.add(DBManager.getInstance().getVideo().get(indice));
			}
			req.getSession().setAttribute("videoProva", videoProva);
		} else {
			
			if (req.getParameter("risposta").equals("corretta"))
				videoProva.get(0).getRisposte().setRispostaUtente(true);
			else
				videoProva.get(0).getRisposte().setRispostaUtente(false);

			esito.add(videoProva.get(0));
			
			videoProva.remove(0);

			if (videoProva.isEmpty()) {
				ProvaAutovalutazione prova = new ProvaAutovalutazione(esito);
				for (Video video : esito) {
					if(!video.getRisposte().getRispostaUtente())
						risposteErrate++;
				}
				if(risposteErrate>4)
					prova.setRisultato(false);
				
				DBManager.getInstance().getUtenti().get(0).aggiungiAlloStorico(prova);
				rd = req.getRequestDispatcher("esito.jsp");
				req.getSession().setAttribute("esito", esito);
			}

		}

		rd.forward(req, resp);
	}

}

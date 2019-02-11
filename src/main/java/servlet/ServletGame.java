package servlet;

import controller.Context;
import controller.GameController;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletGame")
public class ServletGame extends HttpServlet {

    private String pos = "";
    private String giu = "";

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        GameController tmp = Context.getInstance().getGameController();

        String tent1 = req.getParameter("tent_num1");
        String tent2 = req.getParameter("tent_num2");
        String tent3 = req.getParameter("tent_num3");
        ArrayList<Integer> master = tmp.masterArrList;
        for (int n : master)
            System.out.print("Master " + n + " - ");

        try {
            ArrayList<Integer> utente_prova = new ArrayList<>();
            utente_prova.add(Integer.parseInt(tent1));
            utente_prova.add(Integer.parseInt(tent2));
            utente_prova.add(Integer.parseInt(tent3));
            //Stampo a console come CHECK personale
            for(int n: utente_prova) {
                System.out.print(n + " ");
            }

            int k = tmp.getTentativi();

            if(tmp.getTentativi() > 0) {

                int[] eccoci = tmp.checker(master, utente_prova);
                pos = eccoci[0] + "";
                giu = eccoci[1] + "";

                System.out.println("");
                System.out.println(pos+ " pos");
                System.out.println(giu+ " num_giusto");
                System.out.println(k + " tentativo");

                req.setAttribute("pos_n", pos);
                req.setAttribute("giu_n", giu);
                req.setAttribute("tent", k);
                k--;
                tmp.setTentativi(k);

                tmp.saveTentativo(utente_prova);

                if (pos.equals("3")) {
                    req.getRequestDispatcher("/jsp/risultato.jsp").forward(req, resp);
                    tmp.setTentativi(10);
                    destroy();talia
                } else
                    req.getRequestDispatcher("/jsp/gioco.jsp").forward(req, resp);
            }
            else {
                req.getRequestDispatcher("/jsp/perso.jsp").forward(req, resp);
                tmp.setTentativi(10);
                destroy();

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
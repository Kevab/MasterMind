package servlet;

import controller.Context;
import controller.GameController;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/ServletMain")
public class ServletMain extends HttpServlet {

    //Inizializzo il contesto su cui si basa tutto il BACKEND del gioco
    public void init() throws ServletException {
        controller.Context.getInstance();
    }

    public void service(ServletRequest req, ServletResponse resp)
            throws ServletException, IOException {

        GameController tmp = Context.getInstance().getGameController();

        String userNome = req.getParameter("nome_user");
        tmp.nomeUtenteSET(userNome);

        req.setAttribute("nome_user", tmp.nomeUtenteGET());
        System.out.println(tmp.nomeUtenteGET());
        tmp.saveCombination();
        tmp.creaMaster();
        req.getRequestDispatcher("/jsp/gioco.jsp").forward(req,resp);
    }

}

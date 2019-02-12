package servlet;

import controller.Context;
import controller.GameController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletMain")
public class ServletMain extends HttpServlet {

    //Inizializzo il contesto su cui si basa tutto il BACKEND del gioco
    public void init() throws ServletException {
        controller.Context.getInstance();
    }

    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        GameController tmp = Context.getInstance().getGameController();
        HttpSession session = req.getSession();

        String userNome = req.getParameter("nome_user");
        tmp.nomeUtenteSET(userNome);

        session.setAttribute("userNome", userNome);
        req.setAttribute("nome_user", tmp.nomeUtenteGET());
        System.out.println(tmp.nomeUtenteGET());
        tmp.creaMaster();
        tmp.saveCombination();
        req.getRequestDispatcher("/jsp/gioco.jsp").forward(req,resp);
    }

}

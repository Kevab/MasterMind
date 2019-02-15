package servlet;

import controller.ClassificaController;
import controller.Context;
import controller.GameController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ServletClassifica")
public class ServletClassifica extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClassificaController classificaController = Context.getInstance().getClassificaController();

        String classUser = req.getParameter("classifica_user");
        String classTent = req.getParameter("classifica_tentativo");

        classificaController.getUserClassifica();


    }
}

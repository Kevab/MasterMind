package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletClassifica")
public class ServletClassifica extends HttpServlet {

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String classUser = req.getParameter("classifica_user");
        String classTent = req.getParameter("classifica_tentativo");


    }
}

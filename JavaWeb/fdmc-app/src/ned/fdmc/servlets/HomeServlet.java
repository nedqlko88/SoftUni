package ned.fdmc.servlets;

import ned.fdmc.data.Cat;
import ned.fdmc.data.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    //init method se izpylnqva pri inicializiraneto na HomeServleta ( toest izpylnqva se vednyj)
    @Override
    public void init() throws ServletException {
        List<Cat> cats = new ArrayList<>();
        List<User> users = new ArrayList<>();
        this.getServletContext().setAttribute("cats", cats);
        this.getServletContext().setAttribute("users", users);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("home.jsp").forward(req,resp);


    }
}

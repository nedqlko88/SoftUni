package ned.fdmc.servlets.home;

import ned.fdmc.data.models.Cat;
import ned.fdmc.data.models.User;
import ned.fdmc.data.repos.CatRepo;
import ned.fdmc.data.repos.UserRepo;

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
        this.getServletContext().setAttribute("cats", new CatRepo());
        this.getServletContext().setAttribute("users", new UserRepo());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("home.jsp").forward(req,resp);


    }
}

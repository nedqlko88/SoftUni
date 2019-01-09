package ned.fdmc.servlets.cats;

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
import java.util.List;

@WebServlet("/cats/create")
public class CatsCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("create.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String color = req.getParameter("color");
        Integer numberOfLegs = Integer.valueOf(req.getParameter("legs"));
        String username = (String) req.getSession().getAttribute("username");
        User creator = ((UserRepo)this.getServletContext().getAttribute("users")).getByUsername(username);


        Cat cat = new Cat(name, breed, color, numberOfLegs, creator);

        ((CatRepo) this.getServletContext().getAttribute("cats")).addCat(cat);

        resp.sendRedirect("/cats/profile?catName=" + cat.getName());
    }
}

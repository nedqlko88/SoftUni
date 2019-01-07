package ned.fdmc.servlets;

import ned.fdmc.data.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/users/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        List<User> users = (List<User>) this.getServletContext().getAttribute("users");

        User user = users.stream().filter(x -> x.getUsername().equals(username)).findFirst().orElse(null);

        if (user == null || !user.getPassword().equals(password)) {
            resp.sendRedirect("/users/login");
            return;
        }

        req.getSession().setAttribute("username", user.getUsername());
        resp.sendRedirect("/");

    }
}

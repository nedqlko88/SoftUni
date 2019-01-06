import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/nedqlko")
public class NedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      it's not good to write here the html so we will use jsp
//        resp.getWriter().write("<h1>hello Nedqlko</h1>");
//        resp.getWriter().write("<font color=red><b>" + req.getQueryString() + "<b></font>");

//        super.doGet(req, resp);

        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req,resp);
    }
}

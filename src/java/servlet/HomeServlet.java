package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Login page and request servlet
 */
@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends BaseServlet {

    /**
     * to home page
     *
     * @param request servlet request
     * @param response servlet response
     */
    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = (String)request.getSession().getAttribute("role");

        if (role == null) {
            request.getSession().removeAttribute("userId");
            request.setAttribute("msg", "Illegal user");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        if (role.equals("Retailers")) {
            response.sendRedirect("/inventory");
            return;
        }
        if (role.equals("Charitable Organizations")) {
            response.sendRedirect("/receive");
            return;
        }
        if (role.equals("Consumers")) {
            response.sendRedirect("/purchase");
            return;
        }

        request.getSession().removeAttribute("userId");
        request.setAttribute("msg", "Illegal user");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

}

package servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * Register page and request servlet
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends BaseServlet{


    private final UserDao userDao = UserDao.getInstance();

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get request parameter
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("username");
        String role = request.getParameter("role");

        if (email == null || password == null || name == null || role == null){
            request.setAttribute("msg", "Parameter cannot be empty");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        if (!Objects.equals(role, "Retailers")
                && !Objects.equals(role, "Charitable Organizations")
                && !Objects.equals(role, "Consumers")){
            request.setAttribute("msg", "Role is incorrect");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        // check email
        if (userDao.getByEmail(email) != null){
            request.setAttribute("msg", "Email has been registered");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        // create user
        userDao.create(email, password, name, role);
        response.sendRedirect("/login");
    }


    /**
     * to register page
     *
     * @param request servlet request
     * @param response servlet response
     */
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

}

package servlet;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Login page and request servlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends BaseServlet {

    private final UserDao userDao = UserDao.getInstance();

    /**
     * User login
     *
     * @param request servlet Request
     * @param response servlet Response
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userDao.getByEmail(email);
        if (user == null){
            request.setAttribute("msg", "User not found");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        // Check password
        if (!user.getPassword().equals(password)){
            request.setAttribute("msg", "Password is incorrect");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        request.getSession().setAttribute("userId", user.getId());
        request.getSession().setAttribute("role", user.getRole());
        request.getSession().setAttribute("name", user.getUsername());
        response.sendRedirect("/home");
    }

    /**
     * User logout
     *
     * @param request servlet Request
     * @param response servlet Response
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("userId");
        request.getSession().removeAttribute("role");
        request.getSession().removeAttribute("name");
        response.sendRedirect("/login");
    }

    /**
     * to login page
     *
     * @param request servlet request
     * @param response servlet response
     */
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

}

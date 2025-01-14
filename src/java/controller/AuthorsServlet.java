package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import businesslayer.AuthorsBusinessLogic;
import businesslayer.UserBusinessLogic;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Author;
import model.User;

public class AuthorsServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        AuthorsBusinessLogic authorBusinessLogic = new AuthorsBusinessLogic();
//        List<Author> authors = null;
//
//        try {
//            authors = authorBusinessLogic.getAllAuthors();
//        } catch (SQLException ex) {
//            log(ex.getMessage());
//        }
//
//        request.setAttribute("authors", authors);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("views/authors.jsp");
//        dispatcher.forward(request, response);
        request.setAttribute("msg", "Password is incorrect");
        UserBusinessLogic UB=new UserBusinessLogic();
          List<User>  users= null;
          
           try {
             users = UB.getAllUsers();
        } catch (SQLException ex) {
            log(ex.getMessage());
        }
        
        
     
            request.setAttribute("users", users);


        RequestDispatcher dispatcher = request.getRequestDispatcher("views/authors.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //        addAuthor(request, response);
//
//        doGet(request, response);

        if(checkUser(request, response)){
            doGet(request, response);
        }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void addAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthorsBusinessLogic authorBusinessLogic = new AuthorsBusinessLogic();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorBusinessLogic.addAuthor(author);
    }
    
    private Boolean checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        UserBusinessLogic UB=new UserBusinessLogic();
        Boolean isExist=false;
        String email=request.getParameter("Email");
        String password=request.getParameter("password");
        User user = UB.getUesrByEmail(email);
        if( user!=null && user.getUserPassword().equals(password)){
                 isExist=true;            
        }
        return isExist;
    }

}
package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
import model.User;

public class LoginServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
            checkUser(request, response);
        } 
        catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    
    
    private void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        UserBusinessLogic UB=new UserBusinessLogic();
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        User user = UB.getUesrByEmail(email);
    
        //Check user exists
        if (user == null){
            request.setAttribute("msg", "User not found");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        // Check password
        if (!user.getUserPassword().equals(password)){
            request.setAttribute("msg", "Password is incorrect");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
                
        request.getSession().setAttribute("userId", user.getUserID());
        request.getSession().setAttribute("role", user.getUserType());
        request.getSession().setAttribute("name", user.getUserName());
        request.getSession().setAttribute("city", user.getUserCity());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(request, response);
          
    }

}

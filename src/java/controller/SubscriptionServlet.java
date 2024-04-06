/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import businesslayer.ProductTypesBusinessLogic;
import businesslayer.UserSubscriptionBusinessLogic;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductTypes;
import model.UserSubscription;

/**
 *
 * @author ydx22
 */
public class SubscriptionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userID = 7;
        UserSubscriptionBusinessLogic subscriptionLogic = new UserSubscriptionBusinessLogic();
        ArrayList<UserSubscription> subscription = null;
        
        try {
            // Assuming recipientID 6 is hardcoded, you may need to retrieve it from request parameters
            subscription =  subscriptionLogic.getUserSubscription(userID);
        } catch (SQLException ex) {
        }
        request.setAttribute("userID", String.valueOf(userID));
        request.setAttribute("subscription", subscription);
        ProductTypesBusinessLogic productTypeLogic = new ProductTypesBusinessLogic();
        ArrayList<ProductTypes>  productTypes = null;
        try {
            // Assuming recipientID 6 is hardcoded, you may need to retrieve it from request parameters
            productTypes = productTypeLogic.getAllProductTypes();
        } catch (SQLException ex) {
        }
        request.setAttribute("productTypes", productTypes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Subscription.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

}

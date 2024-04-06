/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import businesslayer.SubscriptionMsgBusinessLogic;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SubscriptionMsg;

/**
 *
 * @author ydx22
 */
public class SubscriptionMsgsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SubscriptionMsgBusinessLogic subscriptionMsgLogic = new SubscriptionMsgBusinessLogic();
        ArrayList<SubscriptionMsg> messages = null;

        try {
            // Assuming recipientID 6 is hardcoded, you may need to retrieve it from request parameters
            messages = (ArrayList<SubscriptionMsg>) subscriptionMsgLogic.getAllSubscriptionMsgs(6);
        } catch (SQLException ex) {
            // Print the stack trace for debugging purposes
            // Log the exception properly, consider using a logging framework like Log4j
            // log(ex.getMessage());
            
        }

        request.setAttribute("messages", messages);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/SubscriptionMsg.jsp");
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

    @Override
    public String getServletInfo() {
        return "Subscription Messages Servlet";
    }
}
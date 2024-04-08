<%-- 
    Document   : Subscriptionjsp
    Created on : Apr 6, 2024, 9:53:05 a.m.
    Author     : ydx22
--%>

<%@page import="model.ProductTypes"%>
<%@page import="model.UserSubscription"%>
<%@page import="java.util.ArrayList" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%ArrayList<UserSubscription> subscription = (ArrayList<UserSubscription>) request.getAttribute("subscription");%>
<%ArrayList<ProductTypes> productTypes = (ArrayList<ProductTypes>) request.getAttribute("productTypes");%>
<%String userID = (String) request.getAttribute("userID");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Donation food </title>
    </head>
    <body>
        <div>
            <h2>My Subscription</h2>

            <table border="1">
                <thead>
                    <tr>
                        <th>Subscription ID</th>
                        <th>Product Type</th>
                        <th>Location</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                   
                    <%for (UserSubscription s : subscription) {%>
                    <tr>
                        <td><%= s.getSubscriptionID() %></td>
                        <td><%= s.getProductType() %></td>
                        <td><%= s.getUserCity() %></td>
                        <td><button onclick="submitForm('<%= s.getSubscriptionID() %>')">Delete</button></td>

                    </tr>
                    <% }%> 
                </tbody>
            </table>
        </div>
        <div> 
            <head>
        <title>Donation food </title>
    </head>
    <body>
        <div>
            <h2>Subscription</h2>

            <table border="1">
                <thead>
                    <tr>
                        <th>Product Type</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>

                    <%for (ProductTypes t : productTypes) {%>
                    <tr>
                        <td><%= t.getType() %></td>
                        <td><button onclick="submitFormType('<%= t.getType() %>')">Add</button></td>

                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>    
        <!-- Hidden form  for pass data to Servlet -->
    <form id="redirectForm" action="<%= request.getContextPath() %>/SubscriptionDeleteServlet" method="post">
        <input type="hidden" name="id" id="idInput">
    </form>
    <form id="redirectForm1" action="<%= request.getContextPath() %>/SubscriptionAddServlet" method="post">
        <input type="hidden" name="productType" id="productType">
        <input type="hidden" name="userID" id="idUser">
        <input type="hidden" name="subscription" id="sub">
    </form>
    <script>
        function submitForm(id) {
              
            alert("You delted Subscription ID is "+id+"!");
            //set form data
            document.getElementById("idInput").value = id;
            //submit form
            document.getElementById("redirectForm").submit();
            
        }
        function submitFormType(type) {
            
            alert("You Add Subscription Type is " + type + "!");
            // set form data
            document.getElementById("productType").value = type; 
            document.getElementById("idUser").value = <%= userID %>;
            // submit form
            document.getElementById("redirectForm1").submit();  
        }       
        </script> 
       
     
    </body>
</html>
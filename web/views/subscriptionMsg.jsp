<%-- 
    Document   : SubscriptionMsg
    Created on : Apr 5, 2024, 8:44:12 p.m.
    Author     : ydx22
--%>

<%@page import="model.SubscriptionMsg"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.DonationView" %>
<%@page import="businesslayer.ProductsBusinessLogic" %>
<%ArrayList<SubscriptionMsg> messages = (ArrayList<SubscriptionMsg>) request.getAttribute("messages");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Inventory Manager" />
    </jsp:include>
    <head>
        <title>Donation food </title>
    </head>
    
    <body>
    <jsp:include page="topbar.jsp"/>
        
    <jsp:include page="sidebar.jsp" />       
        
<div class="container clearfix">
    
    <!--/sidebar-->
    <div class="main-wrap">
        <h2>Subscription Messages</h2>
        <table class="search-tab" border="1">
            <thead>
                <tr>
                    <th>Message ID</th>
                    <th>Sender Name</th>
                    <th>Recipient ID</th>
                    <th>Content</th>
                    <th>Date Sent</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                
                <%for (SubscriptionMsg message : messages) {%>
                <tr>
                    <td><%= message.getId()%></td>
                    <td><%= message.getSenderName() %></td>
                    <td><%= message.getRecipientID() %></td>
                    <td><%= message.getContent() %></td>
                    <td><%= message.getDateSent() %></td>
                    <td><button onclick="submitForm('<%= message.getId() %>')">Delete</button></td>
                    
                </tr>
                <% }%>
            </tbody>
        </table></div></div>

        <!-- Hidden form  for pass data to Servlet -->
    <form id="redirectForm" action="<%= request.getContextPath() %>/SubscriptionMsgsDeleteServlet" method="post">
        <input type="hidden" name="id" id="idInput">
    </form>

    <script>
        function submitForm(id) {
              
                alert("You delted message ID is "+id+"!");
                //set form data
                document.getElementById("idInput").value = id;            
                //submit form
                document.getElementById("redirectForm").submit();
            
        }
    </script>   
     
    </body>
</html>
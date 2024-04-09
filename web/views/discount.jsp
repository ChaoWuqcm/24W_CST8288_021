
<%-- 
    Document   : discount
    Created on : Apr 5, 2024
    Author     : Chao Wu
--%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.DiscountView" %>
<%@page import="businesslayer.ProductsBusinessLogic" %>
<% ProductsBusinessLogic d = new ProductsBusinessLogic();
ArrayList<DiscountView> discounts = (ArrayList<DiscountView>) request.getAttribute("discounts");

%>
<% String username = (String) session.getAttribute("username");
            
        %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Discount food </title>
    </head>
    <body>
        <h2>Discount food List</h2>
        <p><%= username%></p>
        <a href="LogoutServlet">Logout</a>
        
        <div><a href="index.jsp">Back</a></div>
        <div><a href="SubscriptionServlet">Subscription</a></div>
    
        <table border="1">
            <thead>
                <tr>
                    <th>Company ID</th>
                    <th>Discount Company</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Discount Amount</th>
                    <th>Discount Price</th>
                    <th>Accept Amount</th>
                    <th>Action</th>
                    
                </tr>
            </thead>
            <tbody>
                
                <%for (DiscountView discount : discounts) {%>
                <tr>
                    <td><%= discount.getUserID()%></td>
                    <td><%= discount.getDicountCompany() %></td>
                    <td><%= discount.getProductID()%></td>
                    <td><%= discount.getProductName() %></td>
                    <td><%= discount.getDiscountAmount() %></td>
                    <td><%= discount.getDiscountPrice() %></td>

                    <td><input type="number" id="quantity_<%= discount.getProductID() %>" min="0"  step="0.001"></td>
                    <td><button onclick="submitForm('<%= discount.getProductID() %>', '<%= discount.getDiscountAmount() %>')">Buy</button></td>
                </tr>
                <% }%>
            </tbody>
        </table>

        <!-- Hidden form  for pass data to Servlet -->
    <form id="redirectForm" action="<%= request.getContextPath() %>/DiscountViewUpdate" method="post">
        <input type="hidden" name="id" id="idInput">
        <input type="hidden" name="amount" id="amountinput">
    </form>

    <script>
        function submitForm(id, amount) {
             //alert(id + amount);         
            var quantity = parseFloat(amount)-parseFloat(document.getElementById("quantity_"+id).value);
            if  (quantity >= 0){
                alert("You accept:"+parseFloat(document.getElementById("quantity_"+id).value) + " item.");
                //set form data
                document.getElementById("idInput").value = id;
                document.getElementById("amountinput").value = quantity;
                
                //submit form
                document.getElementById("redirectForm").submit();
            }
            else{
                alert("The accept amount can not exceed the donation amount or be less than 0.");
                return;
            }
        }
    </script>   
     
    </body>
</html>
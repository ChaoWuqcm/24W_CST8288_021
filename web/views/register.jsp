<%-- 
    Document   : register
    Created on : Apr 5, 2024, 4:48:53?p.m.
    Author     : 46297
--%>

<%@page import="businesslayer.UserBusinessLogic"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register Page</title>
    </head>
    <body>
        <div class="platform_login_wrap">
        <h1>Sign up</h1>
         <div class="platform_login_border">
             <div class="platform_input">
                <form action="../RegisterServlet" method="post">
                    <div>
                        <label for="username">Name</label>
                        <input type="text" name="username" placeholder="Please enter username" id="username" size="40"
                               class="platform_input_style"/>
                    </div>
                    <div>
                        <label for="email">Email</label>
                        <input type="text" name="email" placeholder="Please enter email" id="email" size="40"
                               class="platform_input_style"/>
                    </div>
                    <div>
                        <label for="phonenumber">Phone Number</label>
                        <input type="text" name="phonenumber" placeholder="Please enter phone number" id="phonenumber" size="40"
                               class="platform_input_style"/>
                    </div>                
                    <div>
                        <label for="password">Password</label>
                        <input type="password" name="password" placeholder="Please enter password" id="password"
                               size="40" class="platform_input_style"/>
                    </div>
                    <div>
                        <label for="usercity">Location(City)</label>
                        <input type="text" name="usercity" placeholder="Please enter your location" id="usercity" size="40"
                               class="platform_input_style"/>
                    </div>
                    <div>
                        <label for="role">Role</label>
                        <select name="role" id="role" class="select-control info-select">
                            <option value="" selected> - </option>
                            <option value="Retailers">Retailers</option>
                            <option value="Charitable Organizations">Charitable Organizations</option>
                            <option value="Consumers">Consumers</option>
                        </select>
                     </div>
                    <div>
                        <input type="submit" style="margin-top: 15px" value="Register" class="btn btn-primary" id="registerBtn"/>
                    </div>
                    <div>
                        <input type="reset" style="margin-top: 15px"  value="Clear" class="btn btn-primary" id="resetBtn"/>
                    </div>
                 </form>
            </div>
         </div>
       </div>
<!--       <script>
           function submitForm(){
             var userExists= <%= request.getAttribute("userExist")%> ;         
              if(userExists){
                alert("The user email has already existed. Please enter new one.");
                return;
           }
       </script>   -->
    </body>
</html>

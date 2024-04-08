<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Food Waste Reduction Platform</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/platform_login.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
    <div class="platform_login_wrap">
        <h1>Food waste Reduction Platform</h1>
        <div class="platform_login_border",>
            <div class="platform_input">
                <form action="LoginServlet" method="post">
                    <div>
                        <label for="email">Email</label>
                        <input type="text" name="email" placeholder="Please enter email" id="email" size="40" class="platform_input_style" />
                    </div>
                  
                    <div>
                        <label for="password">Password</label>
                        <input type="password" name="password" placeholder="Please enter password" id="password" size="40" class="platform_input_style" />
                    </div>
                
                    <div>
                        <input type="submit" style="margin-top: 15px"  value="Login" class="btn btn-primary" id="loginBtn"/>
                    </div>
                    <div>
                        <input type="button" style="margin-top: 15px"  value="Sign up" class="btn btn-primary" id="registerBtn"/>
                    </div>
                     <div>
                        <input type="reset" style="margin-top: 15px"  value="Clear" class="btn btn-primary" id="resetBtn"/>
                    </div>
                </form>
            </div>
        </div>
     </div>
    <script>
        document.querySelector('#registerBtn').addEventListener('click', function() {
        window.location.href="views/register.jsp";});
         var msg ='${msg}';
         console.log(msg);
         if(msg !==''){
             alert(msg);
         }
         
    </script>   
    </body>
</html>

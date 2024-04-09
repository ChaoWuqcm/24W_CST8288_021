<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title> Food waste Reduction Platform </title>
    <link href="${pageContext.request.contextPath}/css/platform_login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="platform_login_wrap">
    
    <h1>Food waste Reduction Platform</h1>
   
    <div class="platform_login_border">
        <div class="platform_input">
            <form action="../LoginServlet" method="post">
                <input type="hidden" size="85" name="method" class="common-text" value="login">
                <ul class="platform_items">
                    <li>
                        <label for="email">Email：</label>
                        <input type="text" name="email" placeholder="Please input email" id="email" size="40" class="platform_input_style" />
                    </li>
                    <li>
                        <label for="password">Password：</label>
                        <input type="password" name="password" placeholder="Please input password" id="password" size="40" class="platform_input_style" />
                    </li>
                    <li>
                        <input type="submit" style="margin-top: 15px" tabindex="3" value="Sign in" class="btn btn-primary" id="loginBtn"/>
                    </li>
                    <li>
                        <input type="button" style="margin-top: 15px" tabindex="3" value="Sign up" class="btn btn-primary" id="registerBtn"/>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
<script>
    // get the form and input
    const form = document.querySelector('form');
    const email = document.querySelector('#email');
    const password = document.querySelector('#password');

    // add event listener，check if the input is empty
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // prevent default behavior

        if (email.value === '') {
            alert('Email cannot be empty！');
        }else if(password.value === '') {
            alert('Password cannot be empty！');
        }else {
            form.submit(); // submit
        }
    });

    // add event listener，load register page
    document.querySelector('#registerBtn').addEventListener('click', function() {
        window.location.href='${pageContext.request.contextPath}/register';
    });

    var msg = '${msg}';
    console.log(msg);
    if (msg !== '') {
        alert(msg);
    }
</script>
</body>
</html>
<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title> Food waste Reduction Platform </title>
    <link href="${pageContext.request.contextPath}/static/css/platform_login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="platform_login_wrap">
    <h1>Sign up</h1>
    <div class="platform_login_border">
        <div class="platform_input">
            <form action="${pageContext.request.contextPath}/register" method="post">
                <input type="hidden" size="85" name="method" class="common-text" value="register">
                <ul class="platform_items">
                    <li>
                        <label for="email">Email:</label>
                        <input type="text" name="email" placeholder="Please input email" id="email" size="40"
                               class="platform_input_style"/>
                    </li>
                    <li>
                        <label for="password">Password:</label>
                        <input type="password" name="password" placeholder="Please input password" id="password"
                               size="40" class="platform_input_style"/>
                    </li>
                    <li>
                        <label for="username">Name:</label>
                        <input type="text" name="username" placeholder="Please input username" id="username" size="40"
                               class="platform_input_style"/>
                    </li>
                    <li>
                        <label for="role">Role:</label>
                        <select name="role" id="role" class="select-control info-select">
                            <option value="" selected> - </option>
                            <option value="Retailers">Retailers</option>
                            <option value="Charitable Organizations">Charitable Organizations</option>
                            <option value="Consumers">Consumers</option>
                        </select>
                    </li>
                    <li>
                        <input type="submit" style="margin-top: 15px" tabindex="3" value="Register"
                               class="btn btn-primary" id="registerBtn"/>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
<script>
    // Get form and input
    var form = document.querySelector('form');
    var role = document.querySelector('#role');
    var email = document.querySelector('#email');
    var password = document.querySelector('#password');
    var username = document.querySelector('#username');

    // Add event listener
    form.addEventListener('submit', function (event) {
        event.preventDefault(); //
        if (email.value === '') {
            alert('Email cannot be empty！');
        } else if (password.value === '') {
            alert('Password cannot be empty！');
        } else if (username.value === '') {
            alert('Name cannot be empty！');
        } else if (role.value === '') {
            alert('Role cannot be empty！');
        } else {
            form.submit();
        }
    });

    var msg = '<%=request.getAttribute("msg")%>'
    if (msg !== 'null') {
        alert(msg);
    }
</script>
</body>
</html>
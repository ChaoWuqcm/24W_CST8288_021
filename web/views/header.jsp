<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //String pageTitle = request.getParameter("pageTitle");
%>
<% String username = (String) session.getAttribute("username");
            
        %>

<head>
    <meta charset="UTF-8">
    <title><%= username%></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/css/modernizr.min.js"></script>
</head>

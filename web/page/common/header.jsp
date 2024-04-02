<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String pageTitle = request.getParameter("pageTitle");
%>

<head>
    <meta charset="UTF-8">
    <title><%= pageTitle %></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/libs/modernizr.min.js"></script>
</head>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none">
                <a href="${pageContext.request.contextPath}/home" class="navbar-brand">Food waste Reduction Platform</a>
            </h1>
            <ul class="navbar-list clearfix">
                <li>
                    <a class="on" href="${pageContext.request.contextPath}/home">Home</a>
                </li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li>
                    ${sessionScope.name}
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/login?method=logout">Exit</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html>
<jsp:include page="${pageContext.request.contextPath}/page/common/header.jsp">
    <jsp:param name="pageTitle" value="Inventory Manager" />
</jsp:include>
<body>
<jsp:include page="${pageContext.request.contextPath}/page/common/topbar.jsp" />
<div class="container clearfix">
    <jsp:include page="${pageContext.request.contextPath}/page/common/sidebar.jsp" />
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list">
                <i class="icon-font"></i>
                <a href="${pageContext.request.contextPath}/home">Home</a>
                <span class="crumb-step">&gt;</span>
                <span class="crumb-name">Subscription List</span>
            </div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${pageContext.request.contextPath}/subscription" method="post">
                    <input type="hidden" name="method" value="list">
                    <table class="search-tab">
                        <tr>
                            <th width="70">Name:</th>
                            <td>
                                <input class="common-text" placeholder="Commodity Name" name="name" id="name" type="text">
                            </td>
                            <td>
                                <button class="btn btn-primary btn2"  name="inquire" id="inquire" value="Query" type="submit">Query</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>ItemName</th>
                            <th>FoodCategory</th>
                            <th>Email</th>
                            <th>CreatedAt</th>
                            <th>Operation</th>
                        </tr>
                        <c:forEach items="${subscriptionRecords}" var="purchase">
                            <tr>
                                <td>${purchase.getItemName()}</td>
                                <td>${purchase.getFoodCategory()}</td>
                                <td>${purchase.getEmail()}</td>
                                <td><fmt:formatDate value="${purchase.getCreatedAtWeb()}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td>
                                    <a class="link-del" href="${pageContext.request.contextPath}/subscription?method=cancel&id=${purchase.getId()}" onclick="return confirm('Confirming cancel?')">Cancel</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </form>
        </div>
    </div>
    <script>
        var msg = '${msg}';
        console.log(msg);
        if (msg !== '') {
            alert(msg);
        }
    </script>
</body>
</html>
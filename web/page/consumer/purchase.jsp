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
                <span class="crumb-name">Purchase Management</span>
            </div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${pageContext.request.contextPath}/purchase" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="100">Food Name:</th>
                            <td>
                                <input class="common-text" placeholder="Food Name" name="name" id="name" type="text">
                            </td>
                            <td>
                                <button class="btn btn-primary btn2"  name="inquire" id="inquire" value="Query" type="submit">Query</button>
                            </td>
                            <td>
                                <button class="btn btn-primary btn2" type="button" onclick="window.location='${pageContext.request.contextPath}/purchase?method=list'">Manager</button>
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
                            <th>Name</th>
                            <th>ExpirationDate</th>
                            <th>Quantity</th>
                            <th>Type</th>
                            <th>Discount</th>
                            <th>CreatedAt</th>
                            <th>Operation</th>
                        </tr>
                        <c:forEach items="${expiredFoods}" var="expiredFood">
                            <tr>
                                <td>${expiredFood.getName()}</td>
                                <td><fmt:formatDate value="${expiredFood.getExpirationDateWeb()}" pattern="yyyy-MM-dd"/></td>
                                <td>${expiredFood.getQuantity()}</td>
                                <td>${expiredFood.getType()}</td>
                                <td>${expiredFood.getDiscount()}</td>
                                <td><fmt:formatDate value="${expiredFood.getCreatedAtWeb()}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <c:if test="${expiredFood.getRecipientUserId() == null}">
                                    <td>
                                        <a class="link-update" href="javascript:;" onclick="doBuy(${expiredFood.getId()}, ${expiredFood.getQuantity()})">Buy</a>
                                    </td>
                                </c:if>

                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </form>
        </div>
    </div>
    <script>
        function doBuy(id, inventoryQuantity){
            let buyQuantity = prompt("Please enter the quantity to purchase.");
            if (buyQuantity !== null) {
                buyQuantity = parseFloat(buyQuantity);
                if (isNaN(buyQuantity) || buyQuantity <= 0 || buyQuantity > inventoryQuantity) {
                    alert("Please enter a valid quantity!");
                    return;
                }
                window.location = "${pageContext.request.contextPath}/purchase?method=purchase&id=" + id + "&quantity=" + buyQuantity;
            }
        }
    </script>
    <script>
        const msg = '${msg}';
        console.log(msg);
        if (msg !== '') {
            alert(msg);
        }
    </script>
</body>
</html>
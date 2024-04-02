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
                <span class="crumb-name">Surplus Management</span>
            </div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${pageContext.request.contextPath}/surplus" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="100">Food Name:</th>
                            <td>
                                <input class="common-text" placeholder="Food Name" name="name" id="name" type="text">
                            </td>
                            <th width="60">Type:</th>
                            <td>
                                <select name="type" id="type" class="select-control info-select">
                                    <option value="" selected> - </option>
                                    <option value="pending">Pending</option>
                                    <option value="discount">Discount</option>
                                    <option value="donate">Donate</option>
                                </select>
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
                            <th>Name</th>
                            <th>ExpirationDate</th>
                            <th>Quantity</th>
                            <th>Type</th>
                            <th>Discount</th>
                            <th>Recipient</th>
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
                                <td>${expiredFood.getRecipient()}</td>
                                <td><fmt:formatDate value="${expiredFood.getCreatedAtWeb()}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td>
                                    <a class="link-update" href="javascript:;" onclick="doDiscount(${expiredFood.getId()})">Discount</a>
                                    |
                                    <a class="link-update" href="${pageContext.request.contextPath}/surplus?method=donate&id=${expiredFood.getId()}" onclick="return confirm('Confirming the donation?')">Donate</a>
                                    |
                                    <a class="link-del" href="${pageContext.request.contextPath}/surplus?method=del&id=${expiredFood.getId()}" onclick="return confirm('Confirming deletion?')">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </form>
        </div>
    </div>
    <script>
        function doDiscount(id){
            let discount = prompt("Please enter the quantity of the sale:");
            if (discount !== null) {
                discount = parseFloat(discount);
                if (isNaN(discount) || discount <= 0 || discount >= 1) {
                    alert("Please enter a valid quantity!");
                    return;
                }
                window.location = "${pageContext.request.contextPath}/surplus?method=discount&id=" + id + "&discount=" + discount;
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
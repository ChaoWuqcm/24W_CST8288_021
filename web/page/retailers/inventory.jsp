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
                <span class="crumb-name">Inventory Management</span>
            </div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${pageContext.request.contextPath}/inventory" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="130">Inventory Query:</th>
                            <td>
                                <input class="common-text" placeholder="Inventory Name" name="name" id="name" type="text">
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
                <div class="result-title">
                    <div class="result-list">
                        <a href="${pageContext.request.contextPath}/inventory?method=addIndex">
                            <i class="icon-font"></i>Add Inventory
                        </a>
                        <a id="updateOrd" href="javascript:void(0)">
                            <i class="icon-font"></i>Update Sort
                        </a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>Name</th>
                            <th>ExpirationDate</th>
                            <th>Category</th>
                            <th>Tag</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>CreatedAt</th>
                            <th>Operation</th>
                        </tr>
                        <c:forEach items="${inventories}" var="inventory">
                            <tr>
                                <td>${inventory.getName()}</td>
                                <td><fmt:formatDate value="${inventory.getExpirationDateWeb()}" pattern="yyyy-MM-dd"/></td>
                                <td>${inventory.getCategory()}</td>
                                <td>${inventory.getTag()}</td>
                                <td>${inventory.getPrice()}</td>
                                <td>${inventory.getQuantity()}</td>
                                <td><fmt:formatDate value="${inventory.getCreatedAtWeb()}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td>
                                    <a class="link-update" href="${pageContext.request.contextPath}/inventory?method=editIndex&id=${inventory.getId()}">Modify</a>
                                    |
                                    <a class="link-del" href="${pageContext.request.contextPath}/inventory?method=mark&id=${inventory.getId()}" onclick="return confirm('Confirming the expiration?')">Mark</a>
                                    |
                                    <a class="link-del" href="${pageContext.request.contextPath}/inventory?method=del&id=${inventory.getId()}" onclick="return confirm('Confirming deletion?')">Delete</a>
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
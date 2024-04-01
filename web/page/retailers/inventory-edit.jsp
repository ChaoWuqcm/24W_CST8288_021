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
                                <input class="common-text" placeholder="Inventory Number" name="key" id="key" type="text">
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
            <form action="${pageContext.request.contextPath}/inventory" method="post">
                <input type="hidden" name="method" value="edit">
                <input type="hidden" name="id" class="common-text" value="${inventory.getId()}">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe014;</i>Fill in inventory information</h1>
                    </div>
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tr>
                                <th> <i class="require-red">*</i>Name: </th>
                                <td>
                                    <input type="text" id="name" size="85" name="name" class="common-text" value="${inventory.getName()}">
                                </td>
                            </tr>
                            <tr>
                                <th> <i class="require-red">*</i>Category: </th>
                                <td>
                                    <input type="text" id="category" size="85" name="category" class="common-text" value="${inventory.getCategory()}">
                                </td>
                            </tr>
                            <tr>
                                <th width="15%"> <i class="require-red">*</i>Expiration Date: </th>
                                <td>
                                    <fmt:formatDate value="${inventory.getExpirationDateWeb()}" pattern="yyyy-MM-dd" var="expirationDate"/>
                                    <input type="text" id="expirationDate" size="85" name="expirationDate" class="common-text" value="${expirationDate}">
                                </td>
                            </tr>
                            <tr>
                                <th width="15%"> <i class="require-red">*</i>Tag: </th>
                                <td>
                                    <input type="text" id="tag" size="85" name="tag" class="common-text" value="${inventory.getTag()}">
                                </td>
                            </tr>
                            <tr>
                                <th> <i class="require-red">*</i>Price: </th>
                                <td>
                                    <input type="text" id="price" size="85" name="price" class="common-text" value="${inventory.getPrice()}">
                                </td>
                            </tr>
                            <tr>
                                <th> <i class="require-red">*</i>Quantity: </th>
                                <td>
                                    <input type="text" id="quantity" size="85" name="quantity" class="common-text" value="${inventory.getQuantity()}">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input type="hidden" value="siteConf.inc.php" name="file">
                                    <button type="submit" class="btn btn-primary btn6 mr10">Submit</button>
                                    <button type="reset" class="btn btn-primary btn6 mr10">Reset</button>
                                </td>
                            </tr>
                        </table>
                    </div>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html>
<jsp:include page="${pageContext.request.contextPath}/page/common/header.jsp">
    <jsp:param name="pageTitle" value="User Info"/>
</jsp:include>
<body>
<jsp:include page="${pageContext.request.contextPath}/page/common/topbar.jsp"/>
<div class="container clearfix">
    <jsp:include page="${pageContext.request.contextPath}/page/common/sidebar.jsp"/>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list">
                <i class="icon-font"></i>
                <a href="${pageContext.request.contextPath}/home">Home</a>
                <span class="crumb-step">&gt;</span>
                <span class="crumb-name">UserInfo Manager</span>
            </div>
        </div>
        <div class="result-wrap">
            <form action="${pageContext.request.contextPath}/user" method="post" id="myform" name="myform">
                <input type="hidden" name="method" value="rePasswordIndex">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe00a;</i>Modify User Info</h1>
                    </div>
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tbody>
                            <tr>
                                <th width="15%"><i class="require-red">*</i>Email:</th>
                                <td>${user.getEmail()}</td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>Name:</th>
                                <td>${user.getUsername()}</td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>Role: </th>
                                <td>${user.getRole()}</td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input type="hidden" value="siteConf.inc.php" name="file">
                                    <button type="submit" class="btn btn-primary btn6 mr10" style="width: 150px;">Reset Password</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
    <script>
        var msg = '${msg}';
        console.log(msg);
        if (msg !== '') {
            alert(msg);
        }
    </script>
</div>
</body>
</html>
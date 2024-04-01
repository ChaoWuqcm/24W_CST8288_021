<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html>
<jsp:include page="${pageContext.request.contextPath}/page/common/header.jsp">
    <jsp:param name="pageTitle" value="Reset Password"/>
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
                <span class="crumb-name">Password Modification</span>
            </div>
        </div>
        <div class="result-wrap">
            <form action="${pageContext.request.contextPath}/user" method="post">
                <input type="hidden" name="method" value="modifyPassword">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe014;</i>Password Modification</h1>
                    </div>
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tr>
                                <th>
                                    <i class="require-red">*</i>Old Password:
                                </th>
                                <td>
                                    <input type="password" id="oldPassword" size="85" name="oldPassword"
                                           class="common-text">
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <i class="require-red">*</i>New Password:
                                </th>
                                <td>
                                    <input type="password" id="newPassword" size="85" name="newPassword"
                                           class="common-text">
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <i class="require-red">*</i>Re-enter the new password:
                                </th>
                                <td>
                                    <input type="password" id="newPassword_2" size="85" name="newPassword_2"
                                           class="common-text">
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
        <script>
            // Get the form and input elements
            const form = document.querySelector('form');
            const oldPassword = document.querySelector('#oldPassword');
            const newPassword = document.querySelector('#newPassword');
            const newPassword_2 = document.querySelector('#newPassword_2');

            // Add event listener to the form
            form.addEventListener('submit', function (event) {
                event.preventDefault(); // Prevent the form from submitting

                if (oldPassword.value === '') {
                    alert('Old password cannot be empty！');
                } else if (newPassword.value === '') {
                    alert('New password cannot be empty！');
                } else if (newPassword_2.value === '') {
                    alert('Confirm new password！');
                } else if (newPassword_2.value !== newPassword.value) {
                    alert('Confirmation password is not identical！');
                } else {
                    form.submit();
                }
            });
        </script>
        <script>
            var msg = '${msg}';
            console.log(msg);
            if (msg !== '') {
                alert(msg);
            }
        </script>
</body>
</html>
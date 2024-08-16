<%--
  Created by IntelliJ IDEA.
  User: hoccu
  Date: 8/14/2024
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">

</head>
<body>

<div class="register-container">
    <div class="register-form">
        <h2>Đăng ký</h2>
        <form action="signup" method="post">
            <div class="input-group">
                <label for="username">Tên đăng nhập:</label>
                <input type="text" id="username" name="user" required>
            </div>
            <div class="input-group">
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="pass" required>
            </div>
            <div class="input-group">
                <label for="confirm-password">Nhập lại mật khẩu:</label>
                <input type="password" id="confirm-password" name="repass" required>
            </div>
            <button type="submit" class="btn-register">Đăng ký</button>
            <button type="reset" class="btn-reset">Làm mới</button>
        </form>
        <p class="login-link">Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>
    </div>
</div>
</body>
</html>

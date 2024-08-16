
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Nhà thuốc CodeGym</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<style>
    body {
    font-family: Arial, sans-serif;
    background-color: #f0f2f5;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    }

    .login-container {
    width: 100%;
    max-width: 400px;
    padding: 20px;
    background-color: #ffffff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    border-radius: 8px;
    text-align: center;
    }

    .login-form h2 {
    margin-bottom: 20px;
    color: #333333;
    font-size: 24px;
    }

    .input-group {
    margin-bottom: 15px;
    text-align: left;
    }

    .input-group label {
    display: block;
    margin-bottom: 5px;
    color: #333333;
    }

    .input-group input {
    width: 100%;
    padding: 10px;
    border: 1px solid #cccccc;
    border-radius: 4px;
    font-size: 14px;
    }

    .btn-login {
    width: 100%;
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s;
    }

    .btn-login:hover {
    background-color: #45a049;
    }

    .register-link {
    margin-top: 15px;
    font-size: 14px;
    color: #666666;
    }

    .register-link a {
    color: #4CAF50;
    text-decoration: none;
    }

    .register-link a:hover {
    text-decoration: underline;
    }
</style>
</head>
<body>
<div class="login-container">
    <div class="login-form">
        <h2>Đăng nhập</h2>
        <form action="login" method="post">
            <div class="input-group">
                <label for="username">Tên đăng nhập:</label>
                <input type="text" id="username" name="user" required>
            </div>
            <div class="input-group">
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="pass" required>
            </div>
            <button type="submit" class="btn-login">Đăng nhập</button>
        </form>
        <p class="register-link">Chưa có tài khoản? <a href="${pageContext.request.contextPath}/signup">Đăng ký ngay</a></p>
    </div>
</div>
</body>
</html>
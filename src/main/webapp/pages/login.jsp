<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - PinPoint</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div class="container login-container">
        <h1>PinPoint Login</h1>
        <form action="loginServlet" method="post">
            <div class="form-group">
                <label for="username">Email or Username</label>
                <input type="text" id="username" name="username" placeholder="Enter your email or username" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <button type="submit" class="btn btn-purple">Login</button>
        </form>
        <div class="links">
            <a href="${pageContext.request.contextPath}/pages/reset_password.jsp">Forgot Password?</a>
            <a href="${pageContext.request.contextPath}/pages/register.jsp">Sign Up</a>
        </div>
    </div>
</body>
</html>

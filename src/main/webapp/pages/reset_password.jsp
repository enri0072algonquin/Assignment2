<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reset Password - PinPoint</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div class="container reset-container">
        <h1>Reset Your Password</h1>
        <form action="resetPasswordServlet" method="post">
            <div class="form-group">
                <label for="email">Enter your email address</label>
                <input type="email" id="email" name="email" placeholder="Your email address" required>
            </div>
            <button type="submit" class="btn btn-purple">Reset Password</button>
        </form>
        <div class="links">
            <a href="${pageContext.request.contextPath}/pages/login.jsp">Back to Login</a>
        </div>
    </div>
</body>
</html>

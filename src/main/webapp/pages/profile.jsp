<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile - PinPoint</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <header>
        <nav>
            <a href="${pageContext.request.contextPath}/pages/index.jsp" class="logo">PinPoint</a>
            <div class="nav-links">
                <a href="${pageContext.request.contextPath}/pages/profile.jsp">Profile</a>
                <a href="logoutServlet">Logout</a>
            </div>
        </nav>
    </header>
    <main>
        <div class="profile-container">
            <div class="profile-header">
                <img src="${pageContext.request.contextPath}/static/images/default-profile.png" alt="Profile Picture" class="profile-img">
                <h2>User Name</h2>
                <p>User bio or description goes here.</p>
            </div>
            <div class="profile-posts">
                <h3>Your Posts</h3>
                <!-- Sample post listing -->
                <div class="post">
                    <img src="${pageContext.request.contextPath}/static/images/sample-post.jpg" alt="Post Image">
                    <h4>Post Title</h4>
                    <p>Short description...</p>
                    <a href="${pageContext.request.contextPath}/pages/post.jsp?id=1" class="btn btn-purple">View Post</a>
                </div>
                <!-- More posts can be added dynamically -->
            </div>
        </div>
    </main>
    <footer>
        <p>&copy; 2025 PinPoint. All rights reserved.</p>
    </footer>
</body>
</html>

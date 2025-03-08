<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home - PinPoint</title>
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
        <div class="feed-container">
            <h2>Home Feed</h2>
            <!-- Example of a post -->
            <div class="post">
                <img src="${pageContext.request.contextPath}/static/images/sample-post.jpg" alt="Post Image">
                <h3>Post Title</h3>
                <p>This is a sample post description. More details about the post will appear here.</p>
                <a href="${pageContext.request.contextPath}/pages/post.jsp?id=1" class="btn btn-purple">View Post</a>
            </div>
            <!-- Additional posts can be dynamically generated here -->
        </div>
    </main>
    <footer>
        <p>&copy; 2025 PinPoint. All rights reserved.</p>
    </footer>
</body>
</html>

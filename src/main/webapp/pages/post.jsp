<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Post Details - PinPoint</title>
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
        <div class="post-detail-container">
            <h2>Post Title</h2>
            <img src="${pageContext.request.contextPath}/static/images/sample-post.jpg" alt="Post Image" class="enlarged-image">
            <p>This is a detailed description of the post. More information and context can be provided here.</p>
            <section class="comments-section">
                <h3>Comments</h3>
                <div class="comment">
                    <p><strong>User1:</strong> Great post!</p>
                </div>
                <!-- More comments will be displayed here -->
                <form action="commentServlet" method="post">
                    <textarea name="comment" placeholder="Write a comment..." required></textarea>
                    <button type="submit" class="btn btn-purple">Submit Comment</button>
                </form>
            </section>
        </div>
    </main>
    <footer>
        <p>&copy; 2025 PinPoint. All rights reserved.</p>
    </footer>
</body>
</html>

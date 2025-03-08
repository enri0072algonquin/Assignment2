PinPoint Web Application - README
Project Overview
This is the MVP version of the PinPoint web application. It includes a structured web application using JSP, Servlets, and MySQL, with a three-tier architecture:

Presentation Layer → JSP pages in /pages/
Business Logic Layer → Servlets & Java Classes
Data Layer → MySQL Database & DAO classes
Additionally, there is a static HTML prototype inside /static-html-css-ui-test/ to allow team members to preview the UI before backend integration.

1. Folder Structure
/webapp
   ├── /WEB-INF
   │     ├── web.xml (Servlet configuration)
   │     ├── lib/ (External JARs)
   ├── /META-INF (Metadata configurations)
   ├── /static
   │     ├── /css/ (Stylesheets)
   │     ├── /js/ (JavaScript files)
   │     ├── /images/ (Static images)
   ├── /pages
   │     ├── login.jsp
   │     ├── register.jsp
   │     ├── index.jsp
   │     ├── post.jsp
   │     ├── profile.jsp
   │     ├── reset_password.jsp
   ├── /static-html-css-ui-test
   │     ├── login.html
   │     ├── register.html
   │     ├── index.html
   │     ├── post.html
   │     ├── profile.html
   │     ├── styles.css
   │     ├── sample-image.jpg
   │     ├── logo.png
   ├── index.html (Optional landing page)
   ├── README.md (This file)


2. Purpose of static-html-css-ui-test/
This folder contains a static version of the UI (HTML & CSS only).
It allows backend developers to quickly navigate and see the page designs without dealing with JSP or dynamic content.
No dynamic links are used, so all internal page links are hardcoded.
Changes made here do not affect the main application.

#####################################################################
** OPTIONAL READ -- JUMP TO 4 IF YOU'RE COMFORTABLE WITH INTEGRATION **
3. How to Integrate Backend with JSP Pages

Step 1: Setup Tomcat & Database
Deploy the application on Tomcat 9.
Ensure MySQL is running and execute the provided DDL script to create the database.
Update the database connection settings inside the DAO package (JDBC URL, username, password).

Step 2: Serve Static Files in JSP
All CSS, JS, and images are located inside /static/.
When linking static assets in JSP, always use:
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">

Step 3: Link JSP Pages with Servlets
Each JSP page should communicate with Servlets for backend logic.

Example of form submission from login.jsp to LoginServlet.java:
<form action="loginServlet" method="post">
    <input type="text" name="username" required>
    <input type="password" name="password" required>
    <button type="submit">Login</button>
</form>

Inside LoginServlet.java, process the request:
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if(AuthDAO.validate(username, password)) {
        request.getSession().setAttribute("user", username);
        response.sendRedirect("pages/index.jsp");
    } else {
        response.sendRedirect("pages/login.jsp?error=1");
    }
}

Step 4: Secure JSP Pages (Session Management)
Protect restricted pages using session checks in profile.jsp
<% 
    String user = (String) session.getAttribute("user");
    if(user == null) { 
        response.sendRedirect("login.jsp");
    }
%>

Step 5: Retrieve Data from Database into JSP
Use DAO classes to fetch data. Example: Displaying posts dynamically in index.jsp:
<%@ page import="java.util.List, model.Post, dao.PostDAO" %>
<%
    List<Post> posts = PostDAO.getAllPosts();
%>
<c:forEach var="post" items="${posts}">
    <div class="post">
        <h3>${post.title}</h3>
        <img src="${post.imageUrl}" alt="Post Image">
        <p>${post.description}</p>
        <a href="post.jsp?id=${post.id}">View Post</a>
    </div>
</c:forEach>

Step 6: Deploy & Test
Package the project as a WAR file.
Deploy to Tomcat and verify everything works in Chrome & another browser.
Report bugs or issues in the Teams project chat.

###################################################################################

4. Important Notes 
DO NOT modify files inside /static-html-css-ui-test/.
All logic should be added to JSP pages, Servlets, and DAO classes.
Use JSTL (<c:forEach>) instead of Java code inside JSP whenever possible.
Use session management for authentication and restrict access to protected pages.
Ensure database connections are closed properly in DAO methods.
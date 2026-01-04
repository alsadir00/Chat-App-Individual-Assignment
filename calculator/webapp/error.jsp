<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%
    HttpSession session = request.getSession();
    Object errorObj = session.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    <p style="color:red;"><%= errorObj %></p>
    <a href="index.html">Try Again</a>
</body>
</html>

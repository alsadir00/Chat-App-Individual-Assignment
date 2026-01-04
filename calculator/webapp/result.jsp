<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%
    HttpSession session = request.getSession();
    Object resultObj = session.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculation Result</title>
</head>
<body>
    <h1>Result</h1>
    <p>The result is: <strong><%= resultObj %></strong></p>
    <a href="index.html">Go Back</a>
</body>
</html>

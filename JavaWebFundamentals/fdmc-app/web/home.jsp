<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
<h1>Welcome to Fluffy Duffy Munchkin Cats!</h1>
<%=session.getAttribute("username") == null
        ? "<h3>Login if you have account, or Register if you don't have!</h3>"
        : "<h3>Navigate through the application using the links below!</h3>"
%>
<hr/>
<%
    if (session.getAttribute("username") == null) {
%>
<a href="/users/login">Login</a>
<br/>
<a href="/users/register">Register</a>
<%
} else {
%>
<a href="/cats/create">Create Cat</a>
<br/>
<a href="/cats/all">All Cats</a>
<br/>
<a href="/users/logout">Log out</a>
<%
    }
%>
</body>
</html>

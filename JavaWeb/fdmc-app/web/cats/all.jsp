<%@ page import="java.util.List" %>
<%@ page import="ned.fdmc.data.Cat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
<h1>All Cats</h1>
<hr/>
<% List<Cat> cats = (List<Cat>) application.getAttribute("cats");
    if (cats.isEmpty() || cats == null) { %>
<h3>There are no cats.<a href="/cats/create">Create some!</a></h3>
<%
} else {
    for (Cat cat : cats) {
%>
<h3>
    <a href="/cats/profile?catName=<%= cat.getName()%>"><%= cat.getName()%>
    </a>
</h3>
<% }
}%>
<a href="/">Back to Home</a>
</body>
</html>

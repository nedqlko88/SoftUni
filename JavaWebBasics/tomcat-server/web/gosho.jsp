<%--
  Created by IntelliJ IDEA.
  User: nedql
  Date: 06-Jan-19
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Gosho is gsp file in web and he is public</h1>
<%= request.getQueryString() %> </br>
<% for (int i = 0; i < 10; i++) {%>
<%= i%>
<%}%>

</body>
</html>

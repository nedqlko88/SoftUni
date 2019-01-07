<%@ page import="java.util.List" %>
<%@ page import="ned.fdmc.data.Cat" %><%--
  Created by IntelliJ IDEA.
  User: nedql
  Date: 07-Jan-19
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
<%
    List<Cat> cats = (List<Cat>) application.getAttribute("cats");
    String catName = request.getParameter("catName");
    Cat cat = cats.stream().filter(x -> x.getName().equals(catName)).findFirst().orElse(null);
    if (cat != null) {
%>
<h1>Cat - <%=cat.getName()%></h1>
<hr />
<h2>Breed: <%=cat.getBreed()%></h2>
<h2>Color: <%=cat.getColor()%></h2>
<h2>Number of legs: <%=cat.getNumberOfLegs()%></h2>

<%
    } else {
%>
<h1>Cat, with name <%=catName%> was not found.</h1>
<%
    }
%>
<hr />
<a href="/cats/all">Back</a>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: nedql
  Date: 07-Jan-19
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
<h1>Create a Cat!</h1>
<br />
<form action="/cats/create" method="post">
    <div>Name:<label>
        <input type="text" name="name"/>
    </label></div>
    <div>Breed:<label>
        <input type="text" name="breed"/>
    </label></div>
    <div>Color:<label>
        <input type="text" name="color"/>
    </label></div>
    <div>Number of legs:<label>
        <input type="number" name="legs"/>
    </label></div>

    <button type="submit">Create Cat</button>
   </form>
<br/>
<a href="/">Back to Home</a>
</body>
</html>

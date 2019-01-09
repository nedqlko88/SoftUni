<%--
  Created by IntelliJ IDEA.
  User: nedql
  Date: 07-Jan-19
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
<h1>Register!</h1>
<br />
<form action="/users/register" method="post">
    <div>Username:<label>
        <input type="text" name="username"/>
    </label></div>
    <div>Password:<label>
        <input type="password" name="password"/>
    </label></div>
    <div>Confirm Password:<label>
        <input type="password" name="confirmPassword"/>
    </label></div>
    <button type="submit">Register</button>
</form>
<br/>
<a href="/">Back to Home</a>
</body>
</html>

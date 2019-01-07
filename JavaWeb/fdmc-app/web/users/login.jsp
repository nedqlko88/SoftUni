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
<h1>Login!</h1>
<br />
<form action="/users/login" method="post">
    <div>Username:<label>
        <input type="text" name="username"/>
    </label></div>
    <div>Password:<label>
        <input type="password" name="password"/>
    </label></div>
    <button type="submit">Login</button>
</form>
<br/>
<a href="/">Back to Home</a>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 06.06.2019
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorize</title>
    <style>
        body
        {
            min-height: calc(100vh - 50px);
            overflow: hidden;
            max-width: 250px;
            align-items: flex-start;
            margin: 0 auto;
            font-family: Garamond, monospace;
            text-align: center;
            font-size: 20px;
        }
        button {
            background-color: rgba(178, 149, 166, 0.96);
            align-self: center;
            border-radius: 3px;
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            font-size: 20px;
            cursor: pointer;
            width: 200px;
            height: 50px;
            font-family: Garamond, monospace;
            margin: 3%;
            padding: 10px;
        }
        fieldset {
            text-align: center;
            *zoom: 2;
            background: whitesmoke;
            width: 200px;
            font-size: 20px;
            margin: 3%;
            padding: 10px;
        }
        input{
            margin: 3%;
        }
    </style>

</head>
<body>
<fieldset>
    <legend>Authorize</legend>
    <form method="POST" action="login">
        <input name="login" type="text" placeholder="login"/>
        <input name="password" type="password" placeholder="password"/>
        <input type="submit" value="Sign up"/>
    </form>
</fieldset>
<fieldset>
    <form method="POST" action="GoToRegister">
        <input type="submit" value="Sign in"/>
    </form>
</fieldset>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 08.06.2019
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=utf-8"
         isELIgnored="false"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
        <form method="POST" action="index.jsp">
                <input type="submit" value="Exit"/>
            </form>
    </fieldset>
<div>
<p>Hello, <c:out value="${requestScope.login} " default="Hello world" /></p>
    <p>Set to cookies</p>
    <p>Last login:, <c:out value="${requestScope.last} " default="Hello world" /></p>
    <p>Login number: <c:out value="${requestScope.loginNumber} " default="Hello world" /></p>
</div>
<table>
    <tr><th>Name</th><th>Tel</th><th>email</th></tr>
    <tr><td>Anna</td><td>80251234567</td><td>anna@mail.ru</td></tr>
    <tr><td>Max</td><td>80253344635</td><td>Max@mail.ru</td></tr>
    <tr><td>Goga</td><td>80254546563</td><td>Goga@mail.ru</td></tr>
    <tr><td>Pasha</td><td>80297654321</td><td>Pasha@mail.ru</td></tr>
    </table>
</body>
</html>

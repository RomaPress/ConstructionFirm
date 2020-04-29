<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Вход
<form method="post" action="<c:url value='/'/>">
    <input type="text" hidden name="name" value="customer" />
    <input type="submit"  value="Войти как заказчик"/>
</form>

<form method="post" action="<c:url value='/'/>">
    <input type="text" hidden name="name" value="admin" />
    <input type="submit" value="Войти как администратор"/>
</form>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title1</title>
</head>
<body>
<p>Это корзина</p>

<table border="2">

    <caption>
        <h2>
            Добавлено в корзину
        </h2>
    </caption>

    <tr>
<%--        <th>№</th>--%>
        <th>Название услуги</th>
    </tr>
<%--        <% int k = 0;%>--%>
<c:forEach var="i" items="${basket}">
    <tr>
<%--        <th><c:out value="${k+1}"/></th>--%>
        <th><c:out value="${i.name_service}"/></th>
    </tr>


</c:forEach>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="list" class="com.pres.servlet.BasketServlet" scope="page"/>
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
        <th>№</th>
        <th>Название услуги</th>
        <th>удалить</th>
    </tr>
        <% int i = 0;%>
    <c:forEach var="i" items="${ServiceToBasket}">
    <tr>
        <td><%=++i%>
        </td>
        <td><c:out value="${i.name_service}"/></td>
        <td>
            <form method="post" action="<c:url value='/'/>">
                <input type="number" hidden name=" delete" value="${i.service_id}"/>
                <input type="submit" value="Удалить"/>
            </form>
        </td>
    </tr>


    </c:forEach>
</body>
</html>

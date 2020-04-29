<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="classificationk" class="com.pres.database.repositories.get.GetClassification" scope="page"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Услуги</p>

<a>Корзина</a>


<% int i = -1;%>
<c:forEach var="i" items="${serviceTable}">
    <table border="2">

            <caption>
                <h2>
                <%= classificationk.getClassification().get(++i)%>
                </h2>
            </caption>

        <tr>
            <th>№</th>
            <th>Название услуги</th>
            <td>Цена</td>
            <td>за единицу</td>
            <td>добавить в корину</td>
        </tr>
        <c:forEach var="j" items="${i}">
            <tr>
                <td><c:out value="${j.id}"/></td>
                <td><c:out value="${j.name_service}"/></td>
                <td><c:out value="${j.unit_price}"/></td>
                <td><c:out value="${j.unit}"/></td>
                <td>
                    <form method="post" action="<c:url value='/customer'/>">
                        <input type="number" hidden name="id" value="${j.service_id}" />
                        <input type="submit" name="add" value="Заказать"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:forEach>



</body>
</html>

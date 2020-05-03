<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="classification" class="com.pres.database.repositories.get.GetClassification" scope="page"/>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="get" action="<c:url value='/basket'/>">
    <input type="text" hidden name="goToBasket" value="showBasket" />
    <input type="submit" value="Заказать"/>
</form>

<% int i = -1;%>
<c:forEach var="i" items="${serviceTable}">
    <table border="2">

            <caption>
                <h2>
                <%= classification.getClassification().get(++i)%>
                </h2>
            </caption>

        <tr>
            <th>№</th>
            <th>Название услуги</th>
            <td>Цена</td>
            <td>за единицу</td>
            <td>добавить в корину</td>
        </tr>
        <%int k = 1;%>
        <c:forEach var="j" items="${i}">
            <tr>
                <td><%= k++%></td>
                <td><c:out value="${j.name_service}"/></td>
                <td><c:out value="${j.unit_price}"/></td>
                <td><c:out value="${j.unit}"/></td>
                <td>
                    <form method="post" action="<c:url value='/basket'/>">
                        <input type="number" hidden name="id" value="${j.service_id}" />
                        <input type="submit" name="add" value="Add"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:forEach>



</body>
</html>

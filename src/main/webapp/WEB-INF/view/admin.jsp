<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table border="2">

    <caption>
        <h2>
            Заказы
        </h2>
    </caption>

    <tr>
        <th>№ Заказа</th>
        <th>Статус</th>
        <th>Дата</th>
        <th>ФИО</th>
        <th>Номер</th>
        <th>Услуги</th>
        <th>Объем</th>
        <th>Цена</th>
        <th>Кнопки</th>
    </tr>

    <c:forEach var="i" items="${order}">
        <tr>
            <td><c:out value="${i.order_id}"/></td>
            <td><c:out value="${i.status}"/></td>
            <td><c:out value="${i.data}"/></td>
            <td><c:out value="${i.last_name}"/> <c:out value="${i.first_name}"/> <c:out value="${i.patronymic}"/></td>
            <td> +380<c:out value="${i.phone_number}"/></td>
            <td>
                <c:forEach var="j" items="${i.orderedServices}">
                    <table >
                        <td><c:out value="${j.name_service}"/></td>
                    </table>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="j" items="${i.orderedServices}">
                    <table >
                        <td><c:out value="${j.amount}"/>  <c:out value="${j.name_unit}"/></td>
                    </table>
                </c:forEach>
            </td>
            <td><c:out value="${i.price}"/></td>
            <td>
                <form method="post" action="<c:url value='/admin'/>">
                    <input type="number" hidden name="delete" value="${i.order_id}" />
                    <input type="submit" name="delete" value="delete"/>
                </form>

                <form method="get" action="<c:url value='/update'/>">
                    <input type="number" hidden name="order_id" value="${i.order_id}" />
                    <input type="submit" name="update" value="update"/>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
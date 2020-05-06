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
            Update
        </h2>
    </caption>
    <c:forEach var="i" items="${updateOrder}">


        <h3>Заказа №<c:out value="${i.order_id}"/></h3>


        <h3> Статус: <c:out value="${i.status}"/></h3>
        <form method="post" action="<c:url value='/update'/>">
            <label>
                <select name="status" id="status">
                    <c:forEach var="k" items="${status}">
                        <option>
                            <c:out value="${k.name_status}"/>
                        </option>
                    </c:forEach>
                </select>
            </label>
            <input type="submit" name="changeStatus" value="Применить"/>
        </form>

        <h3>Дата: <c:out value="${i.data}"/></h3>
        <h3>ФИО <c:out value="${i.last_name}"/> <c:out value="${i.first_name}"/> <c:out value="${i.patronymic}"/></h3>
        <h3>Номер: +380<c:out value="${i.phone_number}"/></h3>
        Цена <c:out value="${i.price}"/>
        <tr>
            <th>Услуги</th>
            <th>Удалить</th>
            <th>Объем</th>
            <th></th>
            <th>Изменить</th>
        </tr>


        <c:forEach var="j" items="${i.orderedServices}">
            <tr>
                <td>
                    <table>
                        <td><c:out value="${j.name_service}"/></td>
                    </table>
                </td>

                <td>
                    <form method="post" action="<c:url value='/update'/>">
                        <input type="number" hidden name="service_id" value="${j.service_id}"/>
                        <input type="submit" name="delete" value="delete"/>
                    </form>
                </td>

                <td>
                    <table>
                        <td><c:out value="${j.amount}"/> <c:out value="${j.name_unit}"/></td>
                    </table>
                </td>


                <form method="post" action="<c:url value='/update'/>">
                    <td>
                        <label>
                            <input type="number" name="${j.service_id}" value="<c:out value="${j.amount}"/>"/>
                        </label>
                    </td>


                    <td>
                        <input type="number" hidden name="service_id" value="${j.service_id}"/>
                        <input type="submit" name="change" value="Применить"/>
                    </td>
                </form>

            </tr>
        </c:forEach>
    </c:forEach>
</table>


</body>
</html>

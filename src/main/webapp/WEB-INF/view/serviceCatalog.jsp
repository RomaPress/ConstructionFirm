<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="classificationTitle" class="com.pres.database.repositories.get.GetClassification" scope="page"/>
<html>
<head>

</head>
<body>
<form method="get" action="<c:url value='/admin'/>">
    <input type="text" hidden name="name" value="customer" />
    <input type="submit"  value="Выйти"/>
</form>

<form method="post" action="<c:url value='/changeServiceList'/>">

    <label>
        <input type="text" name="name_service" required/>
    </label>

    <label>
        <input type="number" name="unit_price" step = "0.01" required/>
    </label>

    <label>
        <select name="unit" id="unit">
            <c:forEach var="i" items="${unit}">
                <option>
                    <c:out value="${i.name_unit}"/>
                </option>
            </c:forEach>
        </select>
    </label>

    <label>
        <select name="classification" id="classification">
            <c:forEach var="i" items="${classification}">
                <option>
                    <c:out value="${i.name_classification}"/>
                </option>
            </c:forEach>
        </select>
    </label>

    <input type="submit" name="addService" value="Добавить"/>
</form>



<% int i = -1;%>
<c:forEach var="i" items="${serviceTable}">
    <table border="2">

        <caption>
            <h2>
                <%= classificationTitle.getNameClassification().get(++i)%>
            </h2>
        </caption>

        <tr>
            <th>№</th>
            <th>Название услуги</th>
            <th>Удалить</th>
            <td>Цена</td>
            <td></td>
            <td>Изменить</td>
        </tr>

        <c:forEach var="j" items="${i}">
            <tr>
                <td><c:out value="${j.service_id}"/></td>
                <td><c:out value="${j.name_service}"/></td>

                <td>
                    <form method="post" action="<c:url value='/changeServiceList'/>">
                        <input type="number" hidden name="service_id" value="${j.service_id}" />
                        <input type="submit" name="delete" value="Удалить"/>
                    </form>
                </td>

                <td><c:out value="${j.unit_price}"/> <c:out value="${j.name_unit}"/></td>

                <form method="post" action="<c:url value='/changeServiceList'/>">
                    <td>
                        <label>
                            <input type="number" name="${j.service_id}" value="<c:out value="${j.unit_price}"/>" step = "0.01" required//>
                        </label>
                    </td>


                    <td>
                        <input type="number" hidden name="service_id" value="${j.service_id}"/>
                        <input type="submit" name="change" value="Изменить"/>
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>
</c:forEach>
</body>
</html>

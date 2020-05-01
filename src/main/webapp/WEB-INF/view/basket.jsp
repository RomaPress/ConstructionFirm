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
            <form method="get" action="<c:url value='/basket'/>">
                <input type="number" hidden name="delete" value="${i.service_id}"/>
                <input type="submit" value="Удалить"/>
            </form>
        </td>
    </tr>
    </c:forEach>


    <form method="get" action="<c:url value='/basket'/>">
        <label>
            <input type="text" name="first_name" />first_name
        </label>
        <br/>
        <label>
            <input type="text" name="last_name" />last_name
        </label>
        <br/>
        <label>
            <input type="text" name="patronymic"/> patronymic
        </label>
        <br/>
        <label>
            <input type="number" name="phone_number" />phone_number
        </label>
        <br/>

        <input type="submit"  name="Ok" value="Заказать"><br>
    </form>






</body>
</html>

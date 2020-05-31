<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="classification" class="com.pres.database.repositories.get.GetClassification" scope="page"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <style type="text/css">
        <%@include file="../css/style.css"%>
    </style>

</head>
<body>


<div class="container">
    <div class="row">
        <div class="col-2">

            <form class="customer_btn" method="get" action="<c:url value='/basket'/>">
                <button class="button" type="submit" name="add"><span>Заказать </span></button>
            </form>
        </div>
        <div class="col-2">
            <form class="customer_btn" method="get" action="<c:url value='/basket'/>">
                <button class="button" type="submit" name="out"><span>Выйти </span></button>
            </form>
        </div>
        <div class="col-4">
            <a href="https://instagram.com/serg.shevchenko100?igshid=171zkkfckk0x1"><span>Смотреть портфолмо</span></a>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <% int i = -1;%>
            <c:forEach var="i" items="${serviceTable}">
                <table border="1" class="table table1 table-hover">
                    <caption>
                        <h3>
                            <%= classification.getNameClassification().get(++i)%>
                        </h3>
                    </caption>
                    <thead class=" thead-dark">
                    <tr>
                        <th scope="col"><p>№</p></th>
                        <th scope="col"><p>Название услуги</p></th>
                        <th scope="col"><p>Цена</p></th>
                        <th scope="col"><p>За единицу</p></th>
                        <th scope="col"><p>Добавить в корину</p></th>
                    </tr>
                    </thead>
                    <%int k = 1;%>
                    <c:forEach var="j" items="${i}">
                    <tbody>
                    <tr>
                        <td><p><%= k++%>
                        </p></td>
                        <td><p><c:out value="${j.name_service}"/></p></td>
                        <td><p><c:out value="${j.unit_price}"/></p></td>
                        <td><p><c:out value="${j.name_unit}"/></p></td>
                        <td>
                            <form method="post" action="<c:url value='/basket'/>">
                                <input type="number" hidden name="id" value="${j.service_id}"/>
                                <button class="button" type="submit" name="add"><span>Добавить </span></button>
                            </form>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:forEach>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity=sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>

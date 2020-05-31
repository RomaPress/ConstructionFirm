<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="list" class="com.pres.servlet.BasketServlet" scope="page"/>
<%--<!DOCTYPE html>--%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <title>Title1</title>
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

<%--        <div class="col-4 ">--%>
<%--            <div class="main-form">--%>
<%--                                <h4 class="main-form-header">Для оформления заказа <br/>заполните все данные</h4>--%>
<%--                                <form method="get" action="<c:url value='/basket'/>">--%>
<%--                                    <label class="label1">first_name</label>--%>

<%--                                        <input class = "label1" type="text" name="first_name"/>--%>

<%--                                    <br/>--%>
<%--                                    <br/>--%>
<%--                                    <br/>--%>
<%--                                    <label class="label1">last_name</label>--%>

<%--                                        <input class = "label1" type="text" name="last_name"/>--%>

<%--                                    <br/>--%>
<%--                                    <br/>--%>
<%--                                    <label class="label1">patronymic</label>--%>

<%--                                        <input class = "label1" type="text" name="patronymic"/>--%>

<%--                                    <br/>--%>

<%--                                    <label class="label1">phone_number</label>--%>

<%--                                        <input class = "label1" type="number" name="phone_number"/>--%>

<%--                                    <br/>--%>
<%--                                    <input type="submit" name="Ok" value="Заказать"><br>--%>
<%--                                </form>--%>
<%--                            </div>--%>
<%--                        </div>--%>


                <div class="col-6 ">
                    <div class="main-form">
                        <p class="main-form-header">Для оформления заказа <br/>заполните все данные</p>
                        <form  method="get" action="<c:url value='/basket'/>">
                            <label class="label1">Имя</label>
                            <input class="main-font-input" type="text" name="first_name" required pattern = "[А-Яа-яЁё]{2,15}"/>
                            <label class="label1">Фамилия</label>
                            <input class="main-font-input" type="text" name="last_name" required pattern = "[А-Яа-яЁё]{2,15}"/>
                            <label class="label1">Отчество</label>
                            <input class="main-font-input" type="text" name="patronymic" required pattern = "[А-Яа-яЁё]{2,15}"/>
                            <label class="label1">Номер телефона</label>
                            <input class="main-font-input" type="text" name="phone_number" required pattern = "[0-9]{8,10}"/>
                            <input class="button" type="submit" name="Ok" value="Заказать"><br>
                            <small>Нажав на кнопку "Заказать" Вы соглашаетесь на обработку предоставленных Вами персональных данных</small>
                        </form>
                    </div>
                </div>

            <div class="col-6 ">

                <table border="1" class="table table-hover">

                    <caption>
                        <h2>
                            Добавлено в корзину
                        </h2>
                    </caption>
                    <thead class=" thead-dark">
                    <tr>
                        <th>№</th>
                        <th>Название услуги</th>
                        <th>Удалить</th>
                    </tr>
                    </thead>
                        <% int i = 0;%>
                    <c:forEach var="i" items="${ServiceToBasket}">
                    <tr>
                        <td><%=++i%>
                        </td>
                        <td><c:out value="${i.name_service}"/></td>
                        <td>
                            <form method="get" action="<c:url value='/basket'/>">
                                <input type="number" hidden name="delete" value="${i.service_id}"/>
                                <button class="button" type="submit" ><span>Удалить</span></button>
                            </form>
                        </td>
                    </tr>
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

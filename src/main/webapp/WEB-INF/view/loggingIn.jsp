<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div class="col">
            <h1>Добор пожаловать на сайт ремонтно-строительной фирмы</h1>
            <h3>Щелкните на кнопку ниже, чтобы оприделить кто Вы, клиент или администратор</h3>
        </div>
    </div>
</div>
<br>


<div class="container">
    <div class="row">
        <div class="col-6">
            <form method="post" action="<c:url value='/'/>">
                <input type="text" hidden name="name" value="customer"/>
                <input class="long-button success " type="submit" value="Я клиент">
            </form>
            <br>
            <form method="post" action="<c:url value='/'/>">
                <input type="text" hidden name="name" value="admin"/>
                <input class="long-button success " type="submit" value="Я администратор">
            </form>
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

<!doctype html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <title>Selected Person's Page</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
<h3>Update Person Page With Relatives List</h3>

<div>
    <div class="container">
        <div class="row">
            <form:form action="updastePeron" modelAttribute="person" method="post">
                <form:input type="text" name="id" value="${person.getId()}" path="" readonly="true"/><br>
                <form:input type="text" name="name" value="${person.getName()}" autofocus="true" path=""/>
                <form:errors path="name"></form:errors><br>
                <form:input type="text" name="surname" value="${person.getSurname()}" path=""/>
                <form:errors path="surname"></form:errors><br>
                <form:input type="date" name="date" value="${person.getDate()}" path=""/>
                <form:errors path="date"></form:errors><br>
                <form:button type="submit" class="button"> Update</form:button>
            </form:form>
        </div>
        <div class="row">
            <table class="table-bordered">
                <tr>
                    <td>Relationship</td>
                    <td>Name</td>
                    <td>Surname</td>
                    <td>Date</td>
                </tr>
                <c:forEach var="relatives" items="${relativesMap}">
                    <tr>
                    <tr>
                        <td><b>${relatives.getKey()}</b></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <c:forEach items="${relatives.getValue()}" var="relativ">
                        <tr>
                            <td></td>
                            <td>${relativ.getName()}</td>
                            <td>${relativ.getSurname()}</td>
                            <td>${relativ.getDate()}</td>
                        </tr>
                    </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>
</body>
</html>
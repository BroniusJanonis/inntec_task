<!doctype html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Person's Page</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script type="text/javascript" src="${pageContext.request.contextPath}/javaScript/PersonPageScripts.js"></script>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
<h3>Persons List Page</h3>

<div>
    <div class="container">
        <div class="row">
            <input type="text" class="searchInput" onkeyup="searchBy(1)" placeholder="Search by name..."/>
            <input type="text" class="searchInput" onkeyup="searchBy(2)" placeholder="Search by surname..."/>
            <input type="text" class="searchInput" onkeyup="searchBy(3)" placeholder="Search by date..."/>
        </div>
        <div class="row">
            <table id="myTable">
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Surname</td>
                    <td>Birth Date</td>
                    <td>Update and find Relatives</td>
                </tr>
                <c:forEach var="person" items="${personList}">
                    <form action="selectedPerson" method="post">
                        <tr>
                            <td><input type="text" name="id" value="${person.getId()}" hidden/>${person.getId()}</td>
                            <td><input type="text" name="name" value="${person.getName()}" hidden/>${person.getName()}</td>
                            <td><input type="text" name="surname" value="${person.getSurname()}" hidden/>${person.getSurname()}</td>
                            <td><input type="text" name="date" value="${person.getDate()}" hidden/>${person.getDate()}</td>
                            <td>
                                <button type="submit" class="button"> Update</button>
                            </td>
                        </tr>
                    </form>
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
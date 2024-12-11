<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/12/2024
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Book List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .table-bordered-custom th, .table-bordered-custom td {
            border: 1px solid black;
        }

        .table-striped tbody tr:nth-child(odd) {
            background-color: #f2f2f2;
        }

        .table-striped tbody tr:nth-child(even) {
            background-color: #ffffff;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <h2 class="text-center">Book list</h2>
    <table class="table table-bordered-custom table-hover table-striped align-middle">
        <thead>
            <tr class="align-middle">
                <th>Mã sách</th>
                <th>Tên sách</th>
                <th>Tác Giả</th>
                <th>Số lượng</th>
                <th>Mô tả</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.code}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.quantity}</td>
                    <td>${book.description}</td>
                    <td>
                        <form method="get" style="margin: 0">
                            <input type="hidden" name="id" value="${book.code}">
                            <button class="btn btn-primary" name="action" value="loan">Mượn</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>


</div>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</body>
</html>

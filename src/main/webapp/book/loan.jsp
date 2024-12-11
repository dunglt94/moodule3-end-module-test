<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/12/2024
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Loan Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="row d-flex justify-content-center align-items-center">
        <div class="col-lg-6 mx-auto">
            <h2 class="text-center mt-3 mb-3">Mượn sách</h2>
            <form method="post">
                <table class="table table-hover align-middle">
                    <thead></thead>
                    <tbody>
                    <tr>
                        <td><label for="loan_code"></label>Mã mượn sách</td>
                        <td>
                            <input type="text" name="loan_code" id="loan_code" class="form-control"
                                   placeholder="MS-XXXX" required>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="book_name"></label>Tên sách</td>
                        <td>
                            <input type="hidden" name="book_id" id="book_code" value="${book.id}">
                            <input type="text" name="book_name" id="book_name" class="form-control"
                                   value="${book.name}" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td>Tên học sinh</td>

                        <td>
                            <select name="student_name" id="student_name"  class="form-control w-auto" >
                                <c:forEach var="student" items="${students}">
                                    <option value="${student.id}">${student.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="loan_date">Ngày mượn sách:</label>
                        </td>
                        <td>
                            <input type="text" name="loan_date" id="loan_date"
                                   class="form-control" style="width: 110px" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="return_date">Ngày trả sách:</label>
                        </td>
                        <td>
                            <input type="date" name="return_date" id="return_date"
                                   class="form-control w-auto" required>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">
                            <button type="submit" class="btn btn-primary" name="action" value="loan_book">
                                Mượn sách
                            </button>
                        </td>
                        <td class="text-center">
                            <a href="books" class="btn btn-secondary">Huỷ</a>
                        </td>
                    </tr>
                    </tbody>

                </table>
            </form>
        </div>

  </div>
</div>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script>
    let now = new Date();
    let datetime = now.toLocaleString('en-US', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });

    // Set the value of the input field to today's date
    document.getElementById('loan_date').value = datetime;
</script>
</body>
</html>

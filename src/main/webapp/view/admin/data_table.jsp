<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Data Table</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>

<body>
<table  class="table table-dark table-striped">
    <thead>
    <td>ID</td>
    <td>Ma</td>
    <td>Ten</td>
    <td>Ngay bat dau</td>
    <td>Ngay ket thuc</td>
    <td>Nguoi Tao</td>
    <td>Trang Thai</td>
    <td>Action</td>
    </thead>

    <c:forEach var="i" items="${page.content}">
    <tr>
            <td>${i.id}</td>
            <td>${i.ma}</td>
            <td>${i.ten}</td>
            <td>
                <c:set var="beginday" value="${i.beginday}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${i.beginday}" />
            </td>
            <td>
                <c:set var="endday" value="${i.endday}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${i.endday}" />
            </td>
            <td>${i.nguoiTao.idUsers}</td>
            <td>
                <c:if test="${i.trangthai==1}">Con hang</c:if>
                <c:if test="${i.trangthai==2}">Het hang</c:if>
            </td>
            <td>
                <a href="/pgg/edit/${i.id}">
                    <button>Edit</button>
                </a>
                <a href="/pgg/delete/${i.id}">
                    <button>delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
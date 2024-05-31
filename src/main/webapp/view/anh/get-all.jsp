<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Document</title>
</head>

<body>

<h1>Danh sach anh</h1>
<button class="btn btn-primary"><a class="btn btn-primary" href="/anh/view-add">ADD</a></button>
<table class="table table-secondary">
    <tr>
        <th>url</th>
        <th>NgayTao</th>
        <th>NgaySua</th>
        <th>TrangThai</th>
        <th scope="col">Action</th>
    </tr>
    <tbody>
    <c:forEach var="anh" items="${list.content}">
        <tr>
            <td>${anh.url}</td>
            <td>
                <c:set var="ngayTao" value="${anh.ngayTao}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${ngayTao}" />
            </td>
            <td>
                <c:set var="ngaySua" value="${anh.ngaySua}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${ngaySua}" />
            </td>
            <td>${anh.trangThai}</td>
            <td>
                <button class="btn btn-light" ><a class="btn btn-light" href="/anh/delete/${anh.idAnh}">Delete</a></button>
                <button class="btn btn-dark"><a class="btn btn-dark" href="/anh/updateForm/${anh.idAnh}">Detail</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <nav aria-label="Page navigation example" class="container">
        <ul class="pagination">
            <c:forEach begin="0" end="${anh.totalPages +1}" varStatus="loop">
                <li class="page-item"><a class="page-link" href="/anh/hien-thi?page=${loop.index}">${loop.index + 1}</a></li>
            </c:forEach>
        </ul>
    </nav>
</table>
<footer>

</footer>
</body>

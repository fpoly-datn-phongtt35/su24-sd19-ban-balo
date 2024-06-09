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

<h1>Danh sach Hang</h1>
<button class="btn btn-primary"><a class="btn btn-primary" href="/hang/view-add">ADD</a></button>
<table class="table table-secondary">
    <tr>
        <th>MaHang</th>
        <th>TenHang</th>
        <th>NgayTao</th>
        <th>NgaySua</th>
        <th>TrangThai</th>
        <th scope="col">Action</th>
    </tr>
    <tbody>
    <c:forEach var="hang" items="${list.content}">
        <tr>
            <td>${hang.maHang}</td>
            <td>${hang.tenHang}</td>
            <td>
                <c:set var="ngayTao" value="${hang.ngayTao}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${ngayTao}" />
            </td>
            <td>
                <c:set var="ngaySua" value="${hang.ngaySua}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${ngaySua}" />
            </td>
            <td>${hang.trangThai}</td>
            <td>
                <button class="btn btn-light" ><a class="btn btn-light" href="/hang/delete/${hang.idHang}">Delete</a></button>
                <button class="btn btn-dark"><a class="btn btn-dark" href="/hang/updateForm/${hang.idHang}">Detail</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/hang/hien-thi?page=${list.number - 1}">Truoc</a></li>
            <li class="page-item"><a class="page-link" href="#">${list.number}</a></li>
            <li class="page-item"><a class="page-link" href="/hang/hien-thi?page=${list.number + 1}">Sau</a></li>
        </ul>
    </nav>
</table>
<footer>

</footer>
</body>

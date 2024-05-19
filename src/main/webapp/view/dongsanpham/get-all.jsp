<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<h1>Danh sach SANpHAM</h1>
<button class="btn btn-primary"><a class="btn btn-primary" href="/dongsanpham/view-add">ADD</a></button>
<table class="table table-secondary">
    <tr>
        <th>maDongSanPham</th>
        <th>tenDongSanPham</th>
        <th>NgayTao</th>
        <th>NgaySua</th>
        <th>TrangThai</th>
    </tr>
    <tbody>
    <c:forEach var="dongsanpham" items="${list.content}">
        <tr>
            <td>${dongsanpham.maDongSanPham}</td>
            <td>${dongsanpham.tenDongSanPham}</td>
            <td>${dongsanpham.ngayTao}</td>
            <td>${dongsanpham.ngaySua}</td>
            <td>${dongsanpham.trangThai}</td>
<%--            <td>--%>
<%--                <a href="/size/view-add">ADD</a>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>
    </tbody>
    <nav aria-label="Page navigation example" class="container">
        <ul class="pagination">
            <c:forEach begin="0" end="${nv.totalPages +1}" varStatus="loop">
                <li class="page-item"><a class="page-link" href="/dongsanpham/hien-thi?page=${loop.index}">${loop.index + 1}</a></li>
            </c:forEach>
        </ul>
    </nav>
</table>
<footer>

</footer>
</body>

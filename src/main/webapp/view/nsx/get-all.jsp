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

<h1>Danh sach NSX</h1>
<button class="btn btn-primary"><a class="btn btn-primary" href="/nsx/view-add">ADD</a></button>
<table class="table table-secondary">
    <tr>
        <th>MaNSX</th>
        <th>TenNSX</th>
        <th>NgayTao</th>
        <th>NgaySua</th>
        <th>TrangThai</th>
    </tr>
    <tbody>
    <c:forEach var="nsx" items="${list.content}">
        <tr>
            <td>${nsx.maNSX}</td>
            <td>${nsx.tenNSX}</td>
            <td>${nsx.ngayTao}</td>
            <td>${nsx.ngaySua}</td>
            <td>${nsx.trangThai}</td>
<%--            <td>--%>
<%--                <a href="/size/view-add">ADD</a>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>
    </tbody>
    <nav aria-label="Page navigation example" class="container">
        <ul class="pagination">
            <c:forEach begin="0" end="${nv.totalPages +1}" varStatus="loop">
                <li class="page-item"><a class="page-link" href="/nsx/hien-thi?page=${loop.index}">${loop.index + 1}</a></li>
            </c:forEach>
        </ul>
    </nav>
</table>
<footer>

</footer>
</body>

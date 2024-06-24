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

<h1>Danh sach NSX</h1>
<button class="btn btn-primary"><a class="btn btn-primary" href="/nsx/view-add">ADD</a></button>
<table class="table table-secondary">
    <tr>
        <th>MaNSX</th>
        <th>TenNSX</th>
        <th>NgayTao</th>
        <th>NgaySua</th>
        <th>TrangThai</th>
        <th scope="col">Action</th>
    </tr>
    <tbody>
    <c:forEach var="nsx" items="${list.content}">
        <tr>
            <td>${nsx.maNSX}</td>
            <td>
                <c:set var="tenNSX" value="${nsx.tenNSX}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${tenNSX}" />
            </td>
            <td>
                <c:set var="ngayTao" value="${nsx.ngayTao}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${ngayTao}" />
            </td>
            <td>
                <c:set var="ngaySua" value="${nsx.ngaySua}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${ngaySua}" />
            </td>
            <td>${nsx.trangThai}</td>
            <td>
                <button class="btn btn-light" ><a class="btn btn-light" href="/nsx/delete/${nsx.idNSX}">Delete</a></button>
                <button class="btn btn-dark"><a class="btn btn-dark" href="/nsx/updateForm/${nsx.idNSX}">Detail</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/nsx/hien-thi?page=${list.number - 1}">Truoc</a></li>
            <li class="page-item"><a class="page-link" href="#">${list.number}</a></li>
            <li class="page-item"><a class="page-link" href="/nsx/hien-thi?page=${list.number + 1}">Sau</a></li>
        </ul>
    </nav>
</table>
<footer>

</footer>
</body>

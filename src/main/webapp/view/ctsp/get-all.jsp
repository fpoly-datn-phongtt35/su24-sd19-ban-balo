<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

<body class="container mt-3">

<h1>Danh sach ctsp</h1>

<!-- Form tìm kiếm -->
<%--<form action="/ctsp/search" method="get" class="form-inline mb-4">--%>
<%--    <div class="form-group">--%>
<%--        <label for="tenSanPham">Tên Sản phẩm:</label>--%>
<%--        <input type="text" id="tenSanPham" name="tenSanPham" class="form-control" placeholder="Tên Sản phẩm" required>--%>
<%--    </div>--%>
<%--    <button type="submit" class="btn btn-primary ml-2">Tìm kiếm</button>--%>
<%--</form>--%>

<%--<form action="/ctsp/search-price" method="get">--%>
<%--    <div class="mb-3">--%>
<%--        <label for="minGiaBan" class="form-label">MinGiaBan</label>--%>
<%--        <input type="number" step="1.00" class="form-control" id="minGiaBan" name="minGiaBan" required>--%>
<%--    </div>--%>
<%--    <div class="mb-3">--%>
<%--        <label for="maxGiaBan" class="form-label">MaxGiaBan</label>--%>
<%--        <input type="number" step="1.00" class="form-control" id="maxGiaBan" name="maxGiaBan" required>--%>
<%--    </div>--%>
<%--    <button type="submit" class="btn btn-primary">Search</button>--%>
<%--</form>--%>

<form action="/ctsp/search" method="get" class="mb-3">
    <div class="row">
        <div class="col-md-4">
            <input type="text" name="tenSanPham" class="form-control" placeholder="Tên sản phẩm" value="${ctsp.tenSanPham}">
        </div>
        <div class="col-md-3">
            <input type="number" name="minGiaBan" class="form-control" placeholder="Giá bán từ" value="${ctsp.minGiaBan}">
        </div>
        <div class="col-md-3">
            <input type="number" name="maxGiaBan" class="form-control" placeholder="Giá bán đến" value="${ctsp.maxGiaBan}">
        </div>
        <div class="col-md-2">
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
        </div>
    </div>
</form>

<button class="btn btn-primary"><a class="btn btn-primary" href="/ctsp/view-add">ADD</a></button>
<table class="table table-secondary">
    <tr>
        <th>idSanPham</th>
        <th>idMauSac</th>
        <th>anh</th>
        <th>moTa</th>
        <th>giaBan</th>
        <th>nguoiTao</th>
        <th>nguoiSua</th>
        <th>NgayTao</th>
        <th>NgaySua</th>
        <th>ghiChu</th>
        <th>TrangThai</th>
        <th scope="col">Action</th>
    </tr>
    <tbody>
    <c:forEach var="ctsp" items="${list.content}">
        <tr>
            <td>${ctsp.idSanPham.tenSanPham}</td>
            <td>${ctsp.idMauSac.tenMauSac}</td>
            <td>${ctsp.idAnh.idAnh}</td>
<%--            <td><img src="${ctsp.idAnh.url}" alt="Anh" width="50"></td>--%>
            <td>${ctsp.moTa}</td>
            <td>${ctsp.giaBan}</td>
            <td>${ctsp.nguoiTao.email}</td>
            <td>${ctsp.nguoiSua.email}</td>
            <td>
                <c:set var="ngayTao" value="${ctsp.ngayTao}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${ngayTao}" />
            </td>
            <td>
                <c:set var="ngaySua" value="${ctsp.ngaySua}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${ngaySua}" />
            </td>
            <td>${ctsp.ghiChu}</td>
            <td>${ctsp.trangThai}</td>
            <td>
                <button class="btn btn-light" onclick="return confirm('Bạn có muốn xóa không?')" ><a class="btn btn-light" href="/ctsp/delete/${ctsp.idCTSP}">Delete</a></button>
                <button class="btn btn-dark"><a class="btn btn-dark" href="/ctsp/updateForm/${ctsp.idCTSP}">Detail</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<footer>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/ctsp/hien-thi?page=${list.number - 1}">Truoc</a></li>
            <li class="page-item"><a class="page-link" href="#">${list.number}</a></li>
            <li class="page-item"><a class="page-link" href="/ctsp/hien-thi?page=${list.number + 1}">Sau</a></li>
        </ul>
    </nav>
</footer>
</body>

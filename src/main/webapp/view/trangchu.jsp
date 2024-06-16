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

<div class="container-fluid">
    <header class="bg-light">

        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Features</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Pricing</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="/sanpham/hien-thi" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Dropdown link
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/sanpham/hien-thi">Action</a></li>
                                <li><a class="dropdown-item" href="/sanpham/hien-thi">Another action</a></li>
                                <li><a class="dropdown-item" href="/sanpham/hien-thi">Something else here</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <!-- main -->
    <main>

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
                <div class="col-md-12 mt-2">
                    <div>
                        <label><input type="radio" name="giaBanRange" value="0-5"> 5 trở xuống</label>
                        <label><input type="radio" name="giaBanRange" value="5-10"> 5 - 10</label>
                        <label><input type="radio" name="giaBanRange" value="10-50"> 10 - 50</label>
                        <label><input type="radio" name="giaBanRange" value="50-99999999"> 50 trở lên</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <button type="submit" class="btn btn-primary">Tìm kiếm</button>
                </div>
            </div>
        </form>
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
                    <td>
                        <c:if test="${ctsp.trangThai==1}" >Con hang</c:if>
                        <c:if test="${ctsp.trangThai==0}" >Het hang</c:if>
                    </td>

                </tr>
            </c:forEach>
            </tbody>

        </table>

    </main>
    <!-- kết -->
    <footer>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/trangchu/hien-thi?page=${list.number - 1}">Truoc</a></li>
                <li class="page-item"><a class="page-link" href="#">${list.number}</a></li>
                <li class="page-item"><a class="page-link" href="/trangchu/hien-thi?page=${list.number + 1}">Sau</a></li>
            </ul>
        </nav>
    </footer>
</div>

</body>

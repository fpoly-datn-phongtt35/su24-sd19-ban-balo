<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>King Shop</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .form-container {
            margin: 2rem 0;
        }
        .form-group {
            margin-bottom: 1rem;
        }
        .form-check {
            margin-bottom: 0.5rem;
        }
        .table-container {
            margin-top: 2rem;
        }
        .btn-custom {
            margin-right: 0.5rem;
        }
    </style>
</head>
<body>
<main class="container mt-4">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="container-fluid">
                <a class="navbar-brand" href="/chung/hien-thi">Home</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/chi-tiet-sp/hien-thi">Sản Phẩm Chi Tiết</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/dong-san-pham/hien-thi">Dòng Sp</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/mau-sac/hien-thi">Màu sắc</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/san-pham/hien-thi">Sản Phẩm</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/cua-hang/hien-thi">Cửa hàng</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/chuc-vu/hien-thi">Chức Vụ</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/nhan-vien/hien-thi">Nhân Viên</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/khach-hang/hien-thi">Khách Hàng</a></li>
                    </ul>
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" aria-current="page" href="/login">Đăng Nhập</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <div class="form-container">
        <form action="/chuc-vu/add" method="post">
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="maChucVu" class="form-label">Mã</label>
                    <input type="text" id="maChucVu" name="maChucVu" class="form-control" value="${cv.maChucVu}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="tenChucVu" class="form-label">Tên</label>
                    <input type="text" id="tenChucVu" name="tenChucVu" class="form-control" value="${cv.tenChucVu}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="ngayTao" class="form-label">Ngày Tạo</label>
                    <input type="date" id="ngayTao" name="ngayTao" class="form-control" value="${cv.ngayTao}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="ngaySua" class="form-label">Ngày Sửa</label>
                    <input type="date" id="ngaySua" name="ngaySua" class="form-control" value="${cv.ngaySua}">
                </div>
            </div>
            <fieldset class="form-group">
                <legend class="form-label">Trạng Thái</legend>
                <div class="form-check">
                    <input class="form-check-input" type="radio" id="trangThai1" name="trangThai" value="1" ${cv.trangThai == 1 ? "checked" : ""}>
                    <label class="form-check-label" for="trangThai1">Hoạt động</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" id="trangThai2" name="trangThai" value="2" ${cv.trangThai == 2 ? "checked" : ""}>
                    <label class="form-check-label" for="trangThai2">Ngưng hoạt động</label>
                </div>
            </fieldset>
            <button type="submit" class="btn btn-secondary btn-custom">ADD</button>
            <a href="/chuc-vu/hien-thi" class="btn btn-danger btn-custom">Hiển Thị</a>
        </form>
    </div>

    <hr>

    <div class="table-container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Ngày Tạo</th>
                <th scope="col">Ngày Sửa</th>
                <th scope="col">Trạng Thái</th>
                <th scope="col">Khác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cv" items="${ListCV}">
                <tr>
                    <td>${cv.maChucVu}</td>
                    <td>${cv.tenChucVu}</td>
                    <td>${cv.ngayTao}</td>
                    <td>${cv.ngaySua}</td>
                    <td>${cv.trangThai == 1 ? 'Hoạt động' : 'Ngưng hoạt động'}</td>
                    <td>
                        <a href="/chuc-vu/view-update/${cv.id}" class="btn btn-success btn-sm">Update</a>
                        <a href="/chuc-vu/remove/${cv.id}" class="btn btn-warning btn-sm" onclick="return confirm('Bạn có muốn xóa không?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-4mFOYF/fD8aHn9G6tbG6D6dpq8x5m+frErD2s4J6DO8M0ChXVXvFo1eD1McBtL4x5" crossorigin="anonymous"></script>
</body>
</html>

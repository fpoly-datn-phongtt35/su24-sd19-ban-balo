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
        .container {
            margin-top: 20px;
        }
        .form-container {
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            background-color: #fff;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 1rem;
        }
        .form-label {
            font-weight: bold;
        }
        .form-check {
            margin-bottom: 0.5rem;
        }
        .form-group input[type="text"],
        .form-group input[type="date"] {
            width: 100%;
        }
        .btn-custom {
            margin-right: 0.5rem;
        }
    </style>
</head>
<body>
<main class="container">
    <header>
        <h2 class="my-4">Update</h2>
    </header>
    <div class="form-container">
        <form action="/chuc-vu/update/${cv.id}" method="post">
            <div class="mb-3">
                <label for="maChucVu" class="form-label">Mã</label>
                <input type="text" id="maChucVu" name="maChucVu" class="form-control" value="${cv.maChucVu}">
            </div>
            <div class="mb-3">
                <label for="tenChucVu" class="form-label">Tên</label>
                <input type="text" id="tenChucVu" name="tenChucVu" class="form-control" value="${cv.tenChucVu}">
            </div>
            <div class="mb-3">
                <label for="ngayTao" class="form-label">Ngày Tạo</label>
                <input type="date" id="ngayTao" name="ngayTao" class="form-control" value="${cv.ngayTao}">
            </div>
            <div class="mb-3">
                <label for="ngaySua" class="form-label">Ngày Sửa</label>
                <input type="date" id="ngaySua" name="ngaySua" class="form-control" value="${cv.ngaySua}">
            </div>
            <fieldset class="mb-3">
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
            <button type="submit" class="btn btn-secondary btn-custom">Update</button>
            <a href="/chuc-vu/hien-thi" class="btn btn-warning btn-custom">Hiển Thị</a>
        </form>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-1t8M0z1z4b9WVm68hI8j5b9E6Chy0RMZf1e6fdfZ77zxS8eY1CvY4d68HT6XSJ1l8" crossorigin="anonymous"></script>
</body>
</html>

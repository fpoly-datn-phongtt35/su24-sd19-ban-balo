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
            margin: 1rem 0;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            background-color: #fff;
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
        .form-group select {
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
        <form action="/nhan-vien/update/${nv.id}" method="post">
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="maNhanVien" class="form-label">Mã</label>
                    <input type="text" id="maNhanVien" name="maNhanVien" class="form-control" value="${nv.maNhanVien}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="tenNhanVien" class="form-label">Tên</label>
                    <input type="text" id="tenNhanVien" name="tenNhanVien" class="form-control" value="${nv.tenNhanVien}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="tenDemNhanVien" class="form-label">Tên Đệm</label>
                    <input type="text" id="tenDemNhanVien" name="tenDemNhanVien" class="form-control" value="${nv.tenDemNhanVien}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="hoNhanVien" class="form-label">Họ</label>
                    <input type="text" id="hoNhanVien" name="hoNhanVien" class="form-control" value="${nv.hoNhanVien}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="ngayTao" class="form-label">Ngày Tạo</label>
                    <input type="date" id="ngayTao" name="ngayTao" class="form-control" value="${nv.ngayTao}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="ngaySua" class="form-label">Ngày Sửa</label>
                    <input type="date" id="ngaySua" name="ngaySua" class="form-control" value="${nv.ngaySua}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="ngaySinh" class="form-label">Ngày Sinh</label>
                    <input type="date" id="ngaySinh" name="ngaySinh" class="form-control" value="${nv.ngaySinh}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="sdt" class="form-label">Số điện thoại</label>
                    <input type="text" id="sdt" name="sdt" class="form-control" value="${nv.sdt}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="cccd" class="form-label">CCCD</label>
                    <input type="text" id="cccd" name="cccd" class="form-control" value="${nv.cccd}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="soNha" class="form-label">Số Nhà</label>
                    <input type="text" id="soNha" name="soNha" class="form-control" value="${nv.soNha}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="phuongXa" class="form-label">Phường Xã</label>
                    <input type="text" id="phuongXa" name="phuongXa" class="form-control" value="${nv.phuongXa}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="quanHuyen" class="form-label">Quận Huyện</label>
                    <input type="text" id="quanHuyen" name="quanHuyen" class="form-control" value="${nv.quanHuyen}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="tinhThanhPho" class="form-label">Thành Phố</label>
                    <input type="text" id="tinhThanhPho" name="tinhThanhPho" class="form-control" value="${nv.tinhThanhPho}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="chucVu" class="form-label">Chức Vụ</label>
                    <select id="chucVu" name="chucVu" class="form-select">
                        <c:forEach items="${chucVus}" var="cv">
                            <option value="${cv.id}" ${nv.chucVu.id == cv.id ? "selected" : ""}>${cv.tenChucVu}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="d-flex justify-content-around">
                <fieldset class="form-group">
                    <legend class="form-label">Giới Tính</legend>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" id="gioiTinh1" name="gioiTinh" value="1" ${nv.gioiTinh == 1 ? "checked" : ""}>
                        <label class="form-check-label" for="gioiTinh1">Nam</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" id="gioiTinh2" name="gioiTinh" value="2" ${nv.gioiTinh == 2 ? "checked" : ""}>
                        <label class="form-check-label" for="gioiTinh2">Nữ</label>
                    </div>
                </fieldset>
                <fieldset class="form-group">
                    <legend class="form-label">Trạng Thái</legend>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" id="trangThai1" name="trangThai" value="1" ${nv.trangThai == 1 ? "checked" : ""}>
                        <label class="form-check-label" for="trangThai1">Hoạt động</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" id="trangThai2" name="trangThai" value="2" ${nv.trangThai == 2 ? "checked" : ""}>
                        <label class="form-check-label" for="trangThai2">Ngưng hoạt động</label>
                    </div>
                </fieldset>
            </div>
            <button type="submit" class="btn btn-secondary btn-custom">Update</button>
            <a href="/nhan-vien/hien-thi" class="btn btn-danger btn-custom">Hiển Thị</a>
        </form>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-1t8M0z1z4b9WVm68hI8j5b9E6Chy0RMZf1e6fdfZ77zxS8eY1CvY4d68HT6XSJ1l8" crossorigin="anonymous"></script>
</body>
</html>

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
            margin-bottom: 2rem;
        }
        .form-container .form-label {
            margin-bottom: 0.5rem;
        }
        .form-container .form-group {
            margin-bottom: 1rem;
        }
        .table-responsive {
            margin-top: 2rem;
        }
    </style>
</head>
<body>
<main class="container mt-4">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-info mb-4">
            <div class="container-fluid">
                <a class="navbar-brand" href="/chung/hien-thi">Home</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link active" href="/chi-tiet-sp/hien-thi">Sản Phẩm Chi Tiết</a></li>
                        <li class="nav-item"><a class="nav-link active" href="/dong-san-pham/hien-thi">Dòng Sp</a></li>
                        <li class="nav-item"><a class="nav-link active" href="/mau-sac/hien-thi">Màu sắc</a></li>
                        <li class="nav-item"><a class="nav-link active" href="/san-pham/hien-thi">Sản Phẩm</a></li>
                        <li class="nav-item"><a class="nav-link active" href="/cua-hang/hien-thi">Cửa hàng</a></li>
                        <li class="nav-item"><a class="nav-link active" href="/chuc-vu/hien-thi">Chức Vụ</a></li>
                        <li class="nav-item"><a class="nav-link active" href="/nhan-vien/hien-thi">Nhân Viên</a></li>
                        <li class="nav-item"><a class="nav-link active" href="/khach-hang/hien-thi">Khách Hàng</a></li>
                    </ul>
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="/login">Đăng Nhập</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <div class="form-container">
        <form action="/nhan-vien/search" method="get" class="d-flex">
            <label for="search" class="form-label me-2">Search:</label>
            <input type="text" id="search" name="key" class="form-control me-2">
            <button class="btn btn-warning" type="submit">Search</button>
        </form>
    </div>

    <div class="card p-4 mb-4">
        <form action="/nhan-vien/add" method="post">
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="maNhanVien" class="form-label">Mã</label>
                    <input type="text" id="maNhanVien" name="maNhanVien" class="form-control" value="${nv.maNhanVien}">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="hoNhanVien" class="form-label">Họ</label>
                    <input type="text" id="hoNhanVien" name="hoNhanVien" class="form-control" value="${nv.hoNhanVien}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="tenDemNhanVien" class="form-label">Tên Đệm</label>
                    <input type="text" id="tenDemNhanVien" name="tenDemNhanVien" class="form-control" value="${nv.tenDemNhanVien}">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="tenNhanVien" class="form-label">Tên</label>
                    <input type="text" id="tenNhanVien" name="tenNhanVien" class="form-control" value="${nv.tenNhanVien}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="ngayTao" class="form-label">Ngày Tạo</label>
                    <input type="date" id="ngayTao" name="ngayTao" class="form-control" value="${nv.ngayTao}">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="ngaySua" class="form-label">Ngày Sửa</label>
                    <input type="date" id="ngaySua" name="ngaySua" class="form-control" value="${nv.ngaySua}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="ngaySinh" class="form-label">Ngày Sinh</label>
                    <input type="date" id="ngaySinh" name="ngaySinh" class="form-control" value="${nv.ngaySinh}">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="sdt" class="form-label">Số điện thoại</label>
                    <input type="text" id="sdt" name="sdt" class="form-control" value="${nv.sdt}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="cccd" class="form-label">CCCD</label>
                    <input type="text" id="cccd" name="cccd" class="form-control" value="${nv.cccd}">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="soNha" class="form-label">Số Nhà</label>
                    <input type="text" id="soNha" name="soNha" class="form-control" value="${nv.soNha}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="phuongXa" class="form-label">Phường Xã</label>
                    <input type="text" id="phuongXa" name="phuongXa" class="form-control" value="${nv.phuongXa}">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="quanHuyen" class="form-label">Quận Huyện</label>
                    <input type="text" id="quanHuyen" name="quanHuyen" class="form-control" value="${nv.quanHuyen}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="tinhThanhPho" class="form-label">Thành Phố</label>
                    <input type="text" id="tinhThanhPho" name="tinhThanhPho" class="form-control" value="${nv.tinhThanhPho}">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="chucVu" class="form-label">Chức Vụ</label>
                    <select id="chucVu" name="chucVu" class="form-select">
                        <c:forEach items="${chucVus}" var="cv">
                            <option value="${cv.id}" ${nv.chucVu.id == cv.id ? "selected" : ""}>${cv.tenChucVu}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
           <div class="d-flex justify-content-sm-around ">
               <fieldset class="float-start mb-3">
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
               <fieldset class="float-end mb-3">
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
            <button type="submit" class="btn btn-secondary">ADD</button>
            <a href="/nhan-vien/hien-thi" class="btn btn-danger">Hiển Thị</a>
        </form>
    </div>

    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Mã</th>
                <th scope="col">Họ và tên</th>
                <th scope="col">Ngày Sinh</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">CCCD</th>
                <th scope="col">Địa Chỉ</th>
                <th scope="col">Ngày Tạo</th>
                <th scope="col">Ngày Sửa</th>
                <th scope="col">Chức Vụ</th>
                <th scope="col">Giới Tính</th>
                <th scope="col">Trạng thái</th>
                <th scope="col">Khác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${nhanViens.content}" var="nv">
                <tr>
                    <th scope="row">${nv.id}</th>
                    <td>${nv.maNhanVien}</td>
                    <td>${nv.hoNhanVien} ${nv.tenDemNhanVien} ${nv.tenNhanVien}</td>
                    <td>${nv.ngaySinh}</td>
                    <td>${nv.sdt}</td>
                    <td>${nv.cccd}</td>
                    <td>${nv.soNha} ${nv.phuongXa} ${nv.quanHuyen} ${nv.tinhThanhPho}</td>
                    <td>${nv.ngayTao}</td>
                    <td>${nv.ngaySua}</td>
                    <td>${nv.chucVu.tenChucVu}</td>
                    <td>${nv.gioiTinh == 1 ? 'Nam' : 'Nữ'}</td>
                    <td>${nv.trangThai == 1 ? 'Hoạt động' : 'Ngưng hoạt động'}</td>
                    <td>
                        <a href="/nhan-vien/view-update/${nv.id}" class="btn btn-success btn-sm">Update</a>
                        <a href="/nhan-vien/remove/${nv.id}" class="btn btn-warning btn-sm" onclick="return confirm('Bạn có muốn xóa không?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <li class="page-item ${nhanViens.first ? 'disabled' : ''}">
                <a class="page-link" href="/nhan-vien/hien-thi?page=0" aria-label="First">
                    <span aria-hidden="true">&laquo;&laquo;</span>
                </a>
            </li>
            <li class="page-item ${nhanViens.first ? 'disabled' : ''}">
                <a class="page-link" href="/nhan-vien/hien-thi?page=${nhanViens.first ? 0 : nhanViens.number - 1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var="pageNumber" begin="0" end="${nhanViens.totalPages > 0 ? nhanViens.totalPages - 1 : 0}">
                <li class="page-item ${nhanViens.number == pageNumber ? 'active' : ''}">
                    <a class="page-link" href="/nhan-vien/hien-thi?page=${pageNumber}">${pageNumber + 1}</a>
                </li>
            </c:forEach>
            <li class="page-item ${nhanViens.last ? 'disabled' : ''}">
                <a class="page-link" href="/nhan-vien/hien-thi?page=${nhanViens.last ? nhanViens.totalPages - 1 : nhanViens.number + 1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <li class="page-item ${nhanViens.last ? 'disabled' : ''}">
                <a class="page-link" href="/nhan-vien/hien-thi?page=${nhanViens.totalPages - 1}" aria-label="Last">
                    <span aria-hidden="true">&raquo;&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-4mFOYF/fD8aHn9G6tbG6D6dpq8x5m+frErD2s4J6DO8M0ChXVXvFo1eD1McBtL4x5" crossorigin="anonymous"></script>
</body>
</html>

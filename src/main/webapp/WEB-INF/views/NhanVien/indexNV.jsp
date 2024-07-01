<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<main>
    <div class="text-center">
        <div class="mb-3">
            <h3>Nhân Viên</h3>
        </div>
    </div>
    <div style="padding: 20px"  class="card">
        <form action="/nhan-vien/search" method="get">
            <div class="row">
                <div class="d-flex">
                    <label>Search:</label>
                    <input type="text" name="key" class="form-control" style="margin-left: 20px">
                    <button class="btn btn-warning">Search</button>
                </div>
            </div>
        </form>
    </div>

    <form action="/nhan-vien/add" method="post" class="all-classes-container">
        Ma <input type="text" name="maNhanVien" value="${nv.maNhanVien}"/><br>
        Họ <input type="text" name="hoNhanVien" value="${nv.hoNhanVien}"/><br>
        Tên Đệm <input type="text" name="tenDemNhanVien" value="${nv.tenDemNhanVien}"/><br>
        Tên <input type="text" name="tenNhanVien" value="${nv.tenNhanVien}"/><br>
        Ngay Tao <input type="date" name="ngayTao" value="${nv.ngayTao}"/><br>
        Ngay Sửa <input type="date" name="ngaySua" value="${nv.ngaySua}"/><br>
        Ngay Sinh <input type="date" name="ngaySinh" value="${nv.ngaySinh}"/><br>
        Số điện thoại<input type="text" name="sdt" value="${nv.sdt}"/><br>
        CCCD<input type="text" name="cccd" value="${nv.cccd}"/><br>
        Số Nhà<input type="text" name="soNha" value="${nv.soNha}"/><br>
        Phường Xã<input type="text" name="phuongXa" value="${nv.phuongXa}"/><br>
        Quận Huyện<input type="text" name="quanHuyen" value="${nv.quanHuyen}"/><br>
        Thành Phố<input type="text" name="tinhThanhPho" value="${nv.tinhThanhPho}"/><br>
        Chức Vụ <select name="chucVu">
        <c:forEach items="${chucVus}" var="cv">
            <option value="${cv.id}"  ${nv.chucVu.id==cv.id?"selected":""} >${cv.tenChucVu}</option>
        </c:forEach>
    </select>
        <br>
        Giới Tính
        <input type="radio" name="gioiTinh" value="1" ${nv.gioiTinh == 1 ? "checked" : ""}/>Nam
        <input type="radio" name="gioiTinh" value="2" ${nv.gioiTinh == 2 ? "checked" : ""} />Nữ
        <br>
        Trang Thai
        <input type="radio" name="trangThai" value="1" ${nv.trangThai == 1 ? "checked" : ""}/>Hoạt động
        <input type="radio" name="trangThai" value="2" ${nv.trangThai == 2 ? "checked" : ""} />Ngưng hoạt động
        <button type="submit" class="btn btn-secondary">ADD</button>
        <a href="/nhan-vien/hien-thi" type="button" class="btn btn-danger">Hiển Thị</a>

    </form>
    <hr>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col" type="hidden">Id</th>
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
            <c:forEach items="${nhanViens.content}" var="nv" >
                <tr>
                    <th scope="row" type="hidden">${nv.id}</th>
                    <td>${nv.maNhanVien}</td>
                    <td>${nv.hoNhanVien} ${nv.tenDemNhanVien} ${nv.tenNhanVien}</td>
                    <td>${nv.ngaySinh}</td>
                    <td>${nv.sdt}</td>
                    <td>${nv.cccd}</td>
                    <td>${nv.soNha} ${nv.phuongXa} ${nv.quanHuyen} ${nv.tinhThanhPho}</td>
                    <td>${nv.ngayTao}</td>
                    <td>${nv.ngaySua}</td>
                    <td>${nv.chucVu.tenChucVu}</td>
                    <td>${nv.gioiTinh == 1 ? 'Nam':'Nữ'}</td>
                    <td>${nv.trangThai == 1 ? 'Hoạt động':'Ngưng hoạt động'}</td>

                    <td>
                        <a href="/nhan-vien/view-update/${nv.id}" type="button" class="btn btn-success">Update</a>
                        <a href="/nhan-vien/remove/${nv.id}" type="button" class="btn btn-warning">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="text-center">
            <a href="/nhan-vien/hien-thi?page=0" class="btn btn-secondary">First</a>
            <a href="/nhan-vien/hien-thi?page=${nhanViens.first?0:nhanViens.number-1}" class="btn btn-secondary">Prev</a>
            <c:forEach var="pageNumber" begin="0" end="${nhanViens.totalPages>0?nhanViens.totalPages-1:0}">
                <a href="/nhan-vien/hien-thi?page=${pageNumber}" class="btn btn-secondary">${pageNumber+1}</a>
            </c:forEach>
            <a href="/nhan-vien/hien-thi?page=${nhanViens.last?nhanViens.totalPages-1:nhanViens.number+1}"
               class="btn btn-secondary">Next</a>
            <a href="/nhan-vien/hien-thi?page=${nhanViens.totalPages-1}" class="btn btn-secondary">Last</a>
        </div>
    </div>

</main>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn"
           uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    <script>
        function validateForm() {
            var ma = document.forms["yourFormName"]["ma"].value;
            var ten = document.forms["yourFormName"]["ten"].value;
            var ho = document.forms["yourFormName"]["ho"].value;
            var sdt = document.forms["yourFormName"]["sdt"].value;
            var ngaySinh = document.forms["yourFormName"]["ngaySinh"].value;
            var diaChi = document.forms["yourFormName"]["diaChi"].value;
            var matKhau = document.forms["yourFormName"]["matKhau"].value;

            if (ma.trim() === "") {
                alert("Mã không được để trống");
                return false;
            }

            if (ten.trim() === "") {
                alert("Tên không được để trống");
                return false;
            }

            if (ho.trim() === "") {
                alert("Họ không được để trống");
                return false;
            }

            if (sdt.trim() === "") {
                alert("Số điện thoại không được để trống");
                return false;
            }

            if (ngaySinh.trim() === "") {
                alert("Ngày sinh không được để trống");
                return false;
            }

            if (diaChi.trim() === "") {
                alert("Địa chỉ không được để trống");
                return false;
            }

            if (matKhau.trim() === "") {
                alert("Mật khẩu không được để trống");
                return false;
            }

            // Kiểm tra các trường khác ở đây nếu cần.

            return true;
        }
    </script>

</head>
<body>
<h2>Nhân Viên</h2>
<body>
<div class="row">
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
        <div class="container-fluid">
            <a class="navbar-brand" href="/chung/hien-thi">Đăng Nhập</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <%--                    <li class="nav-item">--%>
                    <%--                        <a class="nav-link active" aria-current="page" href="/ban-hang/hien-thi">Bán Hàng</a>--%>
                    <%--                    </li>--%>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/chi-tiet-sp/hien-thi">Sản Phẩm Chi
                            Tiết</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/dong-san-pham/hien-thi">Dòng Sp</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/mau-sac/hien-thi">Màu sắc</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/san-pham/hien-thi">Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/chuc-vu/hien-thi">Chức Vụ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/nsx/hien-thi">Nhà Sản Xuất</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/nhan-vien/hien-thi">Nhân Viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/khach-hang/hien-thi">Khách Hàng</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
    <div class="col-sm-9">

        <form:form modelAttribute="sp" method="post" name="yourFormName" onsubmit="return validateForm()"
                   action="/nhan-vien/add">
            <div id="hai" class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label class="control-label col-sm-2">Mã:</label>
                            <div class="col-sm-10">
                                <form:input class="form-control" id="email" path="maNhanVien"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Tên:</label>
                            <div class="col-sm-10">
                                <form:input path="tenNhanVien" type="text" class="form-control"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Họ:</label>
                            <div class="col-sm-10">
                                <form:input path="hoNhanVien" type="text" class="form-control" id="pwd"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">SDT:</label>
                            <div class="col-sm-10">
                                <form:input path="sdt" type="text" class="form-control"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Giới tính:</label>
                            <div class="col-sm-10">
                                <p>Nam <input type="radio" name="gioiTinh"
                                              value="Nam" ${sp.gioiTinh=="Nam"?"checked":""} checked/>
                                    Nữ <input type="radio" name="gioiTinh" value="Nu" ${sp.gioiTinh=="Nu"?"checked":""}>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label class="control-label col-sm-2">Ngày Sinh:</label>
                            <div class="col-sm-10">
                                <form:input path="ngaySinh" type="date" class="form-control"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">CCCD:</label>
                            <div class="col-sm-10">
                                <form:input path="cccd" type="text" class="form-control"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">CCCD:</label>
                            <div class="col-sm-10">
                                <form:input path="cccd" type="text" class="form-control"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Số Nhà:</label>
                            <div class="col-sm-10">
                                <form:input path="soNha" type="text" class="form-control"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Phường Xã:</label>
                            <div class="col-sm-10">
                                <form:input path="phuongXa" type="text" class="form-control"></form:input>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Quận Huyện:</label>
                        <div class="col-sm-10">
                            <form:input path="quanHuyen" type="text" class="form-control"></form:input>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Thành Phố:</label>
                    <div class="col-sm-10">
                        <form:input path="tinhThanhPho" type="text" class="form-control"></form:input>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Ngày tạo:</label>
                        <div class="col-sm-10">
                            <form:input path="ngayTao" type="date" class="form-control"></form:input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Ngày Sửa:</label>
                        <div class="col-sm-10">
                            <form:input path="ngaySua" type="date" class="form-control"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Mật khẩu:</label>
                        <div class="col-sm-10">
                            <form:input path="matKhau" type="text" class="form-control"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Chức Vụ:</label>
                        <div class="col-sm-10">
                            <c:set value="${sp.cv.ten}" var="tong3"></c:set>
                            <select name="cv" class="form-select">
                                <c:forEach var="h" items="${listSP}">
                                    <c:set value="${h.cv.ten}" var="hai"></c:set>
                                    <c:if test="${h.cv.ten ne null}">
                                        <option value="${h.cv.id}" ${tong3 eq hai  ? "selected" : ""}>${h.cv.ten}</option>
                                    </c:if>
                                </c:forEach>

                            </select>

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Trạng Thái:</label>
                        <div class="col-sm-10">
                            <p>Hoạt động <input type="radio" name="trangThai" value=0 ${sp.trangThai== 0 ?"checked":""}
                                                checked/>
                                Ngưng hoạt động <input type="radio" name="trangThai"
                                                       value=1 ${sp.trangThai== 1 ?"checked":""}>
                            </p>
                        </div>
                    </div>
                </div>

            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10 pt-4">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </div>

        </form:form>
    </div>
</div>
</div>
<table class="table">
    <thead>
    <tr>
        <th scope="col" hidden="hidden">Id</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Họ</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">CCCD</th>
        <th scope="col">Số Nhà</th>
        <th scope="col">Phường Xã</th>
        <th scope="col">Quận Huyện</th>
        <th scope="col">Thành Phố</th>
        <th scope="col">SDT</th>
        <th scope="col">Mật khẩu</th>
        <th scope="col">Chức vụ</th>
        <th scope="col">Ngày Tạo</th>
        <th scope="col">Ngày Sửa</th>
        <th scope="col">Trạng Thái</th>
        <th scope="col">Khác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sp" items="${listSP}">
        <tr>
            <th scope="row" hidden="hidden">${sp.id}</th>
            <td>${sp.maNhanVien}</td>
            <td>${sp.tenNhanVien}</td>
            <td>${sp.hoNhanVien}</td>
            <td>${sp.gioiTinh}</td>
            <td>${sp.ngaySinh}</td>
            <td>${sp.cccd}</td>
            <td>${sp.diaChi}</td>
            <td>${sp.soNha}</td>
            <td>${sp.phuongXa}</td>
            <td>${sp.quanHuyen}</td>
            <td>${sp.tinhThanhPho}</td>
            <td>${sp.sdt}</td>
            <td>${sp.matKhau}</td>
            <td>${sp.cv.ten}</td>
            <td>${sp.ngayTao}</td>
            <td>${sp.ngaySua}</td>
            <td>${sp.trangThai == 0?"Hoat Dong":"Ngưng Hoat Dong"}</td>

            <td>
                <a href="/nhan-vien/detail/${sp.id}" class="btn btn-primary" type="button">Detail</a>
                <a href="/nhan-vien/delete/${sp.id}" type="button" class="btn btn-danger">Delete</a>
                <a href="/nhan-vien/view-update/${sp.id}" type="button" class="btn btn-success">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<span>
    <c:forEach varStatus="ok" var="hai" items="${listSP}">
        <a href="/nhan-vien/hien-thi?a=${ok.index}">${ok.index + 1}</a>
    </c:forEach>
</span>
</div>
</body>

</html>



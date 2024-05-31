<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
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

            if (ma.trim() === "") {
                alert("Mã không được để trống");
                return false;
            }

            if (ten.trim() === "") {
                alert("Tên không được để trống");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<h2>Chức vụ</h2>
<div class="row">
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
        <div class="container-fluid">
            <a class="navbar-brand" href="/chung/hien-thi">Đăng Nhập</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link active" aria-current="page" href="/ban-hang/hien-thi">Bán Hàng</a>--%>
<%--                    </li>--%>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"  href="/chi-tiet-sp/hien-thi">Sản Phẩm Chi Tiết</a>
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
<form:form modelAttribute="sp" method="post" name="yourFormName" onsubmit="return validateForm()" action="/chuc-vu/add">
<div id ="hai" class="container">
    <div class="form-group">
        <label class="control-label col-sm-2" >Mã:</label>
        <div class="col-sm-10">
            <form:input  class="form-control" id="email" path="maChucVu"></form:input>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2">Tên Chức Vụ:</label>
        <div class="col-sm-10">
            <form:input path="tenChucVu" class="form-control" id="pwd"></form:input>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2">Ngày Sửa:</label>
        <div class="col-sm-10">
            <form:input path="ngaySua" type="date" class="form-control"></form:input>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2">Ngày Tạo:</label>
        <div class="col-sm-10">
            <form:input path="ngayTao" type="date" class="form-control"></form:input>
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
    <div class="form-group">s
        <div class="col-sm-offset-2 col-sm-10 pt-4">
            <button type="submit" class="btn btn-primary">Add</button>
        </div>
    </div>

    </form:form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col" hidden="hidden">Id</th>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Ngày Sửa</th>
            <th scope="col">Ngày Tạo</th>
            <th scope="col">Trạng Thái</th>
            <th scope="col">Khác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sp" items="${listSP}">
            <tr>
                <th hidden= "hidden" scope="row">${sp.id}</th>
                <td>${sp.maChucVu}</td>
                <td>${sp.tenChucVu}</td>
                <td>${sp.ngaySua}</td>
                <td>${sp.ngayTao}</td>
                <td>${sp.trangThai == 0?"Hoat Dong":"Ngưng Hoat Dong"}</td>
                <td>
                    <a href="/chuc-vu/detail/${sp.id}" class="btn btn-primary" type="button">Detail</a>
                    <a href="/chuc-vu/delete/${sp.id}" class="btn btn-danger" type="button">Delete</a>
                    <a href="/chuc-vu/view-update/${sp.id}" type="button" class="btn btn-success">Update</a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <span>
    <c:forEach varStatus="ok" var="hai" items="${listSP}">
        <a href="/chuc-vu/hien-thi?a=${ok.index}">${ok.index + 1}</a>
    </c:forEach>
</span>
</div>
    </div>
</div>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sach Tai khoan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="../../../vendor/owl-carousel/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../../../vendor/owl-carousel/css/owl.theme.default.min.css">
    <link href="../../../vendor/datatables/css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="../../../vendor/jqvmap/css/jqvmap.min.css" rel="stylesheet">
    <link href="../../../css/style.css" rel="stylesheet">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>

<section class="vh-130" style="background-color: #bccff9;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-7">
                <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                        <div class="col-md-12 col-lg-12 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">
                                <div class="row">
                                    <div class="col-12">
                                        <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Đăng ký tài
                                            khoản</h3>
                                    </div>
                                    <div class="col-12">
                                        <h4 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Nếu đã có tài khoản
                                            bạn có thể
                                            <a class="small text-muted" href="/login"
                                               style="font-size: large"><p style="color: red">Đăng nhập tại đây</p></a>
                                        </h4>
                                    </div>
                                </div>
                                <form action="/tai-khoan/dang-ki/add" method="post" >
                                    <div class="col-12 grid-margin" style="color:#0b0b0b;">
                                        <div class="card">
                                            <div class="card-body">
                                                <form class="form-sample">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="form-group row">
                                                                <form:label class="col-sm-3 col-form-label"
                                                                            path="hoTen">Tài khoản :
                                                                </form:label>
                                                                <div class="col-sm-9">
                                                                    <input
                                                                            type="text"
                                                                            class="form-control"
                                                                            placeholder="Email"
                                                                            name="email"
                                                                            id=email"
                                                                    />
                                                                    <label id="tenkh1" style="color: red"></label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12">
                                                            <div class="form-group row">
                                                                <form:label class="col-sm-3 col-form-label"
                                                                            path="email">Mật khẩu:</form:label>
                                                                <div class="col-sm-9">
                                                                    <input
                                                                            type="password"
                                                                            class="form-control"
                                                                            placeholder="Mật khẩu"
                                                                            name="passWord"
                                                                            id=passWord"
                                                                    />
                                                                    <label id="email1" style="color: red">${tbtrungemail}</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12">
                                                            <div class="form-group row">
                                                                <form:label class="col-sm-3 col-form-label"
                                                                            path="soDienThoai">SĐT:</form:label>
                                                                <div class="col-sm-9">
                                                                    <input
                                                                            type="text"
                                                                            class="form-control"
                                                                            placeholder="Số điện thoại"
                                                                            name="sdt"
                                                                            id=sdt"
                                                                    />
                                                                    <label id="sdtkh1" style="color: red">${tbtrungsdt}</label>
                                                                </div>
                                                            </div>
                                                        </div>
<%--                                                        <div class="col-md-12">--%>
<%--                                                            <div class="form-group row">--%>
<%--                                                                <form:label class="col-sm-3 col-form-label"--%>
<%--                                                                            path="ngaySinh">Ngày Sinh:</form:label>--%>
<%--                                                                <div class="col-sm-9">--%>
<%--                                                                    <input class="form-control" placeholder=""--%>
<%--                                                                                path="ngaySinh" type="date" required="true"/>--%>
<%--                                                                    <span style="color: red">${tbt14tuoi}</span>--%>
<%--                                                                </div>--%>
<%--                                                            </div>--%>
<%--                                                        </div>--%>
<%--                                                        <div class="col-md-12">--%>
<%--                                                            <div class="form-group row">--%>
<%--                                                                <form:label class="col-sm-3 col-form-label"--%>
<%--                                                                            path="gioiTinh">Giới Tính:</form:label>--%>
<%--                                                                <div class="col-sm-9">--%>
<%--                                                                    <div>--%>
<%--                                                                        <div class="form-check">--%>
<%--                                                                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" path="gioiTinh">--%>
<%--                                                                            <label class="form-check-label" for="flexRadioDefault1">--%>
<%--                                                                                Nam--%>
<%--                                                                            </label>--%>
<%--                                                                        </div>--%>
<%--                                                                        <div class="form-check">--%>
<%--                                                                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" path="gioiTinh" checked>--%>
<%--                                                                            <label class="form-check-label" for="flexRadioDefault2">--%>
<%--                                                                                Nữ--%>
<%--                                                                            </label>--%>
<%--                                                                        </div>--%>
<%--                                                                    </div>--%>
<%--                                                                </div>--%>
<%--                                                            </div>--%>
<%--                                                        </div>--%>
                                                        <div class="col-md-12">
                                                            <div style="text-align: center">
                                                                <button type="submit" class="btn btn-primary mr-2"
                                                                        id="btkh" onclick="return checkhkh()">
                                                                    Đăng ký
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<script type="text/javascript">
    function kt(){
        var email = document.getElementById("email");
        var passWord = document.getElementById("passWord");
        var sdt = document.getElementById("sdt");
        if (email.style.length == 0 || passWord.style.length == 0 || sdt.style.length == 0){
            alert("Vui long ko de trong");
            email.style.border = "1px solid red";
            email.style.background = "yellow";
            passWord.style.border = "1px solid red";
            passWord.style.background = "yellow";
            sdt.style.border = "1px solid red";
            sdt.style.background = "yellow";
            return false;
        }else {
            email.style.border = "none";
            email.style.background = "white";
            passWord.style.border = "none";
            passWord.style.background = "white";
            sdt.style.border = "none";
            sdt.style.background = "white";
        }
        if (email.style.length != 0 & passWord.style.length != 0 & sdt.style.length != 0){
            alert("Thanh cong");
            return true;
        }
    }
</script>
<script src="../../../vendor/global/global.min.js"></script>
<script src="../../../js/quixnav-init.js"></script>
<script src="../../../js/custom.min.js"></script>


<!-- Vectormap -->
<script src="../vendor/raphael/raphael.min.js"></script>
<%--    <script src="./vendor/morris/morris.min.js"></script>--%>


<script src="../../../vendor/circle-progress/circle-progress.min.js"></script>
<script src="../../../vendor/chart.js/Chart.bundle.min.js"></script>

<script src="../../../vendor/gaugeJS/dist/gauge.min.js"></script>

<!--  flot-chart js -->
<script src="../../../vendor/flot/jquery.flot.js"></script>
<script src="../../../vendor/flot/jquery.flot.resize.js"></script>

<!-- Owl Carousel -->
<script src="../../../vendor/owl-carousel/js/owl.carousel.min.js"></script>

<!-- Counter Up -->
<script src="../../../vendor/jqvmap/js/jquery.vmap.min.js"></script>
<script src="../../../vendor/jqvmap/js/jquery.vmap.usa.js"></script>
<script src="../../../vendor/jquery.counterup/jquery.counterup.min.js"></script>

<!-- Data table -->
<script src="../../../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../../js/plugins-init/datatables.init.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>
<script src="../../../js/select-2.js"></script>
</body>
</html>
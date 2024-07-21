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
    <title>King Shop</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            background-color: #bfdbf8;
        }
        .vh-100 {
            min-height: 100vh;
        }
        .card {
            border-radius: 1rem;
        }
        .form-outline {
            margin-bottom: 1.5rem;
        }
        .form-label {
            font-weight: bold;
        }
        .form-check-input {
            margin-right: 0.5rem;
        }
        .form-check-label {
            font-weight: normal;
        }
        .btn-dark {
            padding-left: 2.5rem;
            padding-right: 2.5rem;
        }
        .text-danger {
            font-size: 0.875rem;
        }
        .modal-content .swal2-icon {
            display: block;
        }
        .modal-content h4 {
            color: #10ae05;
            margin: 10px;
            text-align: center;
        }
        .modal-content button {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<c:if test="${thongBaoThanhCong != null}">
    <div id="modalSuccess" class="modal fade">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-12">
                            <div class="swal2-icon swal2-success swal2-animate-success-icon">
                                <div class="swal2-success-circular-line-left" style="background: rgb(255, 255, 255);"></div>
                                <span class="swal2-success-line-tip swal2-animate-success-line-tip"></span>
                                <span class="swal2-success-line-long swal2-animate-success-line-long"></span>
                                <div class="swal2-success-ring"></div>
                                <div class="swal2-success-fix" style="background: rgb(255, 255, 255);"></div>
                                <div class="swal2-success-circular-line-right" style="background: rgb(255, 255, 255);"></div>
                            </div>
                            <h4>${thongBaoThanhCong}</h4>
                        </div>
                        <div class="col-12" style="text-align: center;">
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Xác nhận</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
                <div class="card">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block">
                            <img src="../../../Img/imagebaner.jpg"
                                 alt="login form"  style="width: 300px;height: 300px;margin-top:150px;margin-left: 55px" />
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">
                                <form action="/login-handle" method="post">
                                    <div class="d-flex align-items-center mb-3 pb-1">
                                        <span class="h1 fw-bold mb-0">Xin chào</span>
                                    </div>
                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Đăng nhập bằng tài khoản của bạn</h5>
                                    <div class="col-12">
                                        <label style="color: red; text-align: center;">${thongBao}</label>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="email">Tài khoản</label>
                                        <input type="text" id="email" name="email" class="form-control form-control-lg" value="${email}" />
                                        <span class="text-danger" id="usernameError"></span>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="password">Mật khẩu</label>
                                        <input type="password" id="password" name="password" class="form-control form-control-lg" value="${password}" />
                                        <span class="text-danger" id="passwordError"></span>
                                    </div>
                                    <div class="mb-4" style="text-align: center">
                                        <button class="btn btn-dark btn-lg btn-block" type="submit" >Đăng nhập</button>
                                        <div style="color: red;">${tb}</div>
                                    </div>
                                        <a class="small text-muted" href="/forgot-password" style="font-size: larger; color: #00A2FF;">Quên mật khẩu?</a>
                                    <hr><br>
                                    <p style="text-align: center">
                                        <a class="btn btn-outline-dark btn-lg btn-block" href="/register" style="font-size: larger; font-weight: bold;">Đăng ký tài khoản</a>
                                    </p>
                                    <div style="text-align: center">
                                        <a href="/oauth2/authorization/google" class="btn btn-outline-dark btn-lg btn-block" style="font-weight: bold;">
                                            <svg xmlns="http://www.w3.org/2000/svg" height="1.5em" viewBox="0 0 488 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M488 261.8C488 403.3 391.1 504 248 504 110.8 504 0 393.2 0 256S110.8 8 248 8c66.8 0 123 24.5 166.3 64.9l-67.5 64.9C258.5 52.6 94.3 116.6 94.3 256c0 86.5 69.1 156.6 153.7 156.6 98.2 0 135-70.4 140.8-106.9H248v-85.3h236.1c2.3 12.7 3.9 24.9 3.9 41.4z"/></svg>
                                            Google
                                        </a>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script>
    function validate(){
        var un=document.getElementById("username").value;
        var pw=document.getElementById("password").value;
        var bt=document.getElementById("loginBtt");
        if (un.trim()===""){
            document.getElementById("usernameError").innerHTML="Tài khoản không được để trống";
            bt.type="button";
            return false;
        }else if (pw.trim()===""){
            document.getElementById("usernameError").innerHTML="";
            document.getElementById("passwordError").innerHTML="Mật khẩu không được để trống";
            bt.type="button";
            return false;
        }
        else{
            document.getElementById("passwordError").innerHTML="";
            bt.type="submit";
            return false;
        }
    }
</script>
<script>
    var thongBaoThanhCong = "${thongBaoThanhCong}";
    if (thongBaoThanhCong) {
        var modalSuccess = new bootstrap.Modal(document.getElementById('modalSuccess'), {});
        modalSuccess.show();
    }
</script>
</body>
</html>

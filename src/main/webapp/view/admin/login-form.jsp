<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/form.css"  type="text/css">

</head>
<body>
<section class="vh-100" style="background-color: #bfdbf8;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
                <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block">
                            <img src="../../upload/logo.jpg"
                                 alt="login form"  style="width: 350px;height: 350px;margin-top:150px;margin-left: 55px" />
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">

                                <form action="/login" method="post">

                                    <div class="d-flex align-items-center mb-3 pb-1">

                                        <span class="h1 fw-bold mb-0">Xin chào</span>
                                    </div>

                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Đăng nhập bằng tài khoản của bạn</h5>
                                    <div class="col-12">
                                        <label style="color:red;text-align: center">${thongBao}</label>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label">Tài khoản</label>
                                        <input
                                                type="text"
                                                class="auth-form__input"
                                                placeholder="Email"
                                                name="email"
                                                id=email"
                                        />

                                        <span class="text-danger" id="usernameError"></span>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <label class="form-label">Mật khẩu</label>
                                        <input
                                                type="password"
                                                class="auth-form__input"
                                                placeholder="Mật khẩu"
                                                name="passWord"
                                                id=passWord"
                                        />

                                        <span class="text-danger" id="passwordError"></span>
                                    </div>

                                    <div class="mb-4">

                                        <button class="btn btn-dark btn-lg btn-block" type="submit" id="loginBtt" onclick="validate()" value="Login">Đăng nhập</button>
                                        <div style="color: red">${tb}</div>
                                    </div>

                                    <a class="small text-muted" href="tai-khoan/quen-mat-khau"
                                       style="font-size: larger;color: #00A2FF">Quên
                                        mật khẩu?</a>
                                    <hr>
                                    <br>
                                    <p>
                                        <a type="button" class="btn btn-outline-dark btn-lg btn-block"
                                           style="font-size: larger; font-weight: bold" href="/tai-khoan/dang-ki">Đăng ký
                                            tài khoản</a>
                                            <%--                                        <button type="button"--%>
                                            <%--                                                data-bs-toggle="modal" class="btn btn-info"--%>
                                            <%--                                                data-bs-target="#dangKy" style="color: #393f81;">Đăng kí tài khoản--%>
                                            <%--                                        </button>--%>
                                    </p>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

    <div class="dang-nhap">
        <p>Bạn chưa có tài khoản?<a href="/tai-khoan/dang-ki">Đăng ký tài khoản</a></p>
    </div>

</div>
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
<!-- Js Plugins -->
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.nice-select.min.js"></script>
<script src="/js/jquery.nicescroll.min.js"></script>
<script src="/js/jquery.magnific-popup.min.js"></script>
<script src="/js/jquery.countdown.min.js"></script>
<script src="/js/jquery.slicknav.js"></script>
<script src="/js/mixitup.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/main.js"></script>

</body>
</html>
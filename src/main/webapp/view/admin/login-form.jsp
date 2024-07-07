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
<%--<form  >--%>
<%--    Tài khoản: <input type="text" name="email">--%>
<%--    Mật khẩu: <input type="password" name="passWord">--%>
<%--    <button type="submit" value="Login">Dang Nhap</button>--%>
<%--</form>--%>

<%--<a href="/tai-khoan/dang-ki">Đăng ký tài khoản</a>--%>
<%--&lt;%&ndash;<a href="/quen-mat-khau">Quen mat khau</a>&ndash;%&gt;--%>

<div class="container">
    <form action="/login" method="post" onsubmit="return kt()">


        <div class="auth-form">
            <div class="auth-form__container">
                <div class="auth-form__header">
                </div>
                <div class="auth-form__form">
                    <div class="auth-form__group">
                        <input
                                type="text"
                                class="auth-form__input"
                                placeholder="Email"
                                name="email"
                                id=email"
                        />
                    </div>
                    <div class="auth-form__group">
                        <input
                                type="password"
                                class="auth-form__input"
                                placeholder="Mật khẩu"
                                name="passWord"
                                id=passWord"
                        />
                    </div>
                </div>

                <div class="auth-form__controls">
                    <button class="auth-form__controls-btn btn--primary" type="submit" value="Login">ĐĂNG NHẬP</button>
                </div>
            </div>

        </div>
    </form>
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
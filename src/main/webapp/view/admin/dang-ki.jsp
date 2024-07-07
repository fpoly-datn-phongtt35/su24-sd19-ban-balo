<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sach Tai khoan</title>
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
<header>
    <h2 class="text-center">Thông tin đăng ký tài khoản</h2>
<%--    <div class="container-fluid">--%>
<%--        <div class="row justify-content-end">--%>
<%--            <div class="col-auto">--%>
<%--                <a href="/login">Đăng nhập</a> |--%>
<%--                <a href="#">Đăng ký</a>--%>
<%--                <a href="/cart" role="button" class="btn btn-primary">Giỏ hàng</a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
</header>
<body>
<div class="container">
    <form action="/tai-khoan/dang-ki/add" method="post" onsubmit="return kt()">
        <%--    <h6 class="text-center">Tài khoản</h6>--%>
        <%--    <input class="col-lg-6 col-md-6" type="text" value="" name="email">--%>
        <%--    <h6>Mật khẩu: <input type="password" name="passWord" value="" ></h6>--%>
        <%--    <h6> Số điện thoại: <input type="text" value="" name="sdt"></h6>--%>
        <%--    <button type="submit"value="update">Dang ki</button>--%>

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
                    <div class="auth-form__group">
                        <input
                                type="password"
                                class="auth-form__input"
                                placeholder="Số điện thoại"
                                name="sdt"
                                id=sdt"
                        />
                    </div>
                </div>

                <div class="auth-form__controls">
                    <button class="auth-form__controls-btn btn--primary" >ĐĂNG KÝ</button>
                </div>
            </div>

        </div>
    </form>
    <div class="dang-nhap">
        <p>Bạn đã có tài khoản?<a href="/login" class="btn-light">Đăng nhập</a></p>
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
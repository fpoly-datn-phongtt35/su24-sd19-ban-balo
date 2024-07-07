<%@ page import="com.example.datntest.entity.Users" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form và Table</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="/assets/css/trangchu.css"  type="text/css">

    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/css/style.css" type="text/css">

</head>
<body>
<%--Trên--%>
<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
        Xin chào ${user.idKhachHang}
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
        <li><a class="dropdown-item" href="/api/diachi">Thông tin tài khoản</a></li>
        <li><a class="dropdown-item" href="/login/logout">Đăng xuất</a></li>
    </ul>
</div>



<%--<div class="acount-header">--%>
<%--    <div>--%>

<%--    </div>--%>
<%--</div>--%>
<%--&lt;%&ndash;Trái&ndash;%&gt;--%>
<%--<div class="block-content">--%>
<%--    <ul id="myAccleftNav">--%>
<%--        <li>--%>
<%--            <a href="/tai-khoan/thong-tin" class="active">Thông tin</a>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <a href="/tai-khoan/hang-thanh-vien">Hạng thành viên</a>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <a href="/tai-khoan/don-hang">Đơn hàng</a>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <a href="/tai-khoan/ma-giam-gia">Mã giảm giá</a>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <a href="/tai-khoan/san-pham-yeu-thich">Sản phẩm yêu thích</a>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <a href="/tai-khoan/dia-chi">Địa chỉ</a>--%>
<%--        </li>--%>
<%--        <li class="last">--%>
<%--            <a title="Quay về trang chủ" href="/">Quay về trang chủ</a>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</div>--%>
<%--&lt;%&ndash;Phải&ndash;%&gt;--%>
<%--<div class="account-content">--%>
<%--    <app-profile>--%>
<%--        <h2 class="sub-title">Thông tin tài khoản</h2>--%>
<%--        <div class="my-account">--%>
<%--            <div class="user-view-box">--%>
<%--                <div class="info-box">--%>
<%--                    <div class="account-gr">--%>
<%--                        <div class="customer-left">--%>
<%--                             Họ--%>
<%--                            <i class="required">*</i>--%>
<%--                        </div>--%>
<%--                        <div class="customer-right">--%>
<%--                            <input type="text" class="v-input ng-untouched ng-pristine ng-valid">--%>
<%--                            <!---->--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="account-gr">--%>
<%--                        <div class="customer-left">--%>
<%--                            Tên--%>
<%--                            <i class="required">*</i>--%>
<%--                        </div>--%>
<%--                        <div class="customer-right">--%>
<%--                            <input type="text" class="v-input ng-pristine ng-valid ng-touched">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="account-gr">--%>
<%--                        <div class="customer-left">--%>
<%--                             Số điện thoại--%>
<%--                            <i class="required">*</i>--%>
<%--                        </div>--%>
<%--                        <div class="customer-right">--%>
<%--                            <input type="text" class="v-input ng-untouched ng-pristine ng-valid">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="account-gr">--%>
<%--                        <div class="customer-left">--%>
<%--                            Địa chỉ--%>
<%--                        </div>--%>
<%--                        <div class="customer-right">--%>
<%--                            <input type="text" class="v-input ng-untouched ng-pristine ng-valid">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="account-gr">--%>
<%--                        <div class="customer-left">--%>
<%--                             Ngày sinh--%>
<%--                            <i class="required">*</i>--%>
<%--                        </div>--%>
<%--                        <div class="customer-right">--%>
<%--                            <input type="date" class="v-input ng-untouched ng-pristine ng-valid">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </app-profile>--%>
<%--</div>--%>
</body>
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
</html>

<%@ page import="com.example.datntest.entity.SanPham" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script src="/js/checkbox.js"></script>

    <title>Document</title>
</head>

<body>
<div class="container">
    <div id="sanpham-list">
        <div class="row">

            <form class="col-lg-3"  id="checkboxForm" action="/sanpham/hien-thi" method="get">

                <h5 class="m-3 mt-5">Tên Sản Phẩm</h5>
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Nhập tên sản phẩm" name="tenSanPham">
                    <button class="btn btn-outline-secondary" type="submit">Tìm kiếm</button>
                </div>
                <br>
                <h5 class="m-3 mt-5">Giá Sản Phẩm</h5>
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Giá từ" name="giaTu">
                    <input type="text" class="form-control" placeholder="Giá đến" name="giaDen">
                    <button class="btn btn-outline-secondary" type="submit">Tìm kiếm</button>
                </div>
                <br>
                <h5 class="m-3 mt-5">Chất Liệu Sản Phẩm</h5>
                <c:forEach var="chatLieu" items="${lstCL}">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="tenChatLieu" value="${chatLieu.tenChatLieu}">
                        <label class="form-check-label">${chatLieu.tenChatLieu}</label>
                    </div>
                </c:forEach>
                <button class="btn btn-primary"><a class="btn btn-primary" href="/sanpham/view-add">ADD</a></button>
            </form>

            <div class="col-lg-9">
                <h2 class="mt-5">Danh Sách Sản Phẩm</h2>
                <div class="row">
                    <c:forEach var="sanpham" items="${list.content}">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="/img/banner/banner-3.jpg" alt=""></a>

                            <%--                                <img src="${product.imageUrl}" class="card-img-top" alt="${product.name}">--%>
                                <div class="card-body">
                                    <h5 class="card-title">${sanpham.tenSanPham}</h5>
                                    <p class="card-text">${sanpham.trangThai}</p>
                                    <p class="card-text">$${sanpham.giaNhap}</p>
                                    <a href="/sanpham/updateForm/${sanpham.idSanPham}" class="btn btn-primary">Xem Chi Tiết</a>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
<%--        div row tổng--%>
    </div>
<%--    div sanpham-list--%>
</div>
<%--div container--%>
</body>

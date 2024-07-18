<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
    <title>Document</title>
</head>
<body>
<h1 class="text-center" style="padding-bottom: 50px">sanpham</h1>
<form action="/sanpham/add" method="post" onsubmit="return kt()">
    <table class="table">
        <div class="col-mt-3">

            <div class="col-6">
                <label>anh</label>
                <select name="idAnh">
                    <c:forEach items="${lstA}" var="i">
                        <option value="${i.idAnh}">
                                ${i.idAnh}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-6">
                <label>idChatLieu</label>
                <select name="idChatLieu">
                    <c:forEach items="${lstCL}" var="i">
                        <option value="${i.idChatLieu}">
                                ${i.idChatLieu}
                        </option>
                    </c:forEach>
                </select>
            </div>

    <div class="col-6">
        <label>idDongSanPham</label>
        <select name="idDongSanPham">
            <c:forEach items="${lstDSP}" var="i">
                <option value="${i.idDongSanPham}">
                        ${i.idDongSanPham}
                </option>
            </c:forEach>
        </select>
    </div>

    <div class="col-6">
        <label>idNSX</label>
        <select name="idNSX">
            <c:forEach items="${lstNSX}" var="i">
                <option value="${i.idNSX}">
                        ${i.idNSX}
                </option>
            </c:forEach>
        </select>
    </div>

        <label>idHang</label>
        <select name="idHang">
            <c:forEach items="${lstH}" var="i">
                <option value="${i.idHang}">
                        ${i.idHang}
                </option>
            </c:forEach>
        </select>
    </div>


            <div class="col-6">
                <label>maSanPham</label>
                <input type="text" name="maSanPham" id="maSanPham" class="form-control">
            </div>
            <div class="col-6">
                <label>tenSanPham</label>
                <input type="text" name="tenSanPham" id="tenSanPham" class="form-control">
            </div>


            <div class="col-6">
                <label>chieuDai</label>
                <input type="text" name="chieuDai" id="chieuDai" class="form-control">
            </div>

            <div class="col-6">
                <label>chieuRong</label>
                <input type="text" name="chieuRong" id="chieuRong" class="form-control">
            </div>

            <div class="col-6">
                <label>chieuCao</label>
                <input type="text" name="chieuCao" id="chieuCao" class="form-control">
            </div>

            <div class="col-6">
                <label>trongLuong</label>
                <input type="text" name="trongLuong" id="trongLuong" class="form-control">
            </div>

            <div class="col-6">
                <label>trongLuongToiDa</label>
                <input type="text" name="trongLuongToiDa" id="trongLuongToiDa" class="form-control">
            </div>

            <div class="col-6">
                <label>giaNhap</label>
                <input type="text" name="giaNhap" id="giaNhap" class="form-control">
            </div>

            <div class="col-6">
                <label>ngayTao</label>
                <input type="date" name="ngayTao" id="ngayTao" class="form-control" />
            </div>
            <div class="col-6">
                <label>ngaySua</label>
                <input type="date" name="ngaySua" id="ngaySua" class="form-control" />
            </div>
            <div class="col-6">
                <label>trangThai</label>
                <input type="text" name="trangThai" id="trangThai" class="form-control" />
            </div>
            <button class="btn btn-primary" type="submit" onclick="return confirm('Bạn có muốn thêm không ???')">ADD</button>
        </div>
    </table>
</form>
</body>
</html>
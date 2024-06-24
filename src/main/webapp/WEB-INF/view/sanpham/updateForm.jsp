<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<form action="/sanpham/update/${sanpham.idSanPham}" class="container" method="post" onsubmit="return kt()">
    <table>
        <div class="col-mt-3">

            <div class="col-6">
                <label>idChatLieu</label>
                <input type="text" name="idChatLieu" id="idChatLieu" class="form-control"  value="${sanpham.idChatLieu.idChatLieu}" >
            </div>
            <div class="col-6">
                <label>idDongSanPham</label>
                <input type="text" name="idDongSanPham" id="idDongSanPham" class="form-control"  value="${sanpham.idDongSanPham.idDongSanPham}" >
            </div>
            <div class="col-6">
                <label>idNSX</label>
                <input type="text" name="idNSX" id="idNSX" class="form-control"  value="${sanpham.idNSX.idNSX}" >
            </div>

            <div class="col-6">
                <label>idHang</label>
                <input type="text" name="idHang" id="idHang" class="form-control"  value="${sanpham.idHang.idHang}" >
            </div>

            <div class="col-6">
                <label>maSanPham</label>
                <input type="text" name="maSanPham" id="maSanPham" class="form-control"  value="${sanpham.maSanPham}" >
            </div>

            <div class="col-6">
                <label>tenSanPham</label>
                <input type="text" name="tenSanPham" id="tenSanPham" class="form-control"  value="${sanpham.tenSanPham}" >
            </div>


            <div class="col-6">
                <label>chieuDai</label>
                <input type="text" name="chieuDai" id="chieuDai" class="form-control"  value="${sanpham.chieuDai}" >
            </div>
            <div class="col-6">
                <label>chieuRong</label>
                <input type="text" name="chieuRong" id="chieuRong" class="form-control"  value="${sanpham.chieuRong}" >
            </div>
            <div class="col-6">
                <label>chieuCao</label>
                <input type="text" name="chieuCao" id="chieuCao" class="form-control"  value="${sanpham.chieuCao}" >
            </div>
            <div class="col-6">
                <label>trongLuong</label>
                <input type="text" name="trongLuong" id="trongLuong" class="form-control"  value="${sanpham.trongLuong}" >
            </div>
            <div class="col-6">
                <label>trongLuongToiDa</label>
                <input type="text" name="trongLuongToiDa" id="trongLuongToiDa" class="form-control"  value="${sanpham.trongLuongToiDa}" >
            </div>
            <div class="col-6">
                <label>giaNhap</label>
                <input type="text" name="giaNhap" id="giaNhap" class="form-control"  value="${sanpham.giaNhap}" >
            </div>
            <div class="col-6">
                <label>soLuongTon</label>
                <input type="text" name="soLuongTon" id="soLuongTon" class="form-control"  value="${sanpham.soLuongTon}" >
            </div>

            <div class="col-6">
                <label>ngayTao</label>
                <input type="date" name="ngayTao" id="ngayTao" class="form-control"
                       value="<fmt:formatDate pattern='yyyy-MM-dd' value='${sanpham.ngayTao}'/>">
            </div>
            <div class="col-6">
                <label>ngaySua</label>
                <input type="date" name="ngaySua" id="ngaySua" class="form-control"
                       value="<fmt:formatDate pattern='yyyy-MM-dd' value='${sanpham.ngaySua}'/>">
            </div>
            <div class="col-6">
                <label>trangThai</label>
                <input type="text" name="trangThai" id="trangThai" class="form-control"   value="${sanpham.trangThai}" />
            </div>
            <button class="btn btn-primary" type="submit" >update</button>
        </div>
    </table>
</form>
</body>
</html>
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
    <table>
        <div class="col-mt-3">

            <div class="col-6">
                <label>idChatLieu</label>
                <input type="text" name="idChatLieu" id="idChatLieu" class="form-control">
            </div>

            <div class="col-6">
                <label>idDongSanPham</label>
                <input type="text" name="idDongSanPham" id="idDongSanPham" class="form-control">
            </div>

            <div class="col-6">
                <label>idNSX</label>
                <input type="text" name="idNSX" id="idNSX" class="form-control">
            </div>

            <div class="col-6">
                <label>idHang</label>
                <input type="text" name="idHang" id="idHang" class="form-control">
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
                <label>soLuongTon</label>
                <input type="text" name="soLuongTon" id="soLuongTon" class="form-control">
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
            <button class="btn btn-primary" type="submit" >ADD</button>
        </div>
    </table>
</form>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, users-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<form action="/khach-hang/add" method="post" >
    <table>
        <div class="col-mt-3">
            <div class="col-3">
                <label>Ma Khach Hang</label>
                <input type="text" name="maKhachHang" id="maKhachHang" class="form-control">
            </div>
            <div class="col-3">
                <label>Ten Khach Hang</label>
                <input type="text" name="tenKhachHang" id="tenKhachHang" class="form-control">
            </div>
            <div class="col-3">
                <label>Ho Khach Hang</label>
                <input type="text" name="hoKhachHang" id="hoKhachHang" class="form-control">
            </div>
            <div class="col-3">
                <label>Ngay Sinh</label>
                <input type="date" name="ngaySinh" id="ngaySinh" class="form-control">
            </div>
            <div class="col-3">
                <label>Gioi Tinh</label>
                <input type="text" name="gioiTinh" id="gioiTinh" class="form-control">
            </div>
            <div class="col-3">
                <label>SDT</label>
                <input type="text" name="sdt" id="sdt" class="form-control">
            </div>
            <div class="col-3">
                <label>CCCD</label>
                <input type="text" name="cccd" id="cccd" class="form-control">
            </div>

            <div class="col-3">
                <label>Hang Khach Hang</label>

                <input type="text" name="idHangKhachHang" id="idHangKhachHang" class="form-control">
                </select>
            </div>
            <div class="col-3">
                <label>Diem Tich Luy</label>
                <input type="text" name="diemTichLuy" id="diemTichLuy" class="form-control">
            </div>
            <div class="col-3">
                <label>Ngay Tao</label>
                <input type="date" name="ngayTao" id="ngayTao" class="form-control">
            </div>
            <div class="col-3">
                <label>Ngay Sua</label>
                <input type="date" name="ngaySua" id="ngaySua" class="form-control">
            </div>
            <div class="col-3">
                <label>Trang Thai</label>
                <input type="text" name="trangThai" id="trangThai" class="form-control">
            </div>
            <button type="submit">Xac Nhan</button>
        </div>
    </table>
</form>
</body>
</html>
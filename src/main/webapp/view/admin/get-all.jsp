<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>Danh sach khach hang</h1>

<table class="table table-secondary">
    <tr>
        <th>Ma Khach Hang</th>
        <th>Ten Khach Hang</th>
        <th>Ho Khach Hang</th>
        <th>Ngay Sinh</th>
        <th>Gioi Tinh</th>
        <th>SDT</th>
        <th>CCCD</th>
        <th>Hang Khach Hang</th>
        <th>So Nha</th>
        <th>Phuong Xa</th>
        <th>Quan Huyen</th>
        <th>Tinh Thanh Pho</th>
        <th>Diem Tich Luy</th>
        <th>Ngay Tao</th>
        <th>Ngay Sua</th>
        <th>Trang Thai</th>
        <th>Thao Tac</th>
    </tr>
    <tbody>
    <c:forEach var="kh" items="${list.content}">
        <tr>
            <td>${kh.maKhachHang}</td>
            <td>${kh.tenKhachHang}</td>
            <td>${kh.hoKhachHang}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.gioiTinh}</td>
            <td>${kh.sdt}</td>
            <td>${kh.cccd}</td>
            <td>${kh.hangKhachHang.tenHangKhachHang}</td>
            <td>${kh.soNha}</td>
            <td>${kh.phuongXa}</td>
            <td>${kh.quanHuyen}</td>
            <td>${kh.tinhThanhPho}</td>
            <td>${kh.diemTichLuy}</td>
            <td>${kh.ngayTao}</td>
            <td>${kh.ngaySua}</td>
            <td>${kh.trangThai}</td>
            <td>
                <a href="/khach-hang/view-add">ADD</a>
                <a href="/khach-hang/delete/${kh.idKhachHang}">DELETE</a>
                <a href="/khach-hang/view-update/${kh.idKhachHang}">DETAIL</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
    <nav class="container">
        <ul class="negation">
            <c:forEach begin="0" end="${totalPages + 1}" varStatus="loop">
                <li><a href="/khach-hang/get-all?page=${loop.index}">${loop.index + 1}</a></li>
            </c:forEach>
        </ul>
    </nav>
</table>
</body>
</html>
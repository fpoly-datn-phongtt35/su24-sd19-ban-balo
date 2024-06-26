<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<main>
    <header><h2>CHỨC VỤ</h2></header>
    <form action="/chuc-vu/add" method="post" class="all-classes-container">
        Ma <input type="text" name="maChucVu" value="${cv.maChucVu}"/><br>
        Tên <input type="text" name="tenChucVu" value="${cv.tenChucVu}"/><br>
        Ngay Tao <input type="date" name="ngayTao" value="${cv.ngayTao}"/><br>
        Ngay Sửa <input type="date" name="ngaySua" value="${cv.ngaySua}"/><br>
        Trang Thai
        <input type="radio" name="trangThai" value="1" ${cv.trangThai == 1 ? "checked" : ""}/>Hoat dong
        <input type="radio" name="trangThai" value="2" ${cv.trangThai == 2 ? "checked" : ""} />Ngung hoat dong
        <br>
        <button type="submit" class="btn btn-secondary">ADD</button>
        <a href="/chuc-vu/hien-thi" type="button" class="btn btn-danger">Hien Thi</a>

    </form>
    <hr>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col" type="hidden">Id</th>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Ngày Tạo</th>
                <th scope="col">Ngày Sửa</th>
                <th scope="col">Trạng thái</th>
                <th scope="col">Khác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cv" items="${ListCV}">
                <tr>
                    <th scope="row" type="hidden">${cv.id}</th>
                    <td>${cv.maChucVu}</td>
                    <td>${cv.tenChucVu}</td>
                    <td>${cv.ngayTao}</td>
                    <td>${cv.ngaySua}</td>
                    <td>${cv.trangThai == 1 ? 'hoat dong':'ngung hoat dong'}</td>

                    <td>
                        <a href="/chuc-vu/view-update/${cv.id}" type="button" class="btn btn-success">Update</a>
                        <a href="/chuc-vu/remove/${cv.id}" type="button" class="btn btn-warning" >Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</main>

</body>
</html>
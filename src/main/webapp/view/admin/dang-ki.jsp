<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sach Tai khoan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form action="/tai-khoan/dang-ki/add" method="post">
    Tài khoản: <input type="text" value="" name="taiKhoan">
    Mật khẩu: <input type="password" name="matKhau" value="" >
    Số điện thoại: <input type="text" value="" name="sdt">
    <button type="submit"value="update">Dang ki</button>
</form>
</body>
</html>
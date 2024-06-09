<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
<%--    <script>--%>
<%--        function search() {--%>
<%--            var search = document.getElementById("tenKhachHang").value;--%>
<%--            window.location.href = "${pageContext.request.contextPath}/khach-hang/search?tenKhachHang=" + search;--%>
<%--        }--%>
<%--    </script>--%>
</head>
<body>
<h1>Tìm kiếm</h1>
<c:if test="${not empty list.content}">
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
                <td><fmt:formatDate pattern='yyyy-MM-dd' value='${kh.ngaySinh}'/></td>
                <td>${kh.gioiTinh } </td>
                <td>${kh.sdt}</td>
                <td>${kh.cccd}</td>
                <td>${kh.hangKhachHang.tenHangKhachHang}</td>
                <td>${kh.soNha}</td>
                <td>${kh.phuongXa}</td>
                <td>${kh.quanHuyen}</td>
                <td>${kh.tinhThanhPho}</td>
                <td>${kh.diemTichLuy}</td>
                <td><fmt:formatDate pattern='yyyy-MM-dd' value='${kh.ngayTao}'/></td>
                <td><fmt:formatDate pattern='yyyy-MM-dd' value='${kh.ngaySua}'/></td>
                <td>${kh.trangThai}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<input type="text" id="tenKhachHang" name="tenKhachHang" oninput="search()">
</body>
</html>

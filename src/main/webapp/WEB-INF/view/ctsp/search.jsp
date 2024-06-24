<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Kết quả tìm kiếm</title>
</head>
<body>
<h1>Sản Phẩm Bạn Muốn Tìm</h1>
<c:if test="${not empty list.content}">
    <table class="table table-secondary">
        <thead>
        <tr>
            <th>idSanPham</th>
            <th>idMauSac</th>
            <th>anh</th>
            <th>moTa</th>
            <th>giaBan</th>
            <th>ghiChu</th>
            <th>TrangThai</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ctsp" items="${list.content}">
            <tr>
                <td><c:out value="${ctsp.idSanPham.tenSanPham}" /></td>
                <td><c:out value="${ctsp.idMauSac.tenMauSac}" /></td>
                <td><c:out value="${ctsp.idAnh.idAnh}" /></td>
                <td><c:out value="${ctsp.moTa}" /></td>
                <td><fmt:formatNumber value="${ctsp.giaBan}" type="currency"/></td>
                <td><c:out value="${ctsp.ghiChu}" /></td>
                <td><c:out value="${ctsp.trangThai}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</c:if>
<c:if test="${empty list.content}">
    <h3>Không có giá của bạn mong muốn.</h3>
</c:if>

<button class="btn btn-primary"><a class="btn btn-primary" href="/ctsp/hien-thi">Trang chu</a></button>

</body>
</html>

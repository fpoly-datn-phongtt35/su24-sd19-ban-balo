<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXgs9ECoxswJoFf9V2tyk97i7Sbm"
          crossorigin="anonymous">
    <title>Search CTSP</title>
</head>
<body>
<div class="container">
    <h1>Search CTSP</h1>
    <form action="/ctsp/search-by-price-range" method="get">
        <div class="mb-3">
            <label for="minGiaBan" class="form-label">Minimum Price</label>
            <input type="number" step="0.01" class="form-control" id="minGiaBan" name="minGiaBan" required>
        </div>
        <div class="mb-3">
            <label for="maxGiaBan" class="form-label">Maximum Price</label>
            <input type="number" step="0.01" class="form-control" id="maxGiaBan" name="maxGiaBan" required>
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <hr>
    <h2>Search Results</h2>
    <c:if test="${not empty list.content}">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>San Pham</th>
                <th>Mau Sac</th>
                <th>Anh</th>
                <th>Mo Ta</th>
                <th>Gia Ban</th>
                <th>Nguoi Tao</th>
                <th>Nguoi Sua</th>
                <th>Ngay Tao</th>
                <th>Ngay Sua</th>
                <th>Ghi Chu</th>
                <th>Trang Thai</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="ctsp" items="${list.content}">
                <tr>
                    <td>${ctsp.idCTSP}</td>
                    <td>${ctsp.idSanPham.tenSanPham}</td>
                    <td>${ctsp.idMauSac.tenMauSac}</td>
                    <td><img src="${ctsp.idAnh.url}" alt="Anh" width="50"></td>
                    <td>${ctsp.moTa}</td>
                    <td><fmt:formatNumber value="${ctsp.giaBan}" type="currency"/></td>
                    <td>${ctsp.nguoiTao.ten}</td>
                    <td>${ctsp.nguoiSua.ten}</td>
                    <td><fmt:formatDate value="${ctsp.ngayTao}" pattern="yyyy-MM-dd"/></td>
                    <td><fmt:formatDate value="${ctsp.ngaySua}" pattern="yyyy-MM-dd"/></td>
                    <td>${ctsp.ghiChu}</td>
                    <td>${ctsp.trangThai}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-center">
            <c:if test="${list.totalPages > 1}">
                <nav>
                    <ul class="pagination">
                        <c:forEach var="i" begin="0" end="${list.totalPages - 1}">
                            <li class="page-item ${i == list.number ? 'active' : ''}">
                                <a class="page-link" href="?page=${i}&minGiaBan=${param.minGiaBan}&maxGiaBan=${param.maxGiaBan}">${i + 1}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>
            </c:if>
        </div>
    </c:if>
    <c:if test="${empty list.content}">
        <p>No results found.</p>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-t5ojHjL7Ysh58rsjZPQRoFq5u2Qc1Z2lnIMrPtbCJlG8Mjp2QouQYrR+sqM2AoH8"
        crossorigin="anonymous"></script>
</body>
</html>

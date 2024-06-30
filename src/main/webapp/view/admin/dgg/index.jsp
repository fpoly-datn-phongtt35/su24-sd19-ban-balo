<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>

<body>
<a href="create">
    <button>Tao moi</button>

</a>
<table  class="table table-dark table-striped">
    <thead>
    <td >ID</td>
    <td>Ma</td>
    <td>Ten</td>
    <td>Gia tri giam</td>
    <td>Gia tri giam toi da</td>
    <td>Dieu kien</td>
    <td>Ngay tao</td>
    <td>Nguoi Tao</td>
    <td>Trang Thai</td>
    <td>Action</td>
    </thead>
    <c:forEach var="i" items="${page.content}">
        <tr>
            <td>${i.id}</td>
            <td>${i.ma}</td>
            <td>${i.ten}</td>
            <td>${i.giaTriDotGiamGia}</td>
            <td>${i.giamToiDa}</td>
            <td>${i.dieuKien}</td>



            <td>
                <c:set var="beginday" value="${i.beginday}" />
                <fmt:formatDate pattern="yyyy-MM-dd" value="${i.beginday}" />
            </td>

            <td>${i.nguoiTao.idUsers}</td>
            <td>
                <c:if test="${i.trangthai==1}">Con hang</c:if>
                <c:if test="${i.trangthai==2}">Het hang</c:if>
            </td>

            <td>
                <a href="/dgg/edit/${i.id}">
                    <button>Edit</button>
                </a>
                <a href="/dgg/delete/${i.id}">
                    <button>delete</button>
                </a>
            </td>

        </tr>
    </c:forEach>

</table>

<div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/dgg/index?page=${page.number - 1}">Trước</a></li>
            <li class="page-item"><a class="page-link" href="#">${list.number}</a></li>
            <li class="page-item"><a class="page-link" href="/dgg/index?page=${page.number + 1}">Sau</a></li>
        </ul>
    </nav>


</div>
</body>

</html>
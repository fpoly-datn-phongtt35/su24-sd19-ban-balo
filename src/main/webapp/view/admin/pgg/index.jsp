<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head></head>

<body>
<a href="create">
    <button>Tao moi</button>
</a>
<table>
    <thead>
    <td>ID</td>
    <td>Ma</td>
    <td>Ten</td>
    <td>MucDo</td>
    <td>Nguoi Tao</td>
    <td>Trang Thai</td>
    <td>Action</td>
    </thead>
    <c:forEach var="i" items="${page.content}">
        <tr>
            <td>${i.id}</td>
            <td>${i.ma}</td>
            <td>${i.ten}</td>
            <td>${i.mucDo}</td>
            <td>${i.nguoiTao.idChucVu.tenChucVu}</td>
            <td>
                <c:if test="${i.trangthai==1}">Con hang</c:if>
                <c:if test="${i.trangthai==0}">Het hang</c:if>
            </td>

            <td>
                <a href="/pgg/edit/${i.id}">
                    <button>Edit</button>
                </a>
                <a href="/pgg/delete/${i.id}">
                    <button>delete</button>
                </a>
            </td>

        </tr>
    </c:forEach>

</table>

<div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">

            <li class="page-item">

                <a class="page-link"
                        <c:if test="${page.number==0}">
                            page.number=1
                        </c:if>
                   href="/pgg/index?page=${page.number - 1}"
                >
                    Previous
                </a>
            </li>

            <%--            </c:if>--%>
            <li class="page-item"><a class="page-link disabled" href="#">${page.number}</a></li>
            <li class="page-item"><a class="page-link" href="/pgg/index?page=${page.number + 1}">Next</a></li>
        </ul>
    </nav>

</div>
</body>

</html>
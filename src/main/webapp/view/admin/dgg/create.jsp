<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
<sf:form action="/pgg/store" method="POST" modelAttribute="data">
    <div>
        <label>Mã</label>
        <sf:input name="ma" type="text" path="ma" />
        <sf:errors path="ma" cssStyle="color: red" />
    </div>
    <div>
        <label>Tên</label>
        <sf:input name="ten" type="text" path="ten" />
        <sf:errors path="ten" cssStyle="color: red" />
    </div>

    <div>
        <label>NgayBatDau</label>
        <sf:input  name="beginday" type="date" path="beginday" />
        <sf:errors path="beginday" cssStyle="color: red" />
    </div>

    <div>
        <label>NgayKetThuc</label>
        <sf:input name="endday" type="date" path="endday" />
        <sf:errors path="endday" cssStyle="color: red" />
    </div>


    <div>
        <label>giamToiDa</label>
        <sf:input name="giamToiDa" type="text" path="giamToiDa" />
        <sf:errors path="giamToiDa" cssStyle="color: red" />
    </div>


    <div>
        <label>dieuKien</label>
        <sf:input name="dieuKien" type="text" path="dieuKien" />
        <sf:errors path="dieuKien" cssStyle="color: red" />
    </div>


    <div>
        <label>soLuong</label>
        <sf:input name="soLuong" type="text" path="soLuong" />
        <sf:errors path="soLuong" cssStyle="color: red" />
    </div>


    <div>
        <label>nguoiTao</label>

        <sf:select path="nguoiTao" cssClass="form-select">
            <c:forEach items="${lstNT}" var="i">
                <sf:option value="${i.idUsers}">${i.idUsers}</sf:option>
            </c:forEach>
        </sf:select>

        <sf:errors path="nguoiTao" cssStyle="color: red" />

    </div>


    <div>
        <label>nguoiSua</label>
        <sf:select path="nguoiSua" cssClass="form-select">
            <c:forEach items="${lstNT}" var="i">
                <sf:option value="${i.idUsers}">${i.idUsers}</sf:option>
            </c:forEach>
        </sf:select>

        <sf:errors path="nguoiSua" cssStyle="color: red" />
    </div>





    <%--    <div>--%>
<%--        <label>Con</label>--%>
<%--        <sf:input name="trangthai" type="radian" path="trangthai."  />--%>
<%--        <sf:errors path="ten" cssStyle="color: red" />--%>
<%--        --%>
<%--        <label>Con</label>--%>
<%--        <sf:input name="trangthai" type="radian" path="trangthai" />--%>
<%--        <sf:errors path="ten" cssStyle="color: red" />--%>
<%--    </div>--%>

    <div>
        <label>ngaySua</label>
        <sf:input name="ngaySua" type="date" path="ngaySua" />
        <sf:errors path="ngaySua" cssStyle="color: red" />
    </div>



    <div>
        <label>ngayTao</label>
        <sf:input name="ngayTao" type="date" path="ngayTao" />
        <sf:errors path="ngayTao" cssStyle="color: red" />
    </div>




    <div>
        <label>Con</label>
        <input type="radio" name="trangthai" value=1>
        <sf:errors path="trangthai" cssStyle="color: red" />

        <label>Het</label>
        <input type="radio" name="trangthai" value=2>
        <sf:errors path="trangthai" cssStyle="color: red" />


    </div>

    <div>
        <button>Submit</button>
    </div>
</sf:form>
</body>
</body>
</html>
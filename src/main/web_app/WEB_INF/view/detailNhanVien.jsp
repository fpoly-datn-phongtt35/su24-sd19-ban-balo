<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
</head>
<body>
<form:form modelAttribute="sp" method="post" action="/nhan-vien/update/${sp.id}">
    <div id="hai" class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="control-label col-sm-2">Mã:</label>
                    <div class="col-sm-10">
                        <form:input class="form-control" id="email" path="maNhanVien"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Tên:</label>
                    <div class="col-sm-10">
                        <form:input path="tenNhanVien" type="text" class="form-control"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Họ:</label>
                    <div class="col-sm-10">
                        <form:input path="hoNhanVien" type="text" class="form-control" id="pwd"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">SDT:</label>
                    <div class="col-sm-10">
                        <form:input path="sdt" type="text" class="form-control"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Giới tính:</label>
                    <div class="col-sm-10">
                        <p>Nam <input type="radio" name="gioiTinh"
                                      value="Nam" ${sp.gioiTinh=="Nam"?"checked":""} checked/>
                            Nữ <input type="radio" name="gioiTinh" value="Nu" ${sp.gioiTinh=="Nu"?"checked":""}>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="control-label col-sm-2">Ngày Sinh:</label>
                    <div class="col-sm-10">
                        <form:input path="ngaySinh" type="date" class="form-control"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">CCCD:</label>
                    <div class="col-sm-10">
                        <form:input path="cccd" type="text" class="form-control"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">CCCD:</label>
                    <div class="col-sm-10">
                        <form:input path="cccd" type="text" class="form-control"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Số Nhà:</label>
                    <div class="col-sm-10">
                        <form:input path="soNha" type="text" class="form-control"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Phường Xã:</label>
                    <div class="col-sm-10">
                        <form:input path="phuongXa" type="text" class="form-control"></form:input>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Quận Huyện:</label>
                <div class="col-sm-10">
                    <form:input path="quanHuyen" type="text" class="form-control"></form:input>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Thành Phố:</label>
            <div class="col-sm-10">
                <form:input path="tinhThanhPho" type="text" class="form-control"></form:input>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Ngày tạo:</label>
                <div class="col-sm-10">
                    <form:input path="ngayTao" type="date" class="form-control"></form:input>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Ngày Sửa:</label>
                <div class="col-sm-10">
                    <form:input path="ngaySua" type="date" class="form-control"></form:input>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2">Mật khẩu:</label>
                <div class="col-sm-10">
                    <form:input path="matKhau" type="text" class="form-control"></form:input>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2">Chức Vụ:</label>
                <div class="col-sm-10">
                    <c:set value="${sp.cv.ten}" var="tong3"></c:set>
                    <select name="cv" class="form-select">
                        <c:forEach var="h" items="${listSP}">
                            <c:set value="${h.cv.ten}" var="hai"></c:set>
                            <c:if test="${h.cv.ten ne null}">
                                <option value="${h.cv.id}" ${tong3 eq hai  ? "selected" : ""}>${h.cv.ten}</option>
                            </c:if>
                        </c:forEach>

                    </select>

                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Trạng Thái:</label>
                <div class="col-sm-10">
                    <p>Hoạt động <input type="radio" name="trangThai" value=0 ${sp.trangThai== 0 ?"checked":""}
                                        checked/>
                        Ngưng hoạt động <input type="radio" name="trangThai"
                                               value=1 ${sp.trangThai== 1 ?"checked":""}>
                    </p>
                </div>
            </div>
        </div>

    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10 pt-4">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </div>

    </form:form>

</body>
</html>
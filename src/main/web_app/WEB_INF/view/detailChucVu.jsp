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
<h2>Chức vụ</h2>
<form:form modelAttribute="sp" method="post" action="/chuc-vu/update/${sp.id}">
<div id ="hai" class="container">
    <div class="form-group">
        <label class="control-label col-sm-2" >Mã:</label>
        <div class="col-sm-10">
            <form:input  class="form-control" id="email" path="maChucVu"></form:input>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2">Tên Chức Vụ:</label>
        <div class="col-sm-10">
            <form:input path="tenChucVu" class="form-control" id="pwd"></form:input>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2">Ngày Sửa:</label>
        <div class="col-sm-10">
            <form:input path="ngaySua" type="date" class="form-control"></form:input>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2">Ngày Tạo:</label>
        <div class="col-sm-10">
            <form:input path="ngayTao" type="date" class="form-control"></form:input>
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
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10 pt-4">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </div>

    </form:form>

</div>

</body>
</html>
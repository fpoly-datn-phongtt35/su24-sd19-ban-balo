<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Địa chỉ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.1.0-beta.1/css/select2.min.css" rel="stylesheet"/>--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
<div class="container">
    <form:form method="post"  class="form-horizontal" action="/api/updateInfo" modelAttribute="diaChi">
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Họ: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="Ho" name="hoKhachHang" value="${kh.hoKhachHang}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Tên: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="ten" placeholder="Ten" name="tenKhachHang" value="${kh.tenKhachHang}">
            </div>
        </div>
<%--        <div class="form-group">--%>
<%--            <label class="control-label col-sm-2" for="email">Email:</label>--%>
<%--            <div class="col-sm-10">--%>
<%--                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <label class="control-label col-sm-2" for="phoneNumber">Số điện thoại:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="phoneNumber" placeholder="Enter phone number" name="sdt" value="${kh.sdt}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Địa chỉ:</label>
            <div class="col-sm-10">
                <select name="city" class="form-select form-check-inline mb-3" style="width: 30%" id="city" aria-label="Default select example">
                    <option value="" selected>Chọn tỉnh thành</option>
                    <!-- Thêm các tùy chọn khác ở đây -->
                </select>

                <select name="district" class="form-select form-check-inline mb-3" style="width: 30%" id="district" aria-label=".form-select-sm">
                    <option value="" selected>Chọn quận huyện</option>
                    <!-- Thêm các tùy chọn khác ở đây -->
                </select>

                <select name="ward" class="form-select form-check-inline" id="ward" style="width: 30%" aria-label=".form-select-sm">
                    <option value="" selected>Chọn phường xã</option>
                    <!-- Thêm các tùy chọn khác ở đây -->
                </select>

            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="dateOfBirth">Ngày sinh:</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="dateOfBirth" placeholder="Enter email" name="ngaySinh" value="${kh.ngaySinh}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Giới tính:</label>
            <div class="col-sm-10">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio1" value="1">
                    <label class="form-check-label" for="inlineRadio1">Nam</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio2" value="0">
                    <label class="form-check-label" for="inlineRadio2">Nữ</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio3" value="2">
                    <label class="form-check-label" for="inlineRadio3">Khác</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label><input type="checkbox" name="remember">Thay đổi mật khẩu</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" style="color: white;
    background: black;"> Cập nhật
                </button>
            </div>
        </div>
    </form:form>

</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script>
    var citis = document.getElementById("city");
    var districts = document.getElementById("district");
    var wards = document.getElementById("ward");
    var Parameter = {
        url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
        method: "GET",
        responseType: "application/json",
    };
    var promise = axios(Parameter);
    promise.then(function (result) {
        renderCity(result.data);
    });

    function renderCity(data) {
        for (const x of data) {
            var option = new Option(x.Name, x.Name); // Sử dụng tên làm giá trị
            option.setAttribute("data-id", x.Id); // Lưu ID vào thuộc tính data-id
            citis.options[citis.options.length] = option;
        }
        citis.onchange = function () {
            districts.length = 1;
            wards.length = 1;
            if (this.selectedOptions[0].getAttribute("data-id") != "") {
                const result = data.filter(n => n.Id === this.selectedOptions[0].getAttribute("data-id"));

                for (const k of result[0].Districts) {
                    var option = new Option(k.Name, k.Name); // Sử dụng tên làm giá trị
                    option.setAttribute("data-id", k.Id); // Lưu ID vào thuộc tính data-id
                    districts.options[districts.options.length] = option;
                }
            }
        };
        districts.onchange = function () {
            wards.length = 1;
            const dataCity = data.filter(n => n.Id === citis.selectedOptions[0].getAttribute("data-id"));
            if (this.selectedOptions[0].getAttribute("data-id") != "") {
                const dataWards = dataCity[0].Districts.filter(n => n.Id === this.selectedOptions[0].getAttribute("data-id"))[0].Wards;

                for (const w of dataWards) {
                    var option = new Option(w.Name, w.Name); // Sử dụng tên làm giá trị
                    option.setAttribute("data-id", w.Id); // Lưu ID vào thuộc tính data-id
                    wards.options[wards.options.length] = option;
                }
            }
        };
    }
</script>

</body>
</html>

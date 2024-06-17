<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chọn địa chỉ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<form>
    <label for="tinh">Tỉnh / Thành phố:</label>
    <select id="tinh" name="tinh">
        <option value="">Chọn Tỉnh / Thành phố</option>
        <c:if test="${not empty tinhList}">
            <c:forEach var="tinhList" items="${tinhList}">
                <option value="${tinhList.idTinh}">${tinhList.ten}</option>
            </c:forEach>
        </c:if>
    </select>

    <label for="quan">Quận / Huyện:</label>
    <select id="quan" name="quan" disabled>
        <option value="">Chọn Quận / Huyện</option>
    </select>

    <label for="phuong">Phường / Xã:</label>
    <select id="phuong" name="phuong" disabled>
        <option value="">Chọn Phường / Xã</option>
    </select>

    <label for="diachi">Địa chỉ:</label>
    <input type="text" id="diachi" name="diachi" placeholder="Số nhà, ngõ, ngách, thôn, xóm...">

    <input type="checkbox" id="default" name="default">
    <label for="default">Đặt làm địa chỉ mặc định</label>

    <button type="submit">Gửi</button>
</form>

<script>
    $(document).ready(function() {
        // Khi chọn Tỉnh
        $('#tinh').change(function() {
            var tinhIdTinh = $(this).val();
            if (tinhIdTinh) {
                $.ajax({
                    url: '/quan/' + tinhIdTinh,
                    type: 'GET',
                    success: function(data) {
                        $('#quan').empty().append('<option value="">Chọn Quận / Huyện</option>');
                        $('#phuong').empty().append('<option value="">Chọn Phường / Xã</option>');
                        $('#phuong').prop('disabled', true);
                        $.each(data, function(key, quan) {
                            $('#quan').append('<option value="' + quan.idQuan + '">' + quan.ten + '</option>');
                        });
                        $('#quan').prop('disabled', false);
                    }
                });
            } else {
                $('#quan').empty().append('<option value="">Chọn Quận / Huyện</option>').prop('disabled', true);
                $('#phuong').empty().append('<option value="">Chọn Phường / Xã</option>').prop('disabled', true);
            }
        });

        // Khi chọn Quận
        $('#quan').change(function() {
            var quanIdQuan = $(this).val();
            if (quanIdQuan) {
                $.ajax({
                    url: '/phuong/' + quanIdQuan,
                    type: 'GET',
                    success: function(data) {
                        $('#phuong').empty().append('<option value="">Chọn Phường / Xã</option>');
                        $.each(data, function(key, phuong) {
                            $('#phuong').append('<option value="' + phuong.idPhuong + '">' + phuong.ten + '</option>');
                        });
                        $('#phuong').prop('disabled', false);
                    }
                });
            } else {
                $('#phuong').empty().append('<option value="">Chọn Phường / Xã</option>').prop('disabled', true);
            }
        });
    });
</script>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<h1 class="text-center" style="padding-bottom: 50px">ctsp</h1>
<form action="/ctsp/update/${ctsp.idCTSP}" class="container" method="post" onsubmit="return kt()">
    <table>
        <div class="col-mt-3">
            <div class="col-6">
                <label>idSanPham</label>
                <input type="text" name="idSanPham" id="idSanPham" class="form-control"  value="${ctsp.idSanPham.idSanPham}" >
            </div>
            <div class="col-6">
                <label>idMauSac</label>
                <input type="text" name="idMauSac" id="idMauSac" class="form-control"  value="${ctsp.idMauSac.idMauSac}" >
            </div>

            <div class="col-6">
                <label>anh</label>
                <input type="text" name="idAnh" id="idAnh" class="form-control"  value="${ctsp.idAnh.idAnh}" >
            </div>
            <div class="col-6">
                <label>moTa</label>
                <input type="text" name="moTa" id="moTa" class="form-control"  value="${ctsp.moTa}" >
            </div>
            <div class="col-6">
                <label>giaBan</label>
                <input type="text" name="giaBan" id="giaBan" class="form-control"  value="${ctsp.giaBan}" >
            </div>
            <div class="col-6">
                <label>nguoiTao</label>
                <input type="text" name="nguoiTao" id="nguoiTao" class="form-control"  value="${ctsp.nguoiTao.idUsers}" >
            </div>

            <div class="col-6">
                <label>nguoiSua</label>
                <input type="text" name="nguoiSua" id="nguoiSua" class="form-control"  value="${ctsp.nguoiSua.idUsers}" >
            </div>

            <div class="col-6">
                <label>ngayTao</label>
                <input type="date" name="ngayTao" id="ngayTao" class="form-control"
                       value="<fmt:formatDate pattern='yyyy-MM-dd' value='${ctsp.ngayTao}'/>">
            </div>
            <div class="col-6">
                <label>ngaySua</label>
                <input type="date" name="ngaySua" id="ngaySua" class="form-control"
                       value="<fmt:formatDate pattern='yyyy-MM-dd' value='${ctsp.ngaySua}'/>">
            </div>
            <div class="col-6">
                <label>ghiChu</label>
                <input type="text" name="ghiChu" id="ghiChu" class="form-control"   value="${ctsp.ghiChu}" />
            </div>
            <div class="col-6">
                <label>trangThai</label>
                <input type="text" name="trangThai" id="trangThai" class="form-control"   value="${ctsp.trangThai}" />
            </div>
            <button class="btn btn-primary" type="submit" >update</button>
        </div>
    </table>
</form>
</body>
</html>
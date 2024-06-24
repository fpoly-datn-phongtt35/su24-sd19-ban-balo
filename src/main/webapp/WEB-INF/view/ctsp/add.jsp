<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
<h1 class="text-center" style="padding-bottom: 50px">CTSP</h1>
<form action="/ctsp/add" method="post" onsubmit="return kt()">
    <table>
        <div class="col-mt-3">

            <div class="col-6">
                <label>idSanPham</label>

                <select name="idSanPham">
                    <c:forEach items="${lstSP}" var="i">
                        <option value="${i.idSanPham}">
                                ${i.tenSanPham}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-6">
                <label>idMauSac</label>
                <select name="idMauSac">
                    <c:forEach items="${lstMS}" var="i">
                        <option value="${i.idMauSac}">
                                ${i.idMauSac}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-6">
                <label>anh</label>
                <select name="idAnh">
                    <c:forEach items="${lstA}" var="i">
                        <option value="${i.idAnh}">
                                ${i.idAnh}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-6">
                <label>moTa</label>
                <input type="text" name="moTa" id="moTa" class="form-control">
            </div>

            <div class="col-6">
                <label>giaBan</label>
                <input type="text" name="giaBan" id="giaBan" class="form-control">
            </div>

            <div class="col-6">
                <label>nguoiTao</label>
                <select name="nguoiTao">
                    <c:forEach items="${lstUS}" var="i">
                        <option value="${i.idUsers}">
                                ${i.idUsers}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-6">
                <label>nguoiSua</label>
                <select name="nguoiSua">
                    <c:forEach items="${lstUS}" var="i">
                        <option value="${i.idUsers}">
                                ${i.idUsers}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-6">
                <label>ngayTao</label>
                <input type="date" name="ngayTao" id="ngayTao" class="form-control" />
            </div>
            <div class="col-6">
                <label>ngaySua</label>
                <input type="date" name="ngaySua" id="ngaySua" class="form-control" />
            </div>
            <div class="col-6">
                <label>ghiChu</label>
                <input type="text" name="ghiChu" id="ghiChu" class="form-control" />
            </div>
<%--            <div class="col-6">--%>
<%--                <label>trangThai</label>--%>
<%--                <input type="text" name="trangThai" id="trangThai" class="form-control" />--%>
<%--            </div>--%>
            <div>
                <label>Con</label>
                <input type="radio" name="trangThai" value=1>

                <label>Het</label>
                <input type="radio" name="trangThai" value=0>
            </div>
            <button class="btn btn-primary" type="submit" onclick="return confirm('Bạn có muốn thêm không ???')">ADD</button>
        </div>
    </table>
</form>
</body>
</html>
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
<h1 class="text-center" style="padding-bottom: 50px">mausac</h1>
<form action="/mausac/update/${mausac.idMauSac}" class="container" method="post" onsubmit="return kt()">
    <table>
        <div class="col-mt-3">
            <div class="col-6">
                <label>maMauSac</label>
                <input type="text" name="maMauSac" id="maMauSac" class="form-control"  value="${mausac.maMauSac}" >
            </div>
            <div class="col-6">
                <label>tenMauSac</label>
                <input type="text" name="tenMauSac" id="tenMauSac" class="form-control"  value="${mausac.tenMauSac}" >
            </div>

            <div class="col-6">
                <label>ngayTao</label>
                <input type="date" name="ngayTao" id="ngayTao" class="form-control"
                       value="<fmt:formatDate pattern='yyyy-MM-dd' value='${mausac.ngayTao}'/>">
            </div>
            <div class="col-6">
                <label>ngaySua</label>
                <input type="date" name="ngaySua" id="ngaySua" class="form-control"
                       value="<fmt:formatDate pattern='yyyy-MM-dd' value='${mausac.ngaySua}'/>">
            </div>
            <div class="col-6">
                <label>trangThai</label>
                <input type="text" name="trangThai" id="trangThai" class="form-control"   value="${mausac.trangThai}" />
            </div>
            <button class="btn btn-primary" type="submit" >update</button>
        </div>
    </table>
</form>
</body>
</html>
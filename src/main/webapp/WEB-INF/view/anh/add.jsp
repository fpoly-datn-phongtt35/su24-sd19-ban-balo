<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1 class="text-center" style="padding-bottom: 50px">anh</h1>
<form action="/anh/add" method="post" onsubmit="return kt()">
    <table>
        <div class="col-mt-3">

            <div class="col-6">
                <label>url</label>
                <input type="file" name="url" id="url" class="form-control" />
            </div>
            <div class="col-6">
                <label>Danh Muc
                </label>
                <select name="danhMuc"  id="danhMuc">
                        <option value="/img/hero/" >
                                hero
                        </option>
                    <option value="/img/banner/">
                        banner
                    </option>
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
                <label>trangThai</label>
                <input type="text" name="trangThai" id="trangThai" class="form-control" />
            </div>
            <button class="btn btn-primary" type="submit" >ADD</button>
        </div>
    </table>
</form>
</body>
</html>
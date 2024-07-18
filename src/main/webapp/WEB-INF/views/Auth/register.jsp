<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>King Shop</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .gradient-custom {
            background: linear-gradient(to bottom right, rgb(78, 188, 200), rgb(99, 124, 230));
        }

        .card-registration {
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            background-color: #ffffff;
        }

        .form-outline {
            margin-bottom: 1.5rem;
        }

        .form-label {
            font-weight: 600;
        }

        .form-control-lg {
            padding: 0.75rem 1.25rem;
            font-size: 1rem;
            border-radius: 0.375rem;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #004085;
        }

        .form-check-input {
            margin-right: 0.5rem;
        }

        .form-check-label {
            font-weight: 400;
        }

        .text-danger {
            color: #dc3545;
        }
    </style>
</head>
<body>
<main>
    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-9 col-xl-7">
                    <div class="card shadow-2-strong card-registration">
                        <div class="card-body p-4 p-md-5">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 text-center">Đăng Ký Tài Khoản</h3>
                            <form action="/register" method="post" class="all-classes-container">

                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <input type="text" id="ten" class="form-control form-control-lg" name="ten" />
                                            <label class="form-label" for="ten">Tên</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <input type="text" id="ho" class="form-control form-control-lg" name="ho" />
                                            <label class="form-label" for="ho">Họ</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline datepicker w-100">
                                            <input type="date" class="form-control form-control-lg" id="ngaySinh" name="ngaySinh" />
                                            <label for="ngaySinh" class="form-label">Ngày Sinh</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <input type="tel" id="sdt" class="form-control form-control-lg" name="sdt" />
                                            <label class="form-label" for="sdt">Số điện thoại</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="mb-4">
                                    <div class="form-outline">
                                        <input type="email" id="email" class="form-control form-control-lg" name="email" />
                                        <label class="form-label" for="email">Email</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <input type="password" id="password" class="form-control form-control-lg" name="password" />
                                            <label class="form-label" for="password">Mật Khẩu</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <h6 class="mb-2 pb-1">Giới Tính:</h6>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gioiTinh" id="gioiTinh2" value="2" checked />
                                            <label class="form-check-label" for="gioiTinh2">Nữ</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gioiTinh" id="gioiTinh" value="1" />
                                            <label class="form-check-label" for="gioiTinh">Nam</label>
                                        </div>
                                    </div>
                                </div>

                                <p class="text-danger mb-4">${message}</p>

                                <div class="text-center">
                                    <input class="btn btn-primary btn-lg" type="submit" value="Đăng Ký" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
</body>
</html>

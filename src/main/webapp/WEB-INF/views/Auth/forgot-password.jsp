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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <style>
        .gradient-custom {
            background: linear-gradient(to bottom right, rgb(191, 219, 248), rgb(191, 219, 248));
        }
        .card-reset-password {
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            background-color: #ffffff;
        }
        .form-control-lg {
            padding: 0.75rem 1.25rem;
            font-size: 1rem;
            border-radius: 0.375rem;
        }
        .btn-primary {
            background-color: #040707;
            border-color: #040707;
        }

        .btn-primary:hover {
            background-color: #818f8f;
            border-color: #818f8f;
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
                <div class="col-12 col-lg-9 col-xl-6">
                    <div class="card card-reset-password">
                        <div class="card-body p-4 p-md-5">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 text-center">Quên Mật Khẩu</h3>
                            <form action="/forgot-password" method="post">

                                <div class="form-outline mb-4">
                                    <input type="email" id="email" class="form-control form-control-lg" name="email" placeholder="Nhập email của bạn"/>
                                    <label class="form-label" for="email">Email</label>
                                </div>

                                <p class="text-danger mb-4">${message}</p>

                                <div class="text-center">
                                    <input class="btn btn-primary btn-lg" type="submit" value="Gửi lại mật khẩu" />
                                </div>

                                <div class="text-center mt-3">
                                    <a href="/login" class="btn btn-link">Quay lại Đăng Nhập</a>
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

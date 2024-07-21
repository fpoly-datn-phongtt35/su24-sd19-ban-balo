<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>King Shop</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <style>
        body {
            background-color: #f8f9fa;
        }
        .vh-100 {
            min-height: 100vh;
        }
        .h-custom {
            height: 100%;
        }
        .form-container {
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            background-color: #fff;
        }
        .form-outline {
            margin-bottom: 1.5rem;
        }
        .form-label {
            font-weight: bold;
        }
        .form-check-input {
            margin-right: 0.5rem;
        }
        .form-check-label {
            font-weight: normal;
        }
        .btn-primary {
            padding-left: 2.5rem;
            padding-right: 2.5rem;
        }
        .divider {
            border-top: 1px solid #e9ecef;
        }
        .text-primary {
            color: #007bff !important;
        }
        .bg-primary {
            background-color: #007bff !important;
        }
        .login-form {
            max-width: 400px;
            margin: auto;
            padding: 2rem;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-form .btn-primary {
            padding-left: 2.5rem;
            padding-right: 2.5rem;
        }
        .form-outline input {
            border-radius: 5px;
        }
        .form-outline label {
            font-size: 0.875rem;
        }
        .form-check-input {
            border-radius: 5px;
        }
        .text-danger {
            font-size: 0.875rem;
        }
        .footer {
            background-color: #007bff;
            color: white;
            padding: 1rem 0;
            text-align: center;
        }
        .footer a {
            color: white;
        }
        .footer a:hover {
            color: #f8f9fa;
        }
    </style>
</head>
<body>
<main>

    <section class="vh-100">
        <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-5">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                         class="img-fluid" alt="Sample image">
                </div>
                <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                    <form action="/login-handle" method="post">
                        <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start mb-4">
                            <p class="lead fw-normal mb-0 me-3">Sign in with</p>
                            <button type="button" class="btn btn-primary btn-floating mx-1" >
                                <i class="fab fa-facebook-f"></i>
                            </button>
                            <button type="button" class="btn btn-primary btn-floating mx-1">
                                <i class="fab fa-twitter"></i>
                            </button>
                            <button type="button" class="btn btn-primary btn-floating mx-1">
                                <i class="fab fa-linkedin-in"></i>
                            </button>
                        </div>

                        <div class="divider d-flex align-items-center my-4">
                            <p class="text-center fw-bold mx-3 mb-0">Or</p>
                        </div>

                        <!-- Email input -->
                        <div class="form-outline mb-4">
                            <input type="text" id="email" name="email" class="form-control form-control-lg"
                                   placeholder="Email" value="${email}" />
                            <label class="form-label" for="email">Email address</label>
                        </div>

                        <!-- Password input -->
                        <div class="form-outline mb-4">
                            <input type="password" id="password" name="password" class="form-control form-control-lg"
                                   placeholder="Password" value="${password}" />
                            <label class="form-label" for="password">Password</label>
                        </div>

                        <p class="text-danger mb-3">${message}</p>

                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <div class="form-check mb-0">
                                <input class="form-check-input me-2" type="checkbox" value="password" id="mat-khau" />
                                <label class="form-check-label" for="mat-khau">Nhớ mật khẩu</label>
                            </div>
                            <a href="/forgot-password" class="text-body">Quên mật khẩu?</a>
                        </div>

                        <div class="text-center text-lg-start mt-4">
                            <button type="submit" class="btn btn-primary btn-lg">Đăng Nhập</button>
                            <p class="small fw-bold mt-2 pt-1 mb-0">Chưa có tài khoản? <a href="/register"
                                                                                          class="link-danger">Đăng Ký</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <footer class="footer d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5">
            <!-- Copyright -->
            <div class="text-white mb-3 mb-md-0">
                Copyright © 2020. All rights reserved.
            </div>
            <!-- Right -->
            <div>
                <a href="" class="text-white me-4">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a href="" class="text-white me-4">
                    <i class="fab fa-twitter"></i>
                </a>
                <a href="" class="text-white me-4">
                    <i class="fab fa-google"></i>
                </a>
                <a href="" class="text-white">
                    <i class="fab fa-linkedin-in"></i>
                </a>
            </div>
        </footer>
    </section>

</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-1t8M0z1z4b9WVm68hI8j5b9E6Chy0RMZf1e6fdfZ77zxS8eY1CvY4d68HT6XSJ1l8" crossorigin="anonymous"></script>
</body>
</html>

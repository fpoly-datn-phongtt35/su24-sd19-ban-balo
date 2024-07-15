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
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

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
                    <form action="/login-handle" method="post" >
                        <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                            <p class="lead fw-normal mb-0 me-3">Sign in with</p>
                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-floating mx-1">
                                <i class="fab fa-facebook-f"></i>
                            </button>

                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-floating mx-1">
                                <i class="fab fa-twitter"></i>
                            </button>

                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-floating mx-1">
                                <i class="fab fa-linkedin-in"></i>
                            </button>
                        </div>

                        <div class="divider d-flex align-items-center my-4">
                            <p class="text-center fw-bold mx-3 mb-0">Or</p>
                        </div>

                        <!-- Email input -->
                        <div data-mdb-input-init class="form-outline mb-4">
                            <input  type="text" id="email" value="${email}" class="form-control form-control-lg"
                                   placeholder="Email" name="email"/>
                            <label class="form-label" for="email">Email address</label>
                        </div>

                        <!-- Password input -->
                        <div data-mdb-input-init class="form-outline mb-3">
                            <input type="password" id="password" value="${password}" class="form-control form-control-lg"
                                   placeholder="Mật Khẩu" name="password" />
                            <label class="form-label" for="password">Password</label>
                        </div>
                        <p class="text-danger" text="${message}"></p>

                        <div class="d-flex justify-content-between align-items-center">
                            <!-- Checkbox -->
                            <div class="form-check mb-0">
                                <input class="form-check-input me-2" type="checkbox" value="password" id="mat khau" />
                                <label class="form-check-label" for="mat khau">
                                    Nhớ mật khẩu
                                </label>
                            </div>
                            <a href="" class="text-body">Quên mật khẩu?</a>
                        </div>

                        <div class="text-center text-lg-start mt-4 pt-2">
                            <button  type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-lg"
                                     style="padding-left: 2.5rem; padding-right: 2.5rem;" value="login">Đăng Nhập</button>
                            <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="/register"
                                                                                              class="link-danger">Đăng Ký</a></p>
                        </div>


                    </form>
                </div>
            </div>
        </div>
        <div
                class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
            <!-- Copyright -->
            <div class="text-white mb-3 mb-md-0">
                Copyright © 2020. All rights reserved.
            </div>
            <!-- Copyright -->

            <!-- Right -->
            <div>
                <a href="" class="text-white me-4">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a href="" class="text-white me-4">
                    <i class="fab fa-twitter"></i>
                </a>
                <a href="#!" class="text-white me-4">
                    <i class="fab fa-google"></i>
                </a>
                <a href="#!" class="text-white">
                    <i class="fab fa-linkedin-in"></i>
                </a>
            </div>
            <!-- Right -->
        </div>
    </section>
<%--    <script type="text/javascript">--%>
<%--        function kt(){--%>
<%--            var email = document.getElementById("email");--%>
<%--            var passWord = document.getElementById("password");--%>
<%--            var sdt = document.getElementById("sdt");--%>
<%--            if (email.style.length == 0 || passWord.style.length == 0 || sdt.style.length == 0){--%>
<%--                alert("Vui long ko de trong");--%>
<%--                email.style.border = "1px solid red";--%>
<%--                email.style.background = "yellow";--%>
<%--                passWord.style.border = "1px solid red";--%>
<%--                passWord.style.background = "yellow";--%>
<%--                sdt.style.border = "1px solid red";--%>
<%--                sdt.style.background = "yellow";--%>
<%--                return false;--%>
<%--            }else {--%>
<%--                email.style.border = "none";--%>
<%--                email.style.background = "white";--%>
<%--                passWord.style.border = "none";--%>
<%--                passWord.style.background = "white";--%>
<%--                sdt.style.border = "none";--%>
<%--                sdt.style.background = "white";--%>
<%--            }--%>
<%--            if (email.style.length != 0 & passWord.style.length != 0 & sdt.style.length != 0){--%>
<%--                alert("Thanh cong");--%>
<%--                return true;--%>
<%--            }--%>
<%--        }--%>
<%--    </script>--%>


</main>

</body>
</html>
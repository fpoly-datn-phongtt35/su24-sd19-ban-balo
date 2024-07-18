<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quên Mật Khẩu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .gradient-custom {
            background: linear-gradient(to bottom right, rgb(78, 188, 200), rgb(99, 124, 230));
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
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #004085;
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
                                    <input class="btn btn-primary btn-lg" type="submit" value="Gửi liên kết đặt lại mật khẩu" />
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

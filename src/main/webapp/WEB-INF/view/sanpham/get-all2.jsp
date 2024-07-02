<%@ page import="com.example.datntest.entity.SanPham" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script src="/js/checkbox.js"></script>

    <title>Document</title>
</head>

<body>
<%--    <div>--%>
<%--        <form id="searchForm">--%>
<%--            <label for="query"> Nhập Mã hoặc Tên:</label>--%>
<%--            <input type="text" id="query" name="query">--%>
<%--            <button type="submit">Search</button>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--    <table id="dataTable" class="display" style="width:100%" class="table table-dark table-striped">--%>
<%--        <!-- Dữ liệu bảng sẽ được cập nhật bằng AJAX -->--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Ma</th>--%>
<%--            <th>Ten</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>

<%--        <tbody>--%>
<%--        <%--%>

<%--            List<SanPham> dataList = (List<SanPham>) request.getAttribute("list");--%>
<%--            if (dataList != null) {--%>
<%--                for (SanPham data : dataList) {--%>
<%--        %>--%>
<%--        <tr>--%>
<%--            <td><%= data.getIdSanPham() %>--%>
<%--            </td>--%>
<%--            <td><%= data.getMaSanPham() %>--%>
<%--            </td>--%>
<%--            <td><%= data.getTenSanPham() %>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <%--%>
<%--                }--%>
<%--            }--%>
<%--        %>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--    <script>--%>
<%--        $(document).ready(function () {--%>
<%--            var table = $('#dataTable').DataTable({--%>
<%--                paging: true,--%>
<%--                searching: false, // Tắt tính năng search của DataTable vì chúng ta sẽ dùng form tìm kiếm riêng--%>
<%--                info: false // Tắt thông tin số trang và số bản ghi--%>
<%--            });--%>

<%--            // Load dữ liệu ban đầu khi trang được tải--%>
<%--            // fetchAndLoadData();--%>

<%--            // Xử lý khi người dùng submit form tìm kiếm--%>
<%--            $('#searchForm').submit(function (event) {--%>
<%--                event.preventDefault(); // Ngăn chặn form submit mặc định--%>

<%--                var query = $('#query').val(); // Lấy giá trị từ input tìm kiếm--%>
<%--                console.log(query)--%>
<%--                if (query !== '') {--%>
<%--                    // Gửi yêu cầu Get tới endpoint /search--%>
<%--                    fetch('search?query=' + encodeURIComponent(query))--%>
<%--                        .then(response => {--%>
<%--                            return response.json(); // Chuyển đổi kết quả thành JSON--%>
<%--                        })--%>
<%--                        .then(data => {--%>
<%--                            // Xóa dữ liệu hiện tại trong bảng--%>
<%--                            table.clear().draw();--%>
<%--                            console.log(typeof data); // Nếu đây là mảng, kết quả sẽ là 'object'--%>
<%--                            // Thêm dữ liệu tìm được vào bảng--%>
<%--                            data.forEach(item => {--%>
<%--                                table.row.add([--%>
<%--                                    item.idSanPham,--%>
<%--                                    item.maSanPham,--%>
<%--                                    item.tenSanPham--%>

<%--                                ]).draw(false);--%>
<%--                            });--%>
<%--                        })--%>
<%--                        .catch(error => console.error('Error:', error));--%>
<%--                } else {--%>
<%--                    fetchAndLoadData();--%>
<%--                    console.log('load de')--%>
<%--                }--%>

<%--            });--%>

<%--            // Hàm fetch dữ liệu từ server và cập nhật bảng--%>
<%--            function fetchAndLoadData() {--%>
<%--                table.clear().draw();--%>
<%--                fetch('table1') // getMapping--%>
<%--                    .then(response => response.json())--%>
<%--                    .then(data => {--%>
<%--                        // Thêm dữ liệu ban đầu vào bảng--%>
<%--                        data.forEach(item => {--%>
<%--                            table.row.add([--%>
<%--                                item.idSanPham,--%>
<%--                                item.maSanPham,--%>
<%--                                item.tenSanPham--%>
<%--                            ]).draw(false);--%>
<%--                        });--%>
<%--                    })--%>
<%--                    .catch(error => console.error('Error:', error));--%>
<%--            }--%>
<%--        });--%>
<%--    </script>--%>

<div class="container">

    <div id="sanpham-list">
    <h1>Danh sách Sản Phẩm</h1>


    <form  id="checkboxForm" action="/sanpham/hien-thi" method="get" class="mb-4">
         Form tìm kiếm theo tên sản phẩm
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Nhập tên sản phẩm" name="tenSanPham">
            <button class="btn btn-outline-secondary" type="submit">Tìm kiếm</button>
        </div>
        <!-- Form tìm kiếm theo khoảng giá -->
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Giá từ" name="giaTu">
            <input type="text" class="form-control" placeholder="Giá đến" name="giaDen">
            <button class="btn btn-outline-secondary" type="submit">Tìm kiếm</button>
        </div>
        tìm kiếm theo tên chất liệu
        <c:forEach var="chatLieu" items="${lstCL}">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="tenChatLieu" value="${chatLieu.tenChatLieu}">
                <label class="form-check-label">${chatLieu.tenChatLieu}</label>
            </div>
        </c:forEach>
<%--        <button class="btn btn-outline-secondary" type="submit">Tìm kiếm</button>--%>
    </form>


        <button class="btn btn-primary"><a class="btn btn-primary" href="/sanpham/view-add">ADD</a></button>
        <table class="table table-secondary">
            <tr>
                <th>idChatLieu</th>
                <th>idDongSanPham</th>
<%--                <th>idNSX</th>--%>
                <th>idHang</th>
                <%--            <th>maSanPham</th>--%>
                <th>tenSanPham</th>
<%--                <th>chieuDai</th>--%>
<%--                <th>chieuRong</th>--%>
<%--                <th>chieuCao</th>--%>
<%--                <th>trongLuong</th>--%>
<%--                <th>trongLuongToiDa</th>--%>
                <th>giaNhap</th>
                <%--        <th>soLuongTon</th>--%>
                <%--            <th>NgayTao</th>--%>
                <%--            <th>NgaySua</th>--%>
                <th>TrangThai</th>
                <th scope="col">Action</th>
            </tr>
            <tbody>
                <c:forEach var="sanpham" items="${list.content}">

                    <tr>
                        <td>${sanpham.idChatLieu.tenChatLieu}</td>
                        <td>${sanpham.idDongSanPham.tenDongSanPham}</td>
                            <%--                    <td>--%>
                            <%--                        <c:set var="idNSX" value="${sanpham.idNSX.tenNSX}" />--%>
                            <%--                        <fmt:formatDate pattern="yyyy-MM-dd" value="${idNSX}" />--%>
                            <%--                    </td>--%>
                        <td>${sanpham.idHang.tenHang}</td>
                            <%--                <td>${sanpham.maSanPham}</td>--%>
                        <td>${sanpham.tenSanPham}</td>
                            <%--                    <td>${sanpham.chieuDai}</td>--%>
                            <%--                    <td>${sanpham.chieuRong}</td>--%>
                            <%--                    <td>${sanpham.chieuCao}</td>--%>
                            <%--                    <td>${sanpham.trongLuong}</td>--%>
                            <%--                    <td>${sanpham.trongLuongToiDa}</td>--%>
                        <td>${sanpham.giaNhap}</td>
                            <%--            <td>${sanpham.soLuongTon}</td>--%>
                            <%--                <td>--%>
                            <%--                    <c:set var="ngayTao" value="${sanpham.ngayTao}" />--%>
                            <%--                    <fmt:formatDate pattern="yyyy-MM-dd" value="${ngayTao}" />--%>
                            <%--                </td>--%>
                            <%--                <td>--%>
                            <%--                    <c:set var="ngaySua" value="${sanpham.ngaySua}" />--%>
                            <%--                    <fmt:formatDate pattern="yyyy-MM-dd" value="${ngaySua}" />--%>
                            <%--                </td>--%>
                        <td>${sanpham.trangThai}</td>
                        <td>
                            <button class="btn btn-light" onclick="return confirm('Bạn có muốn xóa không?')" ><a class="btn btn-light" href="/sanpham/delete/${sanpham.idSanPham}">Delete</a></button>

                            <button class="btn btn-dark" ><a class="btn btn-dark" href="/sanpham/updateForm/${sanpham.idSanPham}">Detail</a></button>
                        </td>
                    </tr>
                </c:forEach>
            </div>

            </tbody>
            <nav aria-label="Page navigation example" class="container">
                <ul class="pagination">
                    <c:forEach begin="0" end="${nv.totalPages +1}" varStatus="loop">
                        <li class="page-item"><a class="page-link" href="/sanpham/hien-thi?page=${loop.index}">${loop.index + 1}</a></li>
                    </c:forEach>
                </ul>
            </nav>
        </table>
    </div>


    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">   footer của nhóm SD-19</p>
        </div>
    </footer>

</div>

<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-3">
            <h1 class="my-4">NeTa shop</h1>
            <div class="list-group">
                <a href="#" class="list-group-item">Nội dung 1</a>
                <a href="#" class="list-group-item">Nội dung 2</a>
                <a href="#" class="list-group-item">Nội dung 3</a>
            </div>
        </div>
        <!-- /.col-lg-3 -->
        <div class="col-lg-9">
            <!-- Product List -->
            <div class="row">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="/img/banner/banner-3.jpg"  alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Sản phẩm One</a>
                            </h4>
                            <h5>$24.99</h5>
                            <p class="card-text">Nội dung sản phẩm</p>
                        </div>
                        <div class="card-footer">
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="/img/banner/banner-3.jpg" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Sản phẩm Two</a>
                            </h4>
                            <h5>$24.99</h5>
                            <p class="card-text">Nội dung sản phẩm</p>

                        </div>
                        <div class="card-footer">
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="/img/banner/banner-3.jpg" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Sản phẩm Three</a>
                            </h4>
                            <h5>$24.99</h5>
                            <p class="card-text">Nội dung sản phẩm</p>

                        </div>
                        <div class="card-footer">
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="/img/banner/banner-3.jpg" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Sản phẩm Four</a>
                            </h4>
                            <h5>$24.99</h5>
                            <p class="card-text">Nội dung sản phẩm</p>

                        </div>
                        <div class="card-footer">
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="/img/banner/banner-3.jpg" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Sản phẩm Five</a>
                            </h4>
                            <h5>$24.99</h5>
                            <p class="card-text">Nội dung sản phẩm</p>

                        </div>
                        <div class="card-footer">
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="/img/banner/banner-3.jpg" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Sản phẩm Six</a>
                            </h4>
                            <h5>$24.99</h5>
                            <p class="card-text">Nội dung sản phẩm</p>

                        </div>
                        <div class="card-footer">
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.row Product List -->

        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

</div>
</body>

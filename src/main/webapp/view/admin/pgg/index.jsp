<%@ page import="com.example.maindatn.Entity.PhieuGiamGia_Entity" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
</head>

<body>

<a href="create">
    <button>Tao moi nhe</button>
</a>
<br>
<br>
<div>
    <form id="searchForm">
        <label for="query"> Nhập Mã hoặc Tên:</label>
        <input type="text" id="query" name="query">
        <button type="submit">Search</button>
    </form>
</div>
<br>
<br>

<table id="dataTable" class="display" style="width:100%" class="table table-dark table-striped">
    <!-- Dữ liệu bảng sẽ được cập nhật bằng AJAX -->
    <thead>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Ngay Bat Dau</th>
        <th>Ngay Ket Thuc</th>
        <th>Giam Toi Da</th>
    </tr>
    </thead>

    <tbody>
    <%
        List<PhieuGiamGia_Entity> dataList = (List<PhieuGiamGia_Entity>) request.getAttribute("dataList");
        if (dataList != null) {
            for (PhieuGiamGia_Entity data : dataList) {
    %>
    <tr>
        <td><%= data.getId() %>
        </td>
        <td><%= data.getMa() %>
        </td>
        <td><%= data.getTen() %>
        </td>
        <td><%= data.getBeginday() %>
        </td>
        <td><%= data.getEndday() %>
        </td>
        <td><%= data.getGiamToiDa() %>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
<script>
    $(document).ready(function () {
        var table = $('#dataTable').DataTable({
            paging: true,
            searching: false, // Tắt tính năng search của DataTable vì chúng ta sẽ dùng form tìm kiếm riêng
            info: false // Tắt thông tin số trang và số bản ghi
        });

        // Load dữ liệu ban đầu khi trang được tải
        // fetchAndLoadData();

        // Xử lý khi người dùng submit form tìm kiếm
        $('#searchForm').submit(function (event) {
            event.preventDefault(); // Ngăn chặn form submit mặc định

            var query = $('#query').val(); // Lấy giá trị từ input tìm kiếm
            console.log(query)
            if (query !== '') {
                // Gửi yêu cầu Get tới endpoint /search
                fetch('search?query=' + encodeURIComponent(query))
                    .then(response => {
                        return response.json(); // Chuyển đổi kết quả thành JSON
                    })
                    .then(data => {
                        // Xóa dữ liệu hiện tại trong bảng
                        table.clear().draw();
                        console.log(typeof data); // Nếu đây là mảng, kết quả sẽ là 'object'
                        // Thêm dữ liệu tìm được vào bảng
                        data.forEach(item => {
                            table.row.add([
                                item.id,
                                item.ma,
                                item.ten,
                                item.beginday,
                                item.endday,
                                item.giamToiDa
                            ]).draw(false);
                        });
                    })
                    .catch(error => console.error('Error:', error));
            } else {
                fetchAndLoadData();
                console.log('load de')
            }

        });

        // Hàm fetch dữ liệu từ server và cập nhật bảng
        function fetchAndLoadData() {
            table.clear().draw();
            fetch('table1') // getMapping
                .then(response => response.json())
                .then(data => {
                    // Thêm dữ liệu ban đầu vào bảng
                    data.forEach(item => {
                        table.row.add([
                            item.id,
                            item.ma,
                            item.ten,
                            item.beginday,
                            item.endday,
                            item.giamToiDa
                        ]).draw(false);
                    });
                })
                .catch(error => console.error('Error:', error));
        }
    });
</script>

<div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/pgg/index?page=${page.number - 1}">Trước</a></li>
            <li class="page-item"><a class="page-link" href="#">${list.number}</a></li>
            <li class="page-item"><a class="page-link" href="/pgg/index?page=${page.number + 1}">Sau</a></li>
        </ul>
    </nav>

</div>
</body>

</html>
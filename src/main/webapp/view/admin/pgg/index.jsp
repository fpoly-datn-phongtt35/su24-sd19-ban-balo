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
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <!-- DataTables JS -->
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>

</head>
<body>

<%--<style>--%>
<%--    .dataTables_wrapper .dataTables_paginate .paginate_button {--%>
<%--        padding: 7px;--%>
<%--        margin-left: 2px;--%>
<%--        cursor: pointer;--%>
<%--        color: #333;--%>
<%--        border: 1px solid #ccc;--%>
<%--        background-color: #ffffff;--%>
<%--        border-radius: 3px;--%>
<%--        display: inline-block;--%>
<%--    }--%>
<%--</style>--%>

<a href="create">
    <button>New</button>
</a>
<br>
<br>
<div>
    <form id="searchForm">

        <div>
            <label for="query"> Nhập Mã hoặc Tên:</label>
            <input type="text" id="query" name="query">
            <select name="query2">
                <option >Tất cả </option>
                <option value="1">Hoạt động</option>
                <option value="2">Ngưng hoạt động</option>
            </select>

             <button type="submit">Search</button>
        </div>

    </form>
</div>
<%--<button id="dataTable_previous">Previous</button>--%>
<%--<button id="dataTable_next">Next</button>--%>

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
        <th>Trạng thái</th>
        <th>Tac Vu</th>
    </tr>
    </thead>

    <tbody>
<%--    <%--%>
<%--        List<PhieuGiamGia_Entity> dataList = (List<PhieuGiamGia_Entity>) request.getAttribute("dataList");--%>
<%--        if (dataList != null) {--%>
<%--            for (PhieuGiamGia_Entity data : dataList) {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td><%= data.getId() %>--%>
<%--        </td>--%>
<%--        <td><%= data.getMa() %>--%>
<%--        </td>--%>
<%--        <td><%= data.getTen() %>--%>
<%--        </td>--%>
<%--        <td><%= data.getBeginday() %>--%>
<%--        </td>--%>
<%--        <td><%= data.getEndday() %>--%>
<%--        </td>--%>
<%--        <td><%= data.getGiamToiDa() %>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--            }--%>
<%--        }--%>
<%--    %>--%>
    </tbody>
</table>


<script>
    $(document).ready(function () {
        var table = $('#dataTable').DataTable({
            paging: true,
            // serverSide: true,
            pagingType: 'full_numbers', // Chế độ phân trang với các nút điều khiển
            searching: false, // Tắt tính năng search của DataTable vì chúng ta sẽ dùng form tìm kiếm riêng
            info: false
        });

        // Load dữ liệu ban đầu khi trang được tải
        fetchAndLoadData();

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
                                formatDate(item.beginday),
                                formatDate(item.endday),
                                item.giamToiDa,
                                trangThai(item.trangthai),
                                createActions(item.id)


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
                            formatDate(item.beginday),
                            formatDate(item.endday),
                            item.giamToiDa,
                            trangThai(item.trangthai),
                            createActions(item.id)
                        ]).draw(false);
                    });
                })
                .catch(error => console.error('Error:', error));
        }

        function formatDate(dateString) {
            if (!dateString) return '';
            var date = new Date(dateString);
            return new Intl.DateTimeFormat('vi-VN').format(date);
        }
        function trangThai(int) {
            if (int=1) return 'Hoạt động';
            else if(int=2) {
                return 'Ngưng hoạt động'
                }
        }

        function createActions(id) {
            return '<a href="/pgg/edit/' + id + '">Edit</a> ' +
                    '<a href="/pgg/delete/' + id + '">Delete</a>';
        }

    });
</script>
</body>

</html>
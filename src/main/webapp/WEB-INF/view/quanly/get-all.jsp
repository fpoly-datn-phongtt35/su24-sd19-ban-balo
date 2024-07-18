<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang với Sidebar</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="/js/checkbox.js"></script>
    <style>
        .sidebar {
            height: 100vh;
            position: fixed;
            top: 0;
            left: 0;
            width: 250px;
            background-color: #f8f9fa;
            padding-top: 20px;
            transition: left 0.3s;
        }
        .content {
            margin-left: 250px;
            padding: 20px;
            transition: margin-left 0.3s;
        }
        .nav-item-children {
            display: none;
            margin-left: 20px;
        }
        .nav-item-parent.active .nav-item-children {
            display: block;
        }
        .nav-item-parent .toggle-icon {
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="d-flex">
    <div class="sidebar" id="sidebar">
        <button class="btn btn-primary" onclick="toggleSidebar()">&#9776;</button>
        <h4 class="mb-0">Sidebar</h4>
        <div class="nav-item-parent">
            <a class="nav-link" href="#" onclick="toggleNavItems(this)">Tất cả sản phẩm <span class="toggle-icon">&#9660;</span></a>
            <div class="nav-item-children">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="loadContent('/sanpham/hien-thi')">Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="loadContent('/dongsanpham/hien-thi')">Dòng Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="loadContent('/nsx/hien-thi')">NSX</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="loadContent('/hang/hien-thi')">Hãng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="loadContent('/anh/hien-thi')">Ảnh</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="nav-item-parent">
            <a class="nav-link" href="#" onclick="toggleNavItems(this)">Tất cả sản phẩm <span class="toggle-icon">&#9660;</span></a>
            <div class="nav-item-children">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="loadContent('/sanpham/hien-thi')">Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="loadContent('/dongsanpham/hien-thi')">Dòng Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="loadContent('/nsx/hien-thi')">NSX</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="loadContent('/hang/hien-thi')">Hãng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="loadContent('/anh/hien-thi')">Ảnh</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="content" id="content">
        <h1>Nội dung chính</h1>
        <p>Đây là phần nội dung chính của trang web. Nội dung này sẽ được đẩy sang bên phải bởi sidebar.</p>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function toggleSidebar() {
        $('#sidebar').toggleClass('collapsed');
        $('#content').toggleClass('collapsed');
    }

    function loadContent(url) {
        $.ajax({
            url: url,
            method: 'GET',
            success: function(response) {
                $('#content').html(response);
            },
            error: function() {
                alert('Đã xảy ra lỗi khi tải nội dung.');
            }
        });
    }

    function toggleNavItems(element) {
        $(element).parent().toggleClass('active');
        var icon = $(element).find('.toggle-icon');
        icon.text(icon.text() === '▼' ? '▲' : '▼');
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1Q+l8z6nx7C/cyRXY+U/By9IepxL8SYF9Km8ICwBzp7FY9l1qz85TXV0B5Mdlt5" crossorigin="anonymous"></script>
</body>
</html>

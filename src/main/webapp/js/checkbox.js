$(document).ready(function() {
    var selectedChatLieus = []; // Mảng lưu trữ các giá trị tenChatLieu đã chọn
    var selectedDongSanPhams = []; // Mảng lưu trữ các giá trị tenDongSanPham đã chọn
    var selectedHangs = []; // Mảng lưu trữ các giá trị tenHang đã chọn

    // Xử lý sự kiện khi checkbox thay đổi cho tenChatLieu
    $('input[type="checkbox"][name="tenChatLieu"]').on('change', function() {
        var tenChatLieu = $(this).val();

        // Kiểm tra checkbox có được chọn hay không
        if ($(this).is(':checked')) {
            selectedChatLieus.push(tenChatLieu); // Thêm vào mảng nếu chưa tồn tại
        } else {
            // Xóa khỏi mảng nếu đã tồn tại
            var index = selectedChatLieus.indexOf(tenChatLieu);
            if (index !== -1) {
                selectedChatLieus.splice(index, 1);
            }
        }

        // Gửi yêu cầu AJAX khi có thay đổi
        sendAjaxRequest();
    });

    // Xử lý sự kiện khi checkbox thay đổi cho tenDongSanPham
    $('input[type="checkbox"][name="tenDongSanPham"]').on('change', function() {
        var tenDongSanPham = $(this).val();

        // Kiểm tra checkbox có được chọn hay không
        if ($(this).is(':checked')) {
            selectedDongSanPhams.push(tenDongSanPham); // Thêm vào mảng nếu chưa tồn tại
        } else {
            // Xóa khỏi mảng nếu đã tồn tại
            var index = selectedDongSanPhams.indexOf(tenDongSanPham);
            if (index !== -1) {
                selectedDongSanPhams.splice(index, 1);
            }
        }

        // Gửi yêu cầu AJAX khi có thay đổi
        sendAjaxRequest();
    });

    // Xử lý sự kiện khi checkbox thay đổi cho tenHang
    $('input[type="checkbox"][name="tenHang"]').on('change', function() {
        var tenHang = $(this).val();

        // Kiểm tra checkbox có được chọn hay không
        if ($(this).is(':checked')) {
            selectedHangs.push(tenHang); // Thêm vào mảng nếu chưa tồn tại
        } else {
            // Xóa khỏi mảng nếu đã tồn tại
            var index = selectedHangs.indexOf(tenHang);
            if (index !== -1) {
                selectedHangs.splice(index, 1);
            }
        }

        // Gửi yêu cầu AJAX khi có thay đổi
        sendAjaxRequest();
    });

    // Hàm gửi yêu cầu AJAX
    function sendAjaxRequest() {
        $.ajax({
            type: 'GET',
            url: '/sanpham/hien-thi',
            data: {
                tenChatLieu: selectedChatLieus.join(','), // Gửi mảng các giá trị đã chọn qua parameter
                tenDongSanPham: selectedDongSanPhams.join(','), // Gửi mảng các giá trị đã chọn qua parameter
                tenHang: selectedHangs.join(',') // Gửi mảng các giá trị đã chọn qua parameter
            },
            success: function(response) {
                $('#sanpham-list').html(response); // Cập nhật nội dung của #sanpham-list
                // Đánh dấu lại các checkbox đã được chọn
                $('input[type="checkbox"][name="tenChatLieu"]').each(function() {
                    var value = $(this).val();
                    $(this).prop('checked', selectedChatLieus.includes(value));
                });
                $('input[type="checkbox"][name="tenDongSanPham"]').each(function() {
                    var value = $(this).val();
                    $(this).prop('checked', selectedDongSanPhams.includes(value));
                });
                $('input[type="checkbox"][name="tenHang"]').each(function() {
                    var value = $(this).val();
                    $(this).prop('checked', selectedHangs.includes(value));
                });
            },
            error: function() {
                alert('Đã xảy ra lỗi khi tải dữ liệu');
            }
        });
    }
});

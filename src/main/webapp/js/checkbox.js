$(document).ready(function() {
    var selectedChatLieus = []; // Mảng lưu trữ các giá trị tenChatLieu đã chọn

    // Xử lý sự kiện khi checkbox thay đổi
    $('input[type="checkbox"]').on('change', function() {
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
        $.ajax({
            type: 'GET',
            url: '/sanpham/hien-thi',
            data: {
                tenChatLieu: selectedChatLieus.join(',') // Gửi mảng các giá trị đã chọn qua parameter
            },
            success: function(response) {
                $('#sanpham-list').html(response); // Cập nhật nội dung của #sanpham-list
                // Đánh dấu lại các checkbox đã được chọn
                $('input[type="checkbox"]').each(function() {
                    var value = $(this).val();
                    $(this).prop('checked', selectedChatLieus.includes(value));
                });
            },
            error: function() {
                alert('Đã xảy ra lỗi khi tải dữ liệu');
            }
        });
    });
});

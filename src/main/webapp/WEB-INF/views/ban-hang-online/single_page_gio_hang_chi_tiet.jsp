<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<body>

<c:if test="${listghct.size()>0}">
    <div style="float: right;width: 25%" class="border border-light">
        <div>
            <div class="section-title text-center">
                <button style="display: none;float: right"
                        id="ktsldh" type="button" class="btn btn-danger"
                        data-bs-toggle="modal" data-bs-target="#myModaltbsldathang">
                    Kiểm tra số lượng
                </button>
                <h3 class="title">Đơn Hàng</h3>
            </div>
            <div id="tongsanphamchon" style="float:right;">
                    ${banhangonline.TongtienvsTongspchon(listghct.get(0).gioHang.id).gettongsanphamchon()} sản phẩm
            </div>
            <div style="float:left;">Bạn đã chọn :</div>
            <br>
        </div>
        <br>

        <div>

            <div id="tongthanhtien" style="float:right;">
                    <%--                    ${banhangonline.TongtienvsTongspchon(listghct.get(0).gioHang.id).gettongtien()}--%>
                    <%--                VND--%>
                <label id="tongthanhtien1">${banhangonline.TongtienvsTongspchon(listghct.get(0).gioHang.id).gettongtien()}</label>
                <label>VND</label>
            </div>
            <div style="float:left;">Tổng tiền</div>
            <br>
        </div>
        <br>
        <c:if test="${banhangonline.ListghTheoidghvsTT1(listghct.get(0).gioHang.id).size()>0}">
            <form action="/ban-hang-online/san-pham-duoc-chon-thanh-toan/nut-mua-hang" method="post">
                <input name="idgh" value="${listghct.get(0).gioHang.id}" style="display: none">
                <button type="submit" onclick="return check75tieu('${banhangonline.TongtienvsTongspchon(listghct.get(0).gioHang.id).gettongtien()}');" class="btn btn-success" style="text-align: center; width:100%">Mua hàng
                </button>
            </form>
        </c:if>
    </div>

    <div style="width: 70%">
        <table class="table table-hover">
            <thead>
            <tr style="background-color: #70c0b1">
                <th><input type="checkbox" name="checktong"
                           onclick="chonhetgiohangtong('${listghct.get(0).gioHang.id}');"  ${tttong==0 ?"checked":""}>
                </th>
                <th colspan="2" style="text-align: center">Sản Phẩm</th>
                <th>Đơn Giá</th>
                <th>Số lượng</th>
                <th>Thành tiền</th>
                <th></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listghct}" var="ht" varStatus="stt">
                <tr>
                    <td>
                        <input type="checkbox" name="checkidgh" value="${ht.id}"
                               onclick="chonsanphamgiohang('${stt.index}','${ht.id}','${ht.gioHang.id}');"  ${ht.tinhTrang==0 ?"checked":""}>
                    </td>
                    <td align="center">
                        <img src="../../../uploads/${ht.chiTietSanPham.hinhAnh.tenAnh}" width="40" height="40"
                             style="border-radius:50% 50% 50% 50%">
                    </td>
                    <td style="text-align: center">
                        <a href="/ban-hang-online/chi-tiet-san-pham/${ht.chiTietSanPham.id}">
                                ${ht.chiTietSanPham.sanPham.ten}-${ht.chiTietSanPham.mauSac.ten}<br>
                                ${ht.chiTietSanPham.kichCo.ten}-${ht.chiTietSanPham.thuongHieu.ten}<br>
                        </a>
                    </td>
                    <td>

                        <fmt:formatNumber value="${ht.donGia}" type="number"/> VND

                    </td>
                    <td>
                            <%--                 <input type="text" min="1" max="${banhangonline.soluongcon(ht.idChiTietSanPham.id)}" value="${ht.soLuong}" name="checksoluong"  style="height: 1cm">--%>
                        <button type="button" style="background-color: white ; border: none" name="checktru1"
                                onclick="tru1donvi('${stt.index}','${ht.id}')">-
                        </button>
                        <input type="number" value="${ht.soLuong}" min="1"
                               max="${banhangonline.soluongcon(ht.chiTietSanPham.id)}" name="checksoluong"
                               oninput="myFunction('${stt.index}','${ht.soLuong}','${ht.id}')">
                        <button type="button" style="background-color: white ; border: none" name="checkthem1"
                                onclick="them1donvi('${stt.index}','${ht.id}')">+
                        </button>
                    </td>


                    <td>
                        <div name="checkthanhtien">
                            <fmt:formatNumber value="${ht.donGia * ht.soLuong}" type="number"/> VND
                        </div>
                    </td>
                    <td>
                        <button onclick="xoamotghct('${ht.id}','${ht.gioHang.id}');"
                                style="background-color: white; border: none">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-trash" viewBox="0 0 16 16">
                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                            </svg>
                        </button>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
    </div>
</c:if>
<c:if test="${listghct.size()==0}">
    <div style="width: 70%">
        <td colspan="8" class="text-center">Không có sản phẩm.</td>
    </div>
</c:if>
</body>
</html>
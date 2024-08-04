package com.example.demo.controllers;


import com.example.demo.config.UserInfoUserDetails;
import com.example.demo.models.*;
import com.example.demo.repositories.*;
import com.example.demo.services.*;
import com.example.demo.util.SecurityUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
@Controller
public class BanHangOnlineController {

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private KichCoService kichCoService;
    @Autowired
    private ThuongHieuService thuongHieuService;
    @Autowired
    private TrongLuongService trongLuongService;
    @Autowired
    private ChatLieuService chatLieuService;
    @Autowired
    private BanHangOnlineService banHangOnlineService;
    @Autowired
    private GioHangChiTietService gioHangChiTietService;
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private BanHangOnLinerepository banHangOnLinerepository;
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;
    @Autowired
    ThuongHieuService thuongHieuRepo;



    @Data
    public static class SortFormSP {
        String key = "";
    }
    // Bắt đầu bán hàng
    public Integer kt(Integer so) {
        if (so == Integer.valueOf(0)) {
            return Integer.valueOf(1);
        }
        return so;
    }

    //    private String checkGMAILorTK="0";
    private String idkhachhang = "1";
    @Scheduled(cron = "0 0 */4 * * ?")
    public void autoUpdate() {
        List<ChiTietSanPham> ls= banHangOnlineService.ctspbanhang();
    }
    @GetMapping("/lgin")
    public String lgin() {
        idkhachhang = "1";
        return "login/login";
    }

    @GetMapping("/ban-hang-online/hien-thi")
    public String hienThitrangchu(
            Model model
    ) {
        double tong = 0;
        Integer lamchon = 0;
        for (ChiTietSanPham ct : banHangOnlineService.ctspbanhang()) {
            if (banHangOnlineService.soluongcon(String.valueOf(ct.getId())) > 0) {
                tong = tong + 1;
                lamchon = lamchon + 1;
            }
        }

        double tb = tong / 3;
        lamchon = lamchon / 3;
        if (tb % 1 > 0) {
            lamchon = lamchon + 1;
        }
        model.addAttribute("lamchon", lamchon);
        model.addAttribute("giamgia", banHangOnlineService);
        model.addAttribute("banhangonline", banHangOnlineService);
        model.addAttribute("listsp", banHangOnlineService.ctspbanhang());
        model.addAttribute("listTop10sp", banHangOnlineService.top10SanPhamBanChay());
        idkhachhang = "1";
        model.addAttribute("idkhachhang", idkhachhang);
        return "ban-hang-online/trang-chu";
    }


    @GetMapping("/ban-hang-online/home")
    public String hienThitrangchudnhome(
            Model model
    ) {
        double tong = 0;
        Integer lamchon = 0;
        for (ChiTietSanPham ct : banHangOnlineService.ctspbanhang()) {
            if (banHangOnlineService.soluongcon(String.valueOf(ct.getId())) > 0) {
                tong = tong + 1;
                lamchon = lamchon + 1;
            }
        }
        double tb = tong / 3;
        lamchon = lamchon / 3;
        if (tb % 1 > 0) {
            lamchon = lamchon + 1;
        }
        model.addAttribute("lamchon", lamchon);
        model.addAttribute("giamgia", banHangOnlineService);
        model.addAttribute("banhangonline", banHangOnlineService);


        model.addAttribute("listsp", banHangOnlineService.ctspbanhang());


//        giohang
        model.addAttribute("tttong", 1);
        if (idkhachhang.equals("1")) {
            return "redirect:/";
        } else {
            model.addAttribute("idkhachhang", UUID.fromString(idkhachhang));
            model.addAttribute("khachhangdangnhap", khachHangService.findById(UUID.fromString(idkhachhang)));
            model.addAttribute("listghct", banHangOnlineService.ListghctTheoidgh(banHangOnlineService.ListghTheoidkh(idkhachhang).get(0).getId()));
            return "ban-hang-online/trang-chu";
        }

    }

    @GetMapping("/ban-hang-online/taikhoan-matkhau")
    public String hienThitrangchudn(@AuthenticationPrincipal Authentication authentication,
                                    Model model
    ) {
        if (SecurityUtil.getId() != null) {
//            checkGMAILorTK="1";

            double tong = 0;
            Integer lamchon = 0;
            for (ChiTietSanPham ct : banHangOnlineService.ctspbanhang()) {
                if (banHangOnlineService.soluongcon(String.valueOf(ct.getId())) > 0) {
                    tong = tong + 1;
                    lamchon = lamchon + 1;
                }
            }
            double tb = tong / 3;
            lamchon = lamchon / 3;
            if (tb % 1 > 0) {
                lamchon = lamchon + 1;
            }
            model.addAttribute("lamchon", lamchon);
            model.addAttribute("giamgia", banHangOnlineService);
            model.addAttribute("banhangonline", banHangOnlineService);
            UserInfoUserDetails userDetails = SecurityUtil.getId();
            idkhachhang = String.valueOf(userDetails.getId());

            model.addAttribute("khachhangdangnhap", khachHangService.findById(UUID.fromString(idkhachhang)));
            model.addAttribute("listsp", banHangOnlineService.ctspbanhang());
            model.addAttribute("idkhachhang", idkhachhang);
//        giohang
            model.addAttribute("listghct", banHangOnlineService.ListghctTheoidgh(banHangOnlineService.ListghTheoidkh(idkhachhang).get(0).getId()));
            model.addAttribute("tttong", 1);
            return "redirect:/ban-hang-online/home";
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("/ban-hang-online/gmail")
    public String hienThitrangchudnemail(@AuthenticationPrincipal OAuth2User oauth2User,
                                         Principal principal,
                                         Model model
    ) {
        if (oauth2User != null) {
//            checkGMAILorTK="2";
            double tong = 0;
            Integer lamchon = 0;
            for (ChiTietSanPham ct : banHangOnlineService.ctspbanhang()) {

                if (banHangOnlineService.soluongcon(String.valueOf(ct.getId())) > 0) {
                    tong = tong + 1;
                    lamchon = lamchon + 1;
                }
            }
            double tb = tong / 3;
            lamchon = lamchon / 3;
            if (tb % 1 > 0) {
                lamchon = lamchon + 1;
            }
            model.addAttribute("lamchon", lamchon);
            model.addAttribute("giamgia", banHangOnlineService);
            model.addAttribute("banhangonline", banHangOnlineService);

//lay email
            String email = oauth2User.getAttribute("email");
            String name = oauth2User.getAttribute("name");
            String idToken = oauth2User.getAttribute("id_token");
            System.out.println(principal.getName());

            System.out.println(email);
            System.out.println(name);

            // Kiểm tra xem người dùng đã tồn tại trong cơ sở dữ liệu hay chưa


            if (khachHangRepository.getKhachHangByTaiKhoan(email).isEmpty()) {
                // Người dùng chưa tồn tại, tạo người dùng mới
//            GoogleId token= oauth2User.get;
                String mkh = "";
                Integer sl = khachHangService.findAll().size() + 1;
                if (sl < 10) {
                    mkh = "KH0" + sl;
                } else {
                    mkh = "KH" + sl;
                }
                List<KhachHang> khachHangList = khachHangRepository.findAll();
                String email1 = oauth2User.getAttribute("email");
                String name1 = oauth2User.getAttribute("name");
                KhachHang newUser = new KhachHang();
                newUser.setMa(mkh);
                newUser.setEmail(email1);
                newUser.setTaiKhoan(email1);
                newUser.setHoTen(name1);
                newUser.setSoDienThoai("0123456789");
                newUser.setGioiTinh(true);
                String randomPassword = LoginController.generateRandomPassword(8);
                newUser.setTaiKhoan(randomPassword);
                newUser.setNgaySinh(Date.valueOf("1999-1-1"));
                newUser.setTrangThai(0);
                newUser.setNgayTao(Date.valueOf(LocalDate.now()));
                String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";


                String hashedPassword = BCrypt.hashpw(randomPassword, BCrypt.gensalt());
                newUser.setMatKhau(hashedPassword);

                // Lưu người dùng mới vào cơ sở dữ liệu
                khachHangRepository.save(newUser);
                //      them gh
                khachHangService.findAll();
                String mghkh = "";
                Integer slgh = (gioHangService.findAll().size() + 1);
                if (slgh < 10) {
                    mghkh = "MGH0" + slgh;
                } else {
                    mghkh = "MGH" + slgh;
                }
                GioHang ghkh = new GioHang();
                ghkh.setMa(mghkh);
                for (KhachHang kh11 : khachHangService.findAll()) {
                    if (kh11.getMa().equals(mkh)) {
                        ghkh.setKhachHang(kh11);
                        idkhachhang = String.valueOf(kh11.getId());
                        break;
                    }
                }
                gioHangService.add(ghkh);
// het them gh

            } else {
                Optional<KhachHang> idkh = khachHangRepository.getKhachHangByTaiKhoan(email);
                idkhachhang = String.valueOf(idkh.get().getId());
            }

//    het lay email

            model.addAttribute("khachhangdangnhap", khachHangService.findById(UUID.fromString(idkhachhang)));
            model.addAttribute("listsp", banHangOnlineService.ctspbanhang());
            model.addAttribute("idkhachhang", idkhachhang);
//        giohang
            model.addAttribute("listghct", banHangOnlineService.ListghctTheoidgh(banHangOnlineService.ListghTheoidkh(idkhachhang).get(0).getId()));
            model.addAttribute("tttong", 1);
            return "redirect:/ban-hang-online/home";


        } else {
            return "redirect:/";
        }

    }


    @GetMapping("/ban-hang-online/balo")
    public String hienThitrangchudienthoai(
            Model model
//            @ModelAttribute("sortForm") SortForm sortForm,
//            @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan
    ) {
//
        if (idkhachhang.equals("1")) {
            model.addAttribute("idkhachhang", idkhachhang);
        } else {
            model.addAttribute("khachhangdangnhap", khachHangService.findById(UUID.fromString(idkhachhang)));
            model.addAttribute("idkhachhang", UUID.fromString(idkhachhang));
        }
//
        model.addAttribute("thds", thuongHieuService.findAll());
        model.addAttribute("kcds", kichCoService.findAll());
        model.addAttribute("mauds", mauSacService.findAll());
        model.addAttribute("cods", trongLuongService.findAll());
        model.addAttribute("clds", chatLieuService.findAll());
        model.addAttribute("sands", sanPhamService.findAll());
        double tong = 0;
        Integer lamchon = 0;
        for (ChiTietSanPham ct : banHangOnlineService.ctspbanhang()) {
            if (banHangOnlineService.soluongcon(String.valueOf(ct.getId())) > 0) {
                tong = tong + 1;
                lamchon = lamchon + 1;
            }
        }
        double tb = tong / 8;
        lamchon = lamchon / 8;
        if (tb % 1 > 0) {
            lamchon = lamchon + 1;
        }

        model.addAttribute("lamchon1", lamchon);
        model.addAttribute("giamgia", banHangOnlineService);
        model.addAttribute("banhangonline", banHangOnlineService);
        model.addAttribute("listsp", banHangOnlineService.ctspbanhang());
        //gio hang
        if (idkhachhang.equals("1")) {

        } else {
            model.addAttribute("listghct", banHangOnlineService.ListghctTheoidgh(banHangOnlineService.ListghTheoidkh(idkhachhang).get(0).getId()));
        }
        model.addAttribute("tttong", 1);
//        //gia max
        Double max = 0.0;
        for (ChiTietSanPham ct : chiTietSanPhamService.getList()) {

            if (ct.getGiaBan() > max) {
                max = ct.getGiaBan();
            }
        }
        model.addAttribute("max", String.valueOf(max));
        return "ban-hang-online/trang-loc-sanpham";
    }

    @GetMapping("/ban-hang-online/loc-ban-hang/{x1}/{x2}/{x3}/{x4}/{x5}/{x6}/{x7}/{x8}")
    public String locbanhang(
            Model model,
            @PathVariable("x1") String x1,
            @PathVariable("x2") String x2,
            @PathVariable("x3") String x3,
            @PathVariable("x4") String x4,
            @PathVariable("x5") String x5,
            @PathVariable("x6") String x6,
            @PathVariable("x7") String x7,
            @PathVariable("x8") String x8
    ) {
        double tong = 0;
        Integer lamchon = 0;
        for (ChiTietSanPham ct : banHangOnlineService.locbanhangcoGIATIEN(x1, x2, x3, x4, x5, x6, BigDecimal.valueOf(Double.valueOf(x7)), BigDecimal.valueOf(Double.valueOf(x8)))) {
            if (banHangOnlineService.soluongcon(String.valueOf(ct.getId())) > 0) {
                tong = tong + 1;
                lamchon = lamchon + 1;
            }
        }

        double tb = tong / 8;
        lamchon = lamchon / 8;
        if (tb % 1 > 0) {
            lamchon = lamchon + 1;
        }
        model.addAttribute("lamchon1", lamchon);
        model.addAttribute("giamgia", banHangOnlineService);
        model.addAttribute("banhangonline", banHangOnlineService);
        model.addAttribute("listsp", banHangOnlineService.locbanhangcoGIATIEN(x1, x2, x3, x4, x5, x6,BigDecimal.valueOf(Double.valueOf(x7)), BigDecimal.valueOf(Double.valueOf(x8))));

        return "ban-hang-online/single_pase_giao-dien-loc";
    }


    @GetMapping("/ban-hang-online/chi-tiet-san-pham/{idctsp}")
    public String giohang(
            Model model,
            @PathVariable("idctsp") UUID idctsp

    ) {
        if (idkhachhang.equals("1")) {
            model.addAttribute("idkhachhang", idkhachhang);
        } else {
            model.addAttribute("khachhangdangnhap", khachHangService.findById(UUID.fromString(idkhachhang)));
            model.addAttribute("idkhachhang", UUID.fromString(idkhachhang));
        }
//        chi tiêt san pham
        model.addAttribute("ktcokhong", 1);
        model.addAttribute("listsp", banHangOnlineService.ctspbanhang());
        model.addAttribute("banhangonline", banHangOnlineService);
        model.addAttribute("motctsp", chiTietSanPhamService.findById(idctsp));
        System.out.println(chiTietSanPhamService.findById(idctsp).getSoLuongTon());
        model.addAttribute("idctsp", idctsp);
//gio hang
        if (idkhachhang.equals("1")) {
        } else {
            model.addAttribute("listghct", banHangOnlineService.ListghctTheoidgh(banHangOnlineService.ListghTheoidkh(idkhachhang).get(0).getId()));
        }
        model.addAttribute("tttong", 1);

//danh sách sản phẩm dưới

        double tong = 0;
        Integer lamchon = 0;
        for (ChiTietSanPham ct : banHangOnlineService.ctspbanhang()) {
            if (banHangOnlineService.soluongcon(String.valueOf(ct.getId())) > 0) {
                tong = tong + 1;
                lamchon = lamchon + 1;
            }
        }
        double tb = tong / 8;
        lamchon = lamchon / 8;
        if (tb % 1 > 0) {
            lamchon = lamchon + 1;
        }
        model.addAttribute("lamchon1", lamchon);
        model.addAttribute("giamgia", banHangOnlineService);

        model.addAttribute("listsp", banHangOnlineService.ctspbanhang());

        return "ban-hang-online/trang-chi-tiet-san-pham";


    }


    @GetMapping("/ban-hang-online/loc-chi-tiet-san-pham/{x1}/{x2}/{x3}")
    public String locbanhangctsp(
            Model model,
            @PathVariable("x1") String x1,
            @PathVariable("x2") String x2,
            @PathVariable("x3") String x3

    ) {
        List<ChiTietSanPham> listctsp = banHangOnlineService.locbanhang( x1, x2, x3);

        ChiTietSanPham motctsp = new ChiTietSanPham();
        int kt = 0;
        for (ChiTietSanPham ht : listctsp) {
            if (banHangOnlineService.soluongcon(String.valueOf(ht.getId())) > 0) {
                kt = 1;
                motctsp = ht;
                break;
            }
        }
        System.out.println("taco-" + listctsp.size());

        model.addAttribute("tensp", x3);
        model.addAttribute("ktcokhong", kt);
        model.addAttribute("motctsp", motctsp);
        model.addAttribute("listsp", banHangOnlineService.ctspbanhang());
        model.addAttribute("banhangonline", banHangOnlineService);

        if (idkhachhang.equals("1")) {
            model.addAttribute("idkhachhang", idkhachhang);
        } else {
            model.addAttribute("khachhangdangnhap", khachHangService.findById(UUID.fromString(idkhachhang)));
            model.addAttribute("idkhachhang", UUID.fromString(idkhachhang));
        }
        return "ban-hang-online/single_page_chi-tiet-san-pham";
    }

    @PostMapping("/ban-hang-online/trang-chi-tiet-san-pham/thanh-toan")
    public String nutthanhtoanctsp(
            Model model,
            @RequestParam("idkh") String idkh,
            @RequestParam("idctsp") UUID idctsp,
            @RequestParam("solg") Integer soluong
    ) {

        if (banHangOnlineService.ListghctTheoIdghvsIdctsp(banHangOnlineService.ListghTheoidkh(idkh).get(0).getId(), idctsp).size() > 0) {
            GioHangChiTiet ghctud = banHangOnlineService.ListghctTheoIdghvsIdctsp(banHangOnlineService.ListghTheoidkh(idkh).get(0).getId(), idctsp).get(0);
            ghctud.setSoLuong(soluong);
            ghctud.setTinhTrang(0);
            gioHangChiTietService.add(ghctud);
            banHangOnLinerepository.updatelaighctve1trumotIDGH(ghctud.getId());
        } else {
            GioHangChiTiet ghct = new GioHangChiTiet();
            ghct.setGioHang(banHangOnlineService.ListghTheoidkh(idkh).get(0));
            ghct.setChiTietSanPham(chiTietSanPhamService.findById(idctsp));
            ghct.setSoLuong(soluong);
            ghct.setTinhTrang(0);
            ghct.setDonGia(chiTietSanPhamService.findById(idctsp).getGiaBan());
            Double giaban = chiTietSanPhamService.findById(idctsp).getGiaBan();
            ghct.setDonGiaKhiGiam(giaban);
            gioHangChiTietService.add(ghct);
            banHangOnLinerepository.updatelaighctve1trumotIDGH(banHangOnLinerepository.ListghctTheoIdghvsIdctsp(banHangOnlineService.ListghTheoidkh(idkh).get(0).getId(), chiTietSanPhamService.findById(idctsp).getId()).get(0).getId());
        }

        model.addAttribute("listghct", banHangOnlineService.ListghctTheoidgh(banHangOnlineService.ListghTheoidkh(idkh).get(0).getId()));
        model.addAttribute("tttong", 1);
        model.addAttribute("banhangonline", banHangOnlineService);
        if (idkhachhang.equals("1")) {
            model.addAttribute("idkhachhang", idkhachhang);
        } else {
            model.addAttribute("khachhangdangnhap", khachHangService.findById(UUID.fromString(idkhachhang)));
            model.addAttribute("idkhachhang", UUID.fromString(idkhachhang));
        }
//        return "ban-hang-online/trang-gio-hang-chi-tiet";
        return "redirect:/ban-hang-online/san-pham-duoc-chon-thanh-toan/nut-mua-hang/" + banHangOnlineService.ListghTheoidkh(idkh).get(0).getId();

    }


    @GetMapping("/ban-hang-online/trang-gio-hang-chi-tiet/so-luong/{idghct}/{solg}")
    public String updateslghct(
            Model model,
            @PathVariable("idghct") UUID idghct,
            @PathVariable("solg") Integer soluong
    ) {


        GioHangChiTiet ghct = gioHangChiTietService.findById(idghct);
        ghct.setSoLuong(soluong);
        gioHangChiTietService.add(ghct);
        model.addAttribute("listghct", banHangOnlineService.ListghctTheoidgh(banHangOnlineService.ListghTheoidkh(String.valueOf(ghct.getGioHang().getKhachHang().getId())).get(0).getId()));
        model.addAttribute("banhangonline", banHangOnlineService);
        model.addAttribute("tttong", 1);
        if (idkhachhang.equals("1")) {
            model.addAttribute("idkhachhang", idkhachhang);
        } else {
            model.addAttribute("khachhangdangnhap", khachHangService.findById(UUID.fromString(idkhachhang)));
            model.addAttribute("idkhachhang", UUID.fromString(idkhachhang));
        }
        return "ban-hang-online/single_page_gio_hang_chi_tiet";
    }


}



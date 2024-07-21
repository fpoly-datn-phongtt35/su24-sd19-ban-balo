package com.example.datntest.controller;


import com.example.datntest.entity.DiaChi;
import com.example.datntest.entity.HangKhachHang;
import com.example.datntest.entity.KhachHang;
import com.example.datntest.repository.KhachHangRepository;
import com.example.datntest.service.DiaChiService;
import com.example.datntest.service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private DiaChiService diaChiService;

    @GetMapping("/khach-hang/get-all")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page page = khachHangService.getAll(pages);
        model.addAttribute("list", page);
        return "/get-all";
    }
//    @GetMapping("/khach-hang/get-all")
//    public String hienThi(Model model, @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
//                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @ModelAttribute("khachHang") KhachHang khachHang, @ModelAttribute("addDiaChi") DiaChi diaChi) {
//        Pageable pageable = PageRequest.of(pageNum, pageSize);
//        Page<KhachHang> page = khachHangService.getAll(pageable);
//        model.addAttribute("listKhachHang", page.getContent());
//        model.addAttribute("totalPage", page.getTotalPages());
//        model.addAttribute("contentPage", "../khachhang/hien-thi.jsp");
//        return "/get-all";
//    }

    @GetMapping("/khach-hang/view-add")
    private String viewAdd() {
        return "/add";
    }

    @PostMapping("/khach-hang/add")
    private String add(@RequestParam("maKhachHang") String maKhachHang,
                       @RequestParam("tenKhachHang") String tenKhachHang,
                       @RequestParam("hoKhachHang") String hoKhachHang,
                       @RequestParam("ngaySinh") String ngaySinh,
                       @RequestParam("gioiTinh") Integer gioiTinh,
                       @RequestParam("sdt") String sdt,
                       @RequestParam("cccd") String cccd,
                       @RequestParam("idHangKhachHang") HangKhachHang idHangKhachHang,
                       @RequestParam("diemTichLuy") Integer diemTichLuy,
                       @RequestParam("ngayTao") String ngayTao,
                       @RequestParam("ngaySua") String ngaySua,
                       @RequestParam("trangThai") Integer trangThai) {
        KhachHang khachHang = KhachHang.builder()
                .maKhachHang(maKhachHang)
                .tenKhachHang(tenKhachHang)
                .hoKhachHang(hoKhachHang)
                .ngaySinh(Date.valueOf(ngaySinh))
                .gioiTinh(gioiTinh)
                .sdt(sdt)
                .cccd(cccd)
                .hangKhachHang(idHangKhachHang)
                .diemTichLuy(diemTichLuy)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/get-all";
    }
    @GetMapping("/khach-hang/delete/{idKhachHang}")
    public String delete(@PathVariable("idKhachHang") Integer idKhachHang) {
        khachHangService.delete(idKhachHang);
        return "redirect:/khach-hang/get-all";
    }
    @GetMapping("/khach-hang/detail/{idKhachHang}")
    public String detail(@PathVariable("idKhachHang") Integer idKhachHang, Model model) {
        KhachHang khachHang = khachHangService.detail(idKhachHang);
        model.addAttribute("kh", khachHang);
        return "redirect:/khach-hang/get-all";
    }
    @GetMapping("/khach-hang/view-update/{idKhachHang}")
    public String view(@PathVariable("idKhachHang") Integer idKhachHang, Model model) {
        KhachHang khachHang = khachHangService.detail(idKhachHang);
        model.addAttribute("kh", khachHang);
        return "/update";
    }
    @GetMapping("/editCustomer/{id}")
    public String showEditForm(@PathVariable("idKhachHang") Integer idKhachHang, Model model) {
        KhachHang khachHang = khachHangRepository.findById(idKhachHang)
                .orElseThrow(() -> new IllegalArgumentException("Ko tim dc Id:" + idKhachHang));
        model.addAttribute("kh", khachHang);
        return "/update";
    }

    @PostMapping("/khach-hang/update/{idKhachHang}")
    public String update1(@PathVariable("idKhachHang") Integer idKhachHang, @ModelAttribute("kh") KhachHang updatedCustomer) {
        KhachHang khachHang = khachHangRepository.findById(idKhachHang)
                .orElseThrow(() -> new RuntimeException("Khong tim thay "));

        khachHang.setMaKhachHang(updatedCustomer.getMaKhachHang());
        khachHang.setTenKhachHang(updatedCustomer.getTenKhachHang());
        khachHang.setHoKhachHang(updatedCustomer.getHoKhachHang());
        khachHang.setNgaySinh(updatedCustomer.getNgaySinh());
        khachHang.setGioiTinh(updatedCustomer.getGioiTinh());
        khachHang.setSdt(updatedCustomer.getSdt());
        khachHang.setCccd(updatedCustomer.getCccd());
        khachHang.setHangKhachHang(updatedCustomer.getHangKhachHang());
        khachHang.setDiemTichLuy(updatedCustomer.getDiemTichLuy());
        khachHang.setNgayTao(updatedCustomer.getNgayTao());
        khachHang.setNgaySua(updatedCustomer.getNgaySua());
        khachHang.setTrangThai(updatedCustomer.getTrangThai());

        khachHangRepository.save(khachHang);
        return "redirect:/khach-hang/get-all";
    }
    @GetMapping("khach-hang/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/khach-hang/search")
    public String showSearchForm() {
        return "get-all";
    }

    @GetMapping("/khach-hang/searchForm")
    public String searchByTenSanPham(@RequestParam("tenKhachHang") String tenKhachHang,
                                     @RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "size", defaultValue = "10") int size,
                                     Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<KhachHang> list = khachHangService.searchByTenKhachHang(tenKhachHang, pageable);
        model.addAttribute("list", list);
        return "/search";
    }

    @GetMapping("/khach-hang/danh-sach-dia-chi/{idKhachHang}")
    public String danhSachDiaChi(Model model, @ModelAttribute("khachHang") KhachHang KhachHang
            , @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @PathVariable("idKhachHang") Integer idKhachHang, @ModelAttribute("addDiaChi") DiaChi diaChi) {
        List<DiaChi> list = diaChiService.danhSachDiaChi(idKhachHang);
        model.addAttribute("listDiaChi", list);
        model.addAttribute("batmodaldanhsachdiachi", 0);
        PageRequest pageable = PageRequest.of(pageNum, pageSize);
        Page<KhachHang> page = khachHangService.getAll(pageSize);
        model.addAttribute("listKhachHang", page.getContent());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("contentPage", "../khachhang/get-all.jsp");
        return "hien-thi";
    }
}


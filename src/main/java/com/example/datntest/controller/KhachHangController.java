package com.example.datntest.controller;


import com.example.datntest.entity.HangKhachHang;
import com.example.datntest.entity.KhachHang;
import com.example.datntest.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.UUID;

@Controller
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/khach-hang/get-all")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page page = khachHangService.getAll(pages);
        model.addAttribute("list", page);
        return "/get-all";
    }

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
                       @RequestParam("soNha") String soNha,
                       @RequestParam("phuongXa") String phuongXa,
                       @RequestParam("quanHuyen") String quanHuyen,
                       @RequestParam("tinhThanhPho") String tinhThanhPho,
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
                .soNha(soNha)
                .phuongXa(phuongXa)
                .quanHuyen(quanHuyen)
                .tinhThanhPho(tinhThanhPho)
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
    @PostMapping("/khach-hang/update/{idKhachHang}")
    private String update(@PathVariable("idKhachHang") Integer idKhachHang,
                        @RequestParam("maKhachHang") String maKhachHang,
                       @RequestParam("tenKhachHang") String tenKhachHang,
                       @RequestParam("hoKhachHang") String hoKhachHang,
                       @RequestParam("ngaySinh") String ngaySinh,
                       @RequestParam("gioiTinh") Integer gioiTinh,
                       @RequestParam("sdt") String sdt,
                       @RequestParam("cccd") String cccd,
                       @RequestParam("idHangKhachHang") HangKhachHang idHangKhachHang,
                       @RequestParam("soNha") String soNha,
                       @RequestParam("phuongXa") String phuongXa,
                       @RequestParam("quanHuyen") String quanHuyen,
                       @RequestParam("tinhThanhPho") String tinhThanhPho,
                       @RequestParam("diemTichLuy") Integer diemTichLuy,
                       @RequestParam("ngayTao") String ngayTao,
                       @RequestParam("ngaySua") String ngaySua,
                       @RequestParam("trangThai") Integer trangThai) {
        KhachHang khachHang = khachHangService.detail(idKhachHang);
        khachHang.setMaKhachHang(maKhachHang);
        khachHang.setTenKhachHang(tenKhachHang);
        khachHang.setHoKhachHang(hoKhachHang);
        khachHang.setNgaySinh(Date.valueOf(ngaySinh));
        khachHang.setGioiTinh(gioiTinh);
        khachHang.setSdt(sdt);
        khachHang.setCccd(cccd);
        khachHang.setHangKhachHang(idHangKhachHang);
        khachHang.setSoNha(soNha);
        khachHang.setPhuongXa(phuongXa);
        khachHang.setQuanHuyen(quanHuyen);
        khachHang.setTinhThanhPho(tinhThanhPho);
        khachHang.setDiemTichLuy(diemTichLuy);
        khachHang.setNgayTao(Date.valueOf(ngayTao));
        khachHang.setNgaySua(Date.valueOf(ngaySua));
        khachHang.setTrangThai(trangThai);
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/get-all";
    }
}


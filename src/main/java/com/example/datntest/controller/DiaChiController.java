package com.example.datntest.controller;

import com.example.datntest.entity.*;
import com.example.datntest.repository.DiaChiReposiroty;
import com.example.datntest.repository.KhachHangRepository;
import com.example.datntest.service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api")

public class DiaChiController {
    @Autowired
    private DiaChiReposiroty diaChiReposiroty;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping("/diachi")
    public String getDiaChiForm(Model model, HttpSession session) {
        model.addAttribute("diaChi", new DiaChi());

        KhachHang ses = (KhachHang) session.getAttribute("user");
        if(ses == null) return "redirect:/login";
        KhachHang khachHang = khachHangRepository.findById(ses.getIdKhachHang()).get();
        model.addAttribute("kh", khachHang);
        for (DiaChi diaChi : khachHang.getDiaChiList()) {
            System.out.println(diaChi.getCity());
        }
        return "/dia-chi";
    }

    @PostMapping("/updateInfo")
    public String updateInfo(@ModelAttribute("kh") KhachHang updatedCustomer,
                                Model model, @RequestParam("city") String city,
                             @RequestParam("district") String district,
                             @RequestParam("ward") String ward, HttpSession session) {
        KhachHang khachHang = (KhachHang) session.getAttribute("user");
        List<DiaChi> list;
        if(!khachHang.getDiaChiList().isEmpty()){
            list   = khachHang.getDiaChiList();
        }else {
            list   = new ArrayList<>();
        }
        DiaChi diaChi = new DiaChi();
        diaChi.setCity(city);
        diaChi.setDistrict(district);
        diaChi.setWard(ward);
        diaChi.setKhachHang(khachHang);
        list.add(diaChi);
        khachHang.setDiaChiList(list);

        khachHang.setMaKhachHang(updatedCustomer.getMaKhachHang());
        khachHang.setTenKhachHang(updatedCustomer.getTenKhachHang());
        khachHang.setHoKhachHang(updatedCustomer.getHoKhachHang());
        khachHang.setNgaySinh(updatedCustomer.getNgaySinh());
        khachHang.setGioiTinh(updatedCustomer.getGioiTinh());
        khachHang.setSdt(updatedCustomer.getSdt());
        khachHang.setCccd(updatedCustomer.getCccd());
        khachHang.setHangKhachHang(updatedCustomer.getHangKhachHang());
        khachHang.setDiemTichLuy(updatedCustomer.getDiemTichLuy());
        khachHang.setNgaySua(new Date());
        khachHang.setTrangThai(updatedCustomer.getTrangThai());

        diaChiReposiroty.saveAndFlush(diaChi);
        khachHangRepository.saveAndFlush(khachHang);
        return "/dia-chi";
    }
    @GetMapping("/updateInfo/{idKhachHang}")
    public String view(@PathVariable("idKhachHang") Integer idKhachHang, Model model) {
        KhachHang khachHang = khachHangService.detail(idKhachHang);
        model.addAttribute("kh", khachHang);
        return "/update";
    }
}

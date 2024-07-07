package com.example.datntest.controller;

import com.example.datntest.entity.*;
import com.example.datntest.repository.DiaChiReposiroty;
import com.example.datntest.repository.KhachHangRepository;
import com.example.datntest.service.DiaChiService;
import com.example.datntest.service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public String getDiaChiForm(Model model) {
        model.addAttribute("diaChi", new DiaChi());
        KhachHang khachHang = khachHangRepository.findById(2).get();
        for (DiaChi kh:
                khachHang.getDiaChiList()) {
            System.out.println(kh.getCity());
        }
        System.out.println();
        return "/dia-chi";
    }

    @PostMapping("/updateInfo")
    public String updateInfo(Model model, @RequestParam("city") String city,
                             @RequestParam("district") String district,
                             @RequestParam("ward") String ward, HttpSession session) {
        KhachHang khachHang1 = (KhachHang) session.getAttribute("user");
//        session.getAttribute(String.valueOf(khachHang1));
        List<DiaChi> list;
        if(!khachHang1.getDiaChiList().isEmpty()){
            list   = khachHang1.getDiaChiList();
        }else {
            list   = new ArrayList<>();
        }
        DiaChi diaChi = new DiaChi();
        diaChi.setCity(city);
        diaChi.setDistrict(district);
        diaChi.setWard(ward);
        diaChi.setKhachHang(khachHang1);
        list.add(diaChi);
        khachHang1.setDiaChiList(list);
//        DiaChi diaChi1 = diaChiReposiroty.findById(""id);
//        if(diaChi1 == null){
//            diaChiReposiroty.save(diaChi);
//        }else {
//            diaChi.setIdDiaChi(diaChi1.getIdDiaChi());
//            diaChiReposiroty.save(diaChi);
//        }
        diaChiReposiroty.save(diaChi);
        khachHangRepository.save(khachHang1);
        return "/dia-chi";
    }
}

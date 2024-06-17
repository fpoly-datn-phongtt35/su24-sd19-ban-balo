package com.example.datntest.controller;

import com.example.datntest.entity.Phuong;
import com.example.datntest.entity.Quan;
import com.example.datntest.entity.Tinh;
import com.example.datntest.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/api/diachi")

public class DiaChiController {
    @Autowired
    private DiaChiService diaChiService;
    @GetMapping("/diachi")
    public String getDiaChiForm(Model model) {
        List<Tinh> tinhList = diaChiService.getAllTinh();
        model.addAttribute("tinhList", tinhList);
        return "/dia-chi";
    }

    @GetMapping("/quan/{tinhIdTinh}")
    public List<Quan> getQuanByTinhId(@PathVariable Integer tinhIdTinh) {
        return diaChiService.getQuanByTinhIdTinh(tinhIdTinh);
    }

    @GetMapping("/phuong/{quanIdQuan}")
    public List<Phuong> getPhuongByQuanId(@PathVariable Integer quanIdQuan) {
        return diaChiService.getPhuongByQuanIdQuan(quanIdQuan);
    }
}

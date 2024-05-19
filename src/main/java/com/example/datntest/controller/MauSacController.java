package com.example.datntest.controller;

import com.example.datntest.entity.MauSac;
import com.example.datntest.entity.Size;
import com.example.datntest.service.MauSacService;
import com.example.datntest.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;


    @GetMapping("/mausac/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<MauSac> page = mauSacService.getAll(pages);
        model.addAttribute("list", page);
        return "/mausac/get-all";
    }
    @GetMapping("/mausac/view-add")
    private String viewAdd() {
        return "mausac/add";
    }
    @PostMapping("/mausac/add")
    public String add(@RequestParam("maMauSac")String maMauSac,
                      @RequestParam("tenMauSac") String tenMauSac,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        MauSac mauSac = MauSac.builder()
                .maMauSac(maMauSac)
                .tenMauSac(tenMauSac)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        mauSacService.add(mauSac);
        return "redirect:/mausac/hien-thi";
    }
}

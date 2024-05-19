package com.example.datntest.controller;

import com.example.datntest.entity.Hang;
import com.example.datntest.entity.Size;
import com.example.datntest.service.HangService;
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
public class HangController {

    @Autowired
    private HangService hangService;


    @GetMapping("/hang/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<Hang> page = hangService.getAll(pages);
        model.addAttribute("list", page);
        return "/hang/get-all";
    }
    @GetMapping("/hang/view-add")
    private String viewAdd() {
        return "hang/add";
    }
    @PostMapping("/hang/add")
    public String add(@RequestParam("maHang")String maHang,
                      @RequestParam("tenHang") String tenHang,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        Hang hang = Hang.builder()
                .maHang(maHang)
                .tenHang(tenHang)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        hangService.add(hang);
        return "redirect:/hang/hien-thi";
    }
}

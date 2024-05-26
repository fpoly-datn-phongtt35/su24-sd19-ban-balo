package com.example.datntest.controller;

import com.example.datntest.entity.Anh;
import com.example.datntest.service.AnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class AnhController {

    @Autowired
    private AnhService anhService;


    @GetMapping("/anh/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<Anh> page = anhService.getAll(pages);
        model.addAttribute("list", page);
        return "/anh/get-all";
    }
    @GetMapping("/anh/view-add")
    private String viewAdd() {
        return "anh/add";
    }
    @PostMapping("/anh/add")
    public String add(
                      @RequestParam("url") String url,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        Anh anh = Anh.builder()
                .url(url)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        anhService.add(anh);
        return "redirect:/anh/hien-thi";
    }
}

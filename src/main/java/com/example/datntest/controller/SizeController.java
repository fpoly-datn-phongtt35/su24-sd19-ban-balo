package com.example.datntest.controller;

import com.example.datntest.entity.Size;
import com.example.datntest.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class SizeController {

    @Autowired
    private SizeService sizeService;


    @GetMapping("/size/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<Size> page = sizeService.getAll(pages);
        model.addAttribute("list", page);
        return "/size/get-all";
    }
    @GetMapping("/size/view-add")
    private String viewAdd() {
        return "size/add";
    }
    @PostMapping("/size/add")
    public String add(@RequestParam("maSize")String maSize,
                      @RequestParam("tenSize") String tenSize,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        Size size = Size.builder()
                .maSize(maSize)
                .tenSize(tenSize)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        sizeService.add(size);
        return "redirect:/size/hien-thi";
    }
}

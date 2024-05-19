package com.example.datntest.controller;

import com.example.datntest.entity.SanPham;
import com.example.datntest.entity.Size;
import com.example.datntest.service.SanPhamService;
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
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;


    @GetMapping("/sanpham/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<SanPham> page = sanPhamService.getAll(pages);
        model.addAttribute("list", page);
        return "/sanpham/get-all";
    }
    @GetMapping("/sanpham/view-add")
    private String viewAdd() {
        return "sanpham/add";
    }
    @PostMapping("/sanpham/add")
    public String add(@RequestParam("maSanPham")String maSanPham,
                      @RequestParam("tenSanPham") String tenSanPham,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        SanPham sanPham = SanPham.builder()
                .maSanPham(maSanPham)
                .tenSanPham(tenSanPham)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        sanPhamService.add(sanPham);
        return "redirect:/sanpham/hien-thi";
    }
}

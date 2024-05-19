package com.example.datntest.controller;

import com.example.datntest.entity.DongSanPham;
import com.example.datntest.entity.SanPham;
import com.example.datntest.service.DongSanPhamService;
import com.example.datntest.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class DongSanPhamController {

    @Autowired
    private DongSanPhamService dongSanPhamService;


    @GetMapping("/dongsanpham/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<DongSanPham> page = dongSanPhamService.getAll(pages);
        model.addAttribute("list", page);
        return "/dongsanpham/get-all";
    }
    @GetMapping("/dongsanpham/view-add")
    private String viewAdd() {
        return "dongsanpham/add";
    }
    @PostMapping("/dongsanpham/add")
    public String add(@RequestParam("maDongSanPham")String maDongSanPham,
                      @RequestParam("tenDongSanPham") String tenDongSanPham,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        DongSanPham dongSanPham = DongSanPham.builder()
                .maDongSanPham(maDongSanPham)
                .tenDongSanPham(tenDongSanPham)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        dongSanPhamService.add(dongSanPham);
        return "redirect:/dongsanpham/hien-thi";
    }
}

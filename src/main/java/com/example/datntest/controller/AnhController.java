package com.example.datntest.controller;

import com.example.datntest.entity.NSX;
import com.example.datntest.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class NSXController {

    @Autowired
    private NSXService nsxService;


    @GetMapping("/nsx/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<NSX> page = nsxService.getAll(pages);
        model.addAttribute("list", page);
        return "/nsx/get-all";
    }
    @GetMapping("/nsx/view-add")
    private String viewAdd() {
        return "nsx/add";
    }
    @PostMapping("/nsx/add")
    public String add(@RequestParam("maNSX")String maNSX,
                      @RequestParam("tenNSX") String tenNSX,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        NSX nsx = NSX.builder()
                .maNSX(maNSX)
                .tenNSX(Date.valueOf(tenNSX))
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        nsxService.add(nsx);
        return "redirect:/nsx/hien-thi";
    }
}

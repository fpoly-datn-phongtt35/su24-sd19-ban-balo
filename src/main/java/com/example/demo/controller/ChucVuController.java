package com.example.demo.controller;

import com.example.demo.model.ChucVu;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.impl.ChucVuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chuc-vu/")
public class ChucVuController {
    @Autowired
    ChucVuService chucVuService;
    @Autowired
    ChucVuServiceImpl chucVuService1;
    @GetMapping("/hien-thi")
    public String page(
            Model m,
            @ModelAttribute("sp") ChucVu sp,
            @RequestParam(defaultValue = "0") int a
    ) {
        chucVuService.getAll();
        m.addAttribute("listSP", chucVuService.page(a,5));
        m.addAttribute("sp", sp);
        return "indexChucVu";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id,
                         Model m,
                         @ModelAttribute ChucVu sp
    ) {
        chucVuService.detail(id);
        m.addAttribute("listSP", chucVuService.getAll());
        m.addAttribute("sp", chucVuService.detail(id));
        return "detailChucVu";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id,
            Model m,
            @ModelAttribute ChucVu sp
    ) {
        chucVuService.delete(id);
        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("/add")
    public String add(
            Model m,
            @ModelAttribute ChucVu sp
    ) {
        chucVuService.add(sp);
        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable Long id,
            Model m,
            @ModelAttribute ChucVu sp
    ) {
        chucVuService.update(sp, id);
        return "redirect:/chuc-vu/hien-thi";
    }
}

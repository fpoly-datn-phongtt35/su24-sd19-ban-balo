package com.example.datntest.controller;

import com.example.datntest.entity.Size;
import com.example.datntest.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}

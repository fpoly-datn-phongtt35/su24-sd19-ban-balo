package com.example.datntest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kh")
public class TrangChuController {
    @GetMapping("/trang-chu")
    public String trangChu() {
        return "/trang-chu";
    }
}

package com.example.datntest.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class QuanLyController {
    @GetMapping("/quanly/hien-thi")
    private String hienthi(){
        return "/quanly/get-all";
    }
}

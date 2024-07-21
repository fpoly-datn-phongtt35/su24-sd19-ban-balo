package com.example.datntest.controller;

import com.example.datntest.entity.KhachHang;
import com.example.datntest.entity.Users;
import com.example.datntest.repository.UserRepository;
import com.example.datntest.service.KhachHangService;
import com.example.datntest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/tai-khoan")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/dang-ki")
    public String dangKi(Model model
    ) {
        return "/dang-ki";
    }

    @PostMapping("/dang-ki/add")
    public String addTaiKhoan(Model model,
                              @RequestParam("email") String email,
                              @RequestParam("passWord") String passWord
    ) {
        KhachHang newKhachHang = KhachHang.builder().ngayTao(new Date()).build();
        KhachHang savedKhachHang = this.khachHangService.add(newKhachHang);


        //1:kh,0:nv
        int trangThai = 1;
        Users users = Users.builder()
                .email(email)
                .passWord(passWord)
                .khachHang(savedKhachHang)
                .trangThai(trangThai)
                .build();

        this.userService.addAccount(users);
        // quay vè trang dang nhap
        return "redirect:/login";
    }
    @GetMapping("/quen-mat-khau")
    public String quenMatKhau(Model model, @ModelAttribute("khachHang") KhachHang khachHang) {
        return "/quen-mat-khau";
    }
}

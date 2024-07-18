package com.example.datntest.controller;

import com.example.datntest.entity.User;
import com.example.datntest.repository.UserRepository;
import com.example.datntest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tai-khoan")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/dang-ki")
    public String dangKi(Model model
    ) {
        return "/dang-ki";
    }

    @PostMapping("/dang-ki/add")
    public String addTaiKhoan(Model model,
                              @RequestParam("taiKhoan") String taiKhoan,
                              @RequestParam("matKhau") String matKhau,
                              @RequestParam("sdt") String sdt
    ) {
        int role = 1;
        User user = User.builder()
                .taiKhoan(taiKhoan)
                .matKhau(matKhau)
                .sdt(sdt)
                .build();

        this.userService.addAccount(user);
        // quay vè trang dang nhap
        return "redirect:/login";
    }
}

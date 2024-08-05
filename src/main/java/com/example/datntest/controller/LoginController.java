package com.example.datntest.controller;

import com.example.datntest.entity.User;
import com.example.datntest.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;

    @GetMapping
    public String hienThiFormLogin() {
        return "/login-form";
    }
    @PostMapping
    public String login(@RequestParam("taiKhoan") String taiKhoan, @RequestParam("matKhau") String matKhau) {
        User user = userService.findBytaiKhoanAndmatKhau(taiKhoan, matKhau);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/khach-hang/get-all";
        } else {
            return "redirect:/login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

package com.example.datntest.controller;

import com.example.datntest.entity.Users;
import com.example.datntest.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String hienThiFormLogin() {
        return "/login-form";
    }

    @PostMapping
    public String login(@RequestParam("email") String email, @RequestParam("passWord") String passWord,HttpSession session) {
        Users users = userService.findByEmailAndPassword(email, passWord);
        if (users != null) {
            if (users.getTrangThai() == 1) {
                //  chuyen den trang voi quyen khach hang
                session.setAttribute("user", users.getKhachHang());
                return "redirect:/kh/trang-chu";
            } else {
                // chuyen den trang voi quyen nhan vien
                return "redirect:/index";
            }

        } else {
            return "redirect:/login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }
}

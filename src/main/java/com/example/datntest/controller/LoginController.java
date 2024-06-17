package com.example.datntest.controller;

import com.example.datntest.entity.Users;
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
        return "/test";
    }

    @PostMapping
    public String login(@RequestParam("email") String email, @RequestParam("passWord") String passWord) {
        Users users = userService.findByEmailAndPassword(email, passWord);
        if (users != null) {
            session.setAttribute("user", users);
            if (users.getTrangThai() == 1) {
                //  chuyen den trang voi quyen khach hang
                return "redirect:/khach-hang/get-all";
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
        session.invalidate();
        return "redirect:/login";
    }
}

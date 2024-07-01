package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.sevice.KhachHangService;
import com.example.demo.sevice.UserService;
import com.example.demo.utility.MailUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginRegisterController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final MailUtility mailUtility;
    private final KhachHangService khachHangService;


    @GetMapping("/login")
    public String formLogin(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "Auth/login";
    }
    @GetMapping("/login-handle")
    public String afterHandleLogin(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String formRegister(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "Auth/register";
    }

    
}

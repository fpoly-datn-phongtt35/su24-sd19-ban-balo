package com.example.demo.controller;

import com.example.demo.dto.ChangePasswordDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.service.UserService;
import com.example.demo.utility.MailUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@RequiredArgsConstructor
public class LoginRegisterController {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final MailUtility mailUtility;

    @GetMapping("/login")
    public String formLogin(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "/login-form";
    }

    @GetMapping("/login-handle")
    public String afterHandleLogin(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "redirect:/login";
    }


    @GetMapping("/change-password")
    public String change(Model model) {
        model.addAttribute("newMessage", "");
        model.addAttribute("confirmMessage", "");
        model.addAttribute("changePassword", new ChangePasswordDto());
        return "";
    }

}

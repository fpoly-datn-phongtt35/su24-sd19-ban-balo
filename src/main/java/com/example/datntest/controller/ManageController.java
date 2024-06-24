package com.example.datntest.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManageController {
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        session.setAttribute("active", 1);


        model.addAttribute("pageName", "dashboard");
//        session.setAttribute("active", 2);
        return "manage/indexManage"; // Trả về tên của file JSP chính (home.jsp)
    }
    @GetMapping("/product")
    public String product(Model model, HttpSession session) {
        session.setAttribute("active", 2);

        model.addAttribute("pageName", "product");
//        session.setAttribute("active", 2);
        return "manage/indexManage"; // Trả về tên của file JSP chính (home.jsp)
    }
}

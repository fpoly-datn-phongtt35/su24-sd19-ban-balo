package com.example.datntest.controller;

import com.example.datntest.entity.ChatLieu;
import com.example.datntest.entity.Size;
import com.example.datntest.service.ChatLieuService;
import com.example.datntest.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class ChatLieuController {

    @Autowired
    private ChatLieuService chatLieuService;


    @GetMapping("/chatlieu/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<ChatLieu> page = chatLieuService.getAll(pages);
        model.addAttribute("list", page);
        return "/chatlieu/get-all";
    }
    @GetMapping("/chatlieu/view-add")
    private String viewAdd() {
        return "chatlieu/add";
    }
    @PostMapping("/chatlieu/add")
    public String add(@RequestParam("machatLieu")String maChatLieu,
                      @RequestParam("tenchatLieu") String tenChatLieu,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        ChatLieu chatLieu = ChatLieu.builder()
                .machatLieu(maChatLieu)
                .tenchatLieu(tenChatLieu)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        chatLieuService.add(chatLieu);
        return "redirect:/chatlieu/hien-thi";
    }
}

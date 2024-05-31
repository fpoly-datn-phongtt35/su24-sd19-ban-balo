package com.example.datntest.controller;

import com.example.datntest.entity.ChatLieu;
import com.example.datntest.repository.ChatLieuRepository;
import com.example.datntest.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class ChatLieuController {

    @Autowired
    private ChatLieuService chatLieuService;

    @Autowired
    private ChatLieuRepository chatLieuRepository;

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
    public String add(@RequestParam("maChatLieu")String maChatLieu,
                      @RequestParam("tenChatLieu") String tenChatLieu,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        ChatLieu chatLieu = ChatLieu.builder()
                .maChatLieu(maChatLieu)
                .tenChatLieu(tenChatLieu)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        chatLieuService.add(chatLieu);
        return "redirect:/chatlieu/hien-thi";
    }
    //xóa
    @GetMapping("/chatlieu/delete/{idChatLieu}")
    public String delete(@PathVariable("idChatLieu") Integer id){
        chatLieuService.delete(id);
        return "redirect:/chatlieu/hien-thi";
    }

    @GetMapping("/chatlieu/updateForm/{idChatLieu}")
    public String view(@PathVariable("idChatLieu") Integer idChatLieu, Model model) {
        ChatLieu chatLieu = chatLieuService.detail(idChatLieu);
        model.addAttribute("chatlieu", chatLieu);
        return "chatlieu/updateForm";
    }

    @PostMapping("/chatlieu/update/{idChatLieu}")
    public String update(@PathVariable("idChatLieu") Integer idChatLieu, @ModelAttribute("chatlieu") ChatLieu updatedCustomer) {
        ChatLieu chatLieu = chatLieuRepository.findById(idChatLieu)
                .orElseThrow(() -> new RuntimeException("Khong tim thay "));

        chatLieu.setMaChatLieu(updatedCustomer.getMaChatLieu());
        chatLieu.setTenChatLieu(updatedCustomer.getTenChatLieu());
        chatLieu.setNgayTao(updatedCustomer.getNgayTao());
        chatLieu.setNgaySua(updatedCustomer.getNgaySua());
        chatLieu.setTrangThai(updatedCustomer.getTrangThai());

        chatLieuRepository.save(chatLieu);
        return "redirect:/chatlieu/hien-thi";
    }
}

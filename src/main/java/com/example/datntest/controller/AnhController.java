package com.example.datntest.controller;

import com.example.datntest.entity.Anh;
import com.example.datntest.repository.AnhRepository;
import com.example.datntest.service.AnhService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@Controller
public class AnhController {

    @Autowired
    private AnhService anhService;
    @Autowired
    private AnhRepository anhRepository;


    @GetMapping("/anh/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<Anh> page = anhService.getAll(pages);
        model.addAttribute("list", page);
        return "/anh/get-all";
    }
    @GetMapping("/anh/view-add")
    private String viewAdd() {
        return "anh/add";
    }
    @PostMapping("/anh/add")
    public String add(
                      @RequestParam("danhMuc") String danhmuc,
                      @RequestParam("url") String url,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)


    {
//        System.out.println(danhmuc);
        Anh anh = Anh.builder()
                .url(danhmuc+url)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        anhService.add(anh);
        return "redirect:/anh/hien-thi";
    }
    //xóa
    @GetMapping("/anh/delete/{idAnh}")
    public String delete(@PathVariable("idAnh") Integer id){
        anhService.delete(id);
        return "redirect:/anh/hien-thi";
    }

    @GetMapping("/anh/updateForm/{idAnh}")
    public String view(@PathVariable("idAnh") Integer idAnh, Model model) {
        Anh anh = anhService.detail(idAnh);
        model.addAttribute("anh", anh);
        return "anh/updateForm";
    }

    @PostMapping("/anh/update/{idAnh}")
    public String update(@RequestParam("danhMuc") String danhmuc,
            @PathVariable("idAnh") Integer idAnh, @ModelAttribute("anh") Anh updatedCustomer) {
        Anh anh = anhRepository.findById(idAnh)
                .orElseThrow(() -> new RuntimeException("Khong tim thay "));

        anh.setUrl(danhmuc+updatedCustomer.getUrl());
        anh.setNgayTao(updatedCustomer.getNgayTao());
        anh.setNgaySua(updatedCustomer.getNgaySua());
        anh.setTrangThai(updatedCustomer.getTrangThai());

        System.out.println(danhmuc);
        anhRepository.save(anh);
        return "redirect:/anh/hien-thi";
    }
}

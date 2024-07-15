package com.example.demo.controller;

import com.example.demo.model.ChucVu;
import com.example.demo.sevice.ChucVuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/chuc-vu/")
public class ChucVuController {


    @Autowired
    private ChucVuService chucVuService;


    @GetMapping("hien-thi")
    public String hienThi(Model model){
        List<ChucVu> chucVus = chucVuService.getAll();
        model.addAttribute("ListCV",chucVus);
        return "ChucVu/indexCV";
    }


    @GetMapping("remove/{id}")
    public String remove(@PathVariable(name = "id") Long id){
        chucVuService.delete(id);
        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("add")
    public String add(@RequestParam(name = "maChucVu") String maChucVu,
                      @RequestParam(name = "tenChucVu") String tenChucVu,
                      @RequestParam(name = "ngayTao") Date ngayTao,
                      @RequestParam(name = "ngaySua") Date ngaySua,
                      @RequestParam(name = "trangThai") Integer trangThai){
        ChucVu chucVu = ChucVu.builder()
                .maChucVu(maChucVu)
                .tenChucVu(tenChucVu)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        chucVuService.add(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") Long id, Model model){
        ChucVu chucVu = chucVuService.getOne(id);
        model.addAttribute("cv",chucVu);
        return "ChucVu/update-CV";
    }
    @PostMapping("update/{id}")
    public String update (@RequestParam(name = "maChucVu") String maChucVu,
                          @RequestParam(name = "tenChucVu") String tenChucVu,
                          @RequestParam(name = "ngayTao") Date ngayTao,
                          @RequestParam(name = "ngaySua") Date ngaySua,
                          @RequestParam(name = "trangThai") Integer trangThai,
                          @PathVariable(name = "id") Long id){
        ChucVu chucVu = ChucVu.builder()
                .maChucVu(maChucVu)
                .tenChucVu(tenChucVu)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(trangThai)
                .build();
        chucVuService.update(chucVu,id);
        return "redirect:/chuc-vu/hien-thi";
    }

}

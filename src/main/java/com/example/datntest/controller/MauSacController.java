package com.example.datntest.controller;

import com.example.datntest.entity.DongSanPham;
import com.example.datntest.entity.MauSac;
import com.example.datntest.repository.DongSanPhamRepository;
import com.example.datntest.repository.MauSacRepository;
import com.example.datntest.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private MauSacRepository mauSacRepository;

    @GetMapping("/mausac/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<MauSac> page = mauSacService.getAll(pages);
        model.addAttribute("list", page);
        return "/mausac/get-all";
    }
    @GetMapping("/mausac/view-add")
    private String viewAdd() {
        return "mausac/add";
    }
    @PostMapping("/mausac/add")
    public String add(@RequestParam("maMauSac")String maMauSac,
                      @RequestParam("tenMauSac") String tenMauSac,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        MauSac mauSac = MauSac.builder()
                .maMauSac(maMauSac)
                .tenMauSac(tenMauSac)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        mauSacService.add(mauSac);
        return "redirect:/mausac/hien-thi";
    }
    //xóa
    @GetMapping("/mausac/delete/{idMauSac}")
    public String delete(@PathVariable("idMauSac") Integer idMauSac){
        mauSacService.delete(idMauSac);
        return "redirect:/mausac/hien-thi";
    }

    @GetMapping("/mausac/updateForm/{idMauSac}")
    public String view(@PathVariable("idMauSac") Integer idMauSac, Model model) {
        MauSac mauSac = mauSacService.detail(idMauSac);
        model.addAttribute("mausac", mauSac);
        return "mausac/updateForm";
    }

    @PostMapping("/mausac/update/{idMauSac}")
    public String update(@PathVariable("idMauSac") Integer idMauSac, @ModelAttribute("mausac") MauSac updatedCustomer) {
        MauSac mauSac = mauSacRepository.findById(idMauSac)
                .orElseThrow(() -> new RuntimeException("Khong tim thay "));

        mauSac.setMaMauSac(updatedCustomer.getMaMauSac());
        mauSac.setTenMauSac(updatedCustomer.getTenMauSac());
        mauSac.setNgayTao(updatedCustomer.getNgayTao());
        mauSac.setNgaySua(updatedCustomer.getNgaySua());
        mauSac.setTrangThai(updatedCustomer.getTrangThai());

        mauSacRepository.save(mauSac);
        return "redirect:/mausac/hien-thi";
    }

}

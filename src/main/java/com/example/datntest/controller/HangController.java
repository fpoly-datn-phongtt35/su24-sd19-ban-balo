package com.example.datntest.controller;

import com.example.datntest.entity.DongSanPham;
import com.example.datntest.entity.Hang;
import com.example.datntest.repository.DongSanPhamRepository;
import com.example.datntest.repository.HangRepository;
import com.example.datntest.service.HangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class HangController {

    @Autowired
    private HangService hangService;
    @Autowired
    private HangRepository hangRepository;


    @GetMapping("/hang/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<Hang> page = hangService.getAll(pages);
        model.addAttribute("list", page);
        return "/hang/get-all";
    }
    @GetMapping("/hang/view-add")
    private String viewAdd() {
        return "hang/add";
    }
    @PostMapping("/hang/add")
    public String add(@RequestParam("maHang")String maHang,
                      @RequestParam("tenHang") String tenHang,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        Hang hang = Hang.builder()
                .maHang(maHang)
                .tenHang(tenHang)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        hangService.add(hang);
        return "redirect:/hang/hien-thi";
    }
    //xóa
    @GetMapping("/hang/delete/{idHang}")
    public String delete(@PathVariable("idHang") Integer idHang){
        hangService.delete(idHang);
        return "redirect:/dongsanpham/hien-thi";
    }

    @GetMapping("/hang/updateForm/{idHang}")
    public String view(@PathVariable("idHang") Integer idHang, Model model) {
        Hang hang = hangService.detail(idHang);
        model.addAttribute("hang", hang);
        return "hang/updateForm";
    }

    @PostMapping("/hang/update/{idHang}")
    public String update(@PathVariable("idHang") Integer idHang, @ModelAttribute("idHang") Hang updatedCustomer) {
        Hang hang = hangRepository.findById(idHang)
                .orElseThrow(() -> new RuntimeException("Khong tim thay "));

        hang.setMaHang(updatedCustomer.getMaHang());
        hang.setTenHang(updatedCustomer.getTenHang());
        hang.setNgayTao(updatedCustomer.getNgayTao());
        hang.setNgaySua(updatedCustomer.getNgaySua());
        hang.setTrangThai(updatedCustomer.getTrangThai());

        hangRepository.save(hang);
        return "redirect:/hang/hien-thi";
    }
}

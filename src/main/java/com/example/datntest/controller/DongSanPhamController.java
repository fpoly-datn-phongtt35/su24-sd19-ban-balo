package com.example.datntest.controller;

import com.example.datntest.entity.ChatLieu;
import com.example.datntest.entity.DongSanPham;
import com.example.datntest.repository.DongSanPhamRepository;
import com.example.datntest.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class DongSanPhamController {

    @Autowired
    private DongSanPhamService dongSanPhamService;
    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;


    @GetMapping("/dongsanpham/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<DongSanPham> page = dongSanPhamService.getAll(pages);
        model.addAttribute("list", page);
        return "/dongsanpham/get-all";
    }
    @GetMapping("/dongsanpham/view-add")
    private String viewAdd() {
        return "dongsanpham/add";
    }
    @PostMapping("/dongsanpham/add")
    public String add(@RequestParam("maDongSanPham")String maDongSanPham,
                      @RequestParam("tenDongSanPham") String tenDongSanPham,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        DongSanPham dongSanPham = DongSanPham.builder()
                .maDongSanPham(maDongSanPham)
                .tenDongSanPham(tenDongSanPham)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        dongSanPhamService.add(dongSanPham);
        return "redirect:/dongsanpham/hien-thi";
    }

    //xóa
    @GetMapping("/dongsanpham/delete/{idDongSanPham}")
    public String delete(@PathVariable("idDongSanPham") Integer id){
        dongSanPhamService.delete(id);
        return "redirect:/dongsanpham/hien-thi";
    }

    @GetMapping("/dongsanpham/updateForm/{idChatLieu}")
    public String view(@PathVariable("idChatLieu") Integer idDongSanPham, Model model) {
        DongSanPham dongSanPham = dongSanPhamService.detail(idDongSanPham);
        model.addAttribute("dongsanpham", dongSanPham);
        return "dongsanpham/updateForm";
    }

    @PostMapping("/dongsanpham/update/{idDongSanPham}")
    public String update(@PathVariable("idDongSanPham") Integer idDongSanPham, @ModelAttribute("dongsanpham") DongSanPham updatedCustomer) {
        DongSanPham dongSanPham = dongSanPhamRepository.findById(idDongSanPham)
                .orElseThrow(() -> new RuntimeException("Khong tim thay "));

        dongSanPham.setMaDongSanPham(updatedCustomer.getMaDongSanPham());
        dongSanPham.setTenDongSanPham(updatedCustomer.getTenDongSanPham());
        dongSanPham.setNgayTao(updatedCustomer.getNgayTao());
        dongSanPham.setNgaySua(updatedCustomer.getNgaySua());
        dongSanPham.setTrangThai(updatedCustomer.getTrangThai());

        dongSanPhamRepository.save(dongSanPham);
        return "redirect:/dongsanpham/hien-thi";
    }

}

package com.example.datntest.controller;

import com.example.datntest.entity.*;
import com.example.datntest.repository.ChatLieuRepository;
import com.example.datntest.repository.SanPhamRepository;
import com.example.datntest.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;

@Controller
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private SanPhamRepository sanPhamRepository;


    @GetMapping("/sanpham/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<SanPham> page = sanPhamService.getAll(pages);
        model.addAttribute("list", page);
        return "/sanpham/get-all";
    }
    @GetMapping("/sanpham/view-add")
    private String viewAdd() {
        return "sanpham/add";
    }
    @PostMapping("/sanpham/add")
    public String add(@RequestParam("idChatLieu") ChatLieu idChatLieu,
                      @RequestParam("idDongSanPham") DongSanPham idDongSanPham,
                      @RequestParam("idNSX") NSX idNSX,
                      @RequestParam("idHang") Hang idHang,
                      @RequestParam("maSanPham")String maSanPham,
                      @RequestParam("tenSanPham") String tenSanPham,
                      @RequestParam("chieuDai")Integer chieuDai,
                      @RequestParam("chieuRong")Integer chieuRong,
                      @RequestParam("chieuCao")Integer chieuCao,
                      @RequestParam("trongLuong")Integer trongLuong,
                      @RequestParam("trongLuongToiDa")Integer trongLuongToiDa,
                      @RequestParam("giaNhap") BigDecimal giaNhap,
                      @RequestParam("soLuongTon")Integer soLuongTon,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        SanPham sanPham = SanPham.builder()
                .idChatLieu(idChatLieu)
                .idDongSanPham(idDongSanPham)
                .idNSX(idNSX)
                .idHang(idHang)
                .maSanPham(maSanPham)
                .tenSanPham(tenSanPham)
                .chieuDai(chieuDai)
                .chieuRong(chieuRong)
                .chieuCao(chieuCao)
                .trongLuong(trongLuong)
                .trongLuongToiDa(trongLuongToiDa)
                .giaNhap(giaNhap)
                .soLuongTon(soLuongTon)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        sanPhamService.add(sanPham);
        return "redirect:/sanpham/hien-thi";
    }
    //xóa
    @GetMapping("/sanpham/delete/{idSanPham}")
    public String delete(@PathVariable("idSanPham") Integer idSanPham){
        sanPhamService.delete(idSanPham);
        return "redirect:/chatlieu/hien-thi";
    }

    @GetMapping("/sanpham/updateForm/{idSanPham}")
    public String view(@PathVariable("idSanPham") Integer idSanPham, Model model) {
        SanPham sanPham = sanPhamService.detail(idSanPham);
        model.addAttribute("sanpham", sanPham);
        return "sanpham/updateForm";
    }

    @PostMapping("/sanpham/update/{idSanPham}")
    public String update(@PathVariable("idSanPham") Integer idSanPham, @ModelAttribute("sanpham") SanPham updatedCustomer) {
        SanPham sanPham = sanPhamRepository.findById(idSanPham)
                .orElseThrow(() -> new RuntimeException("Khong tim thay "));

        sanPham.setIdChatLieu(updatedCustomer.getIdChatLieu());
        sanPham.setIdDongSanPham(updatedCustomer.getIdDongSanPham());
        sanPham.setIdNSX(updatedCustomer.getIdNSX());
        sanPham.setIdHang(updatedCustomer.getIdHang());
        sanPham.setMaSanPham(updatedCustomer.getMaSanPham());
        sanPham.setTenSanPham(updatedCustomer.getTenSanPham());
        sanPham.setChieuDai(updatedCustomer.getChieuDai());
        sanPham.setChieuRong(updatedCustomer.getChieuRong());
        sanPham.setChieuCao(updatedCustomer.getChieuCao());
        sanPham.setTrongLuong(updatedCustomer.getTrongLuong());
        sanPham.setTrongLuongToiDa(updatedCustomer.getTrongLuong());
        sanPham.setGiaNhap(updatedCustomer.getGiaNhap());
        sanPham.setSoLuongTon(updatedCustomer.getSoLuongTon());
        sanPham.setNgayTao(updatedCustomer.getNgayTao());
        sanPham.setNgaySua(updatedCustomer.getNgaySua());
        sanPham.setTrangThai(updatedCustomer.getTrangThai());

        sanPhamRepository.save(sanPham);
        return "redirect:/sanpham/hien-thi";
    }

}

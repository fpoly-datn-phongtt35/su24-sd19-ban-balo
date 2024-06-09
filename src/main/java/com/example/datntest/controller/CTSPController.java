package com.example.datntest.controller;

import com.example.datntest.entity.*;
import com.example.datntest.repository.CTSPRepository;
import com.example.datntest.service.CTSPService;
import com.example.datntest.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;

@Controller
public class CTSPController {

    @Autowired
    private CTSPService ctspService;
    @Autowired
    private CTSPRepository ctspRepository;



    @GetMapping("/ctsp/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages)
    {
        Page<CTSP> page = ctspService.getAll(pages);
        model.addAttribute("list", page);

        return "/ctsp/get-all";
    }

    @GetMapping("/ctsp/view-add")
    private String viewAdd() {
        return "ctsp/add";
    }
    @PostMapping("/ctsp/add")
    public String add(
                      @RequestParam("idSanPham") SanPham idSanPham,
                      @RequestParam("idMauSac") MauSac idMauSac,
                      @RequestParam("idAnh") Anh idAnh,
                      @RequestParam("moTa") String moTa,
                      @RequestParam("giaBan") BigDecimal giaBan,
                      @RequestParam("nguoiTao") Users nguoiTao,
                      @RequestParam("nguoiSua") Users nguoiSua,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("ghiChu") String ghiChu,
                      @RequestParam("trangThai") Integer trangThai)
    {
        CTSP ctsp = CTSP.builder()
                .idSanPham(idSanPham)
                .idMauSac(idMauSac)
                .idAnh(idAnh)
                .moTa(moTa)
                .giaBan(giaBan)
                .nguoiTao(nguoiTao)
                .nguoiSua(nguoiSua)
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .ghiChu(ghiChu)
                .trangThai(trangThai)
                .build();
        ctspService.add(ctsp);
        return "redirect:/ctsp/hien-thi";
    }

    //xóa
    @GetMapping("/ctsp/delete/{idCTSP}")
    public String delete(@PathVariable("idCTSP") Integer idCTSP){
        ctspService.delete(idCTSP);
        return "redirect:/ctsp/hien-thi";
    }

    @GetMapping("/ctsp/updateForm/{idCTSP}")
    public String view(@PathVariable("idCTSP") Integer idCTSP, Model model) {
        CTSP ctsp = ctspService.detail(idCTSP);
        model.addAttribute("ctsp", ctsp);
        return "ctsp/updateForm";
    }

    @PostMapping("/ctsp/update/{idCTSP}")
    public String update(@PathVariable("idCTSP") Integer idCTSP, @ModelAttribute("ctsp") CTSP updatedCustomer) {
        CTSP ctsp = ctspRepository.findById(idCTSP)
                .orElseThrow(() -> new RuntimeException("Khong tim thay "));


        ctsp.setIdSanPham(updatedCustomer.getIdSanPham());
        ctsp.setIdMauSac(updatedCustomer.getIdMauSac());
        ctsp.setIdAnh(updatedCustomer.getIdAnh());
        ctsp.setMoTa(updatedCustomer.getMoTa());
        ctsp.setGiaBan(updatedCustomer.getGiaBan());
        ctsp.setNguoiTao(updatedCustomer.getNguoiTao());
        ctsp.setNguoiSua(updatedCustomer.getNguoiSua());
        ctsp.setNgayTao(updatedCustomer.getNgayTao());
        ctsp.setNgaySua(updatedCustomer.getNgaySua());
        ctsp.setGhiChu(updatedCustomer.getGhiChu());
        ctsp.setTrangThai(updatedCustomer.getTrangThai());

        ctspRepository.save(ctsp);
       return "redirect:/ctsp/hien-thi";
    }
//// tìm theo tên
//    @GetMapping("/ctsp/search")
//    public String searchByTenSanPham(@RequestParam("tenSanPham") String tenSanPham,
//                                     @RequestParam(value = "page", defaultValue = "0") int page,
//                                     @RequestParam(value = "size", defaultValue = "10") int size,
//                                     Model model) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<CTSP> list = ctspService.searchByTenSanPham(tenSanPham, pageable);
//        model.addAttribute("list", list);
//        return "/ctsp/search";
//    }
//
//    //giá
//    @GetMapping("/ctsp/search-price")
//    public String searchByPriceRange(@RequestParam("minGiaBan") BigDecimal minGiaBan,
//                                     @RequestParam("maxGiaBan") BigDecimal maxGiaBan,
//                                     @RequestParam(defaultValue = "0") int page,
//                                     Model model) {
//        Pageable pageable = PageRequest.of(page, 10);
//        Page<CTSP> productsPage = ctspService.searchByPriceRange(minGiaBan, maxGiaBan, pageable);
//        model.addAttribute("list", productsPage);
//        return "/ctsp/search";
//    }

    @GetMapping("/ctsp/search")
    public String search(@RequestParam(value = "tenSanPham", required = false) String tenSanPham,
                         @RequestParam(value = "minGiaBan", required = false) BigDecimal minGiaBan,
                         @RequestParam(value = "maxGiaBan", required = false) BigDecimal maxGiaBan,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         Model model) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<CTSP> productsPage;

        if ((tenSanPham != null && !tenSanPham.isEmpty()) && (minGiaBan != null && maxGiaBan != null)) {
            productsPage = ctspService.searchByTenSanPhamAndPriceRange(tenSanPham, minGiaBan, maxGiaBan, pageable);
        } else if (tenSanPham != null && !tenSanPham.isEmpty()) {
            productsPage = ctspService.searchByTenSanPham(tenSanPham, pageable);
        } else if (minGiaBan != null && maxGiaBan != null) {
            productsPage = ctspService.searchByPriceRange(minGiaBan, maxGiaBan, pageable);
        } else {
            productsPage = ctspService.getAll(page);
        }

        model.addAttribute("list", productsPage);
        return "/ctsp/search";
    }

}

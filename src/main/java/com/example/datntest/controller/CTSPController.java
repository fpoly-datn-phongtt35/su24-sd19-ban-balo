package com.example.datntest.controller;

import com.example.datntest.entity.*;
import com.example.datntest.repository.CTSPRepository;
import com.example.datntest.repository.UsersRepository;
import com.example.datntest.service.CTSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @Autowired
    private UsersRepository usersRepository;


    @GetMapping("/ctsp/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
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
                      @RequestParam("idDotGiamGia") DotGiamGia idDotGiamGia,
                      @RequestParam("anh") Anh anh,
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
                .idDotGiamGia(idDotGiamGia)
                .anh(anh)
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

//        Users nguoiTao = new Users();
//        Users nguoiSua = new Users();


        ctsp.setIdSanPham(updatedCustomer.getIdSanPham());
        ctsp.setIdMauSac(updatedCustomer.getIdMauSac());
        ctsp.setIdDotGiamGia(updatedCustomer.getIdDotGiamGia());
        ctsp.setAnh(updatedCustomer.getAnh());
        ctsp.setMoTa(updatedCustomer.getMoTa());
        ctsp.setGiaBan(updatedCustomer.getGiaBan());
        ctsp.setNguoiTao(updatedCustomer.getNguoiTao());
        ctsp.setNguoiSua(updatedCustomer.getNguoiSua());
        ctsp.setNgayTao(updatedCustomer.getNgayTao());
        ctsp.setNgaySua(updatedCustomer.getNgaySua());
        ctsp.setGhiChu(updatedCustomer.getGhiChu());
        ctsp.setTrangThai(updatedCustomer.getTrangThai());

        ctspRepository.save(ctsp);
//        System.out.println(nguoiTao.getNguoiTao());
//        System.out.println(nguoiSua.getNguoiSua());
        return "redirect:/ctsp/hien-thi";
    }

}

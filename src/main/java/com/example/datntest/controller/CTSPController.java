package com.example.datntest.controller;

import com.example.datntest.entity.*;
import com.example.datntest.repository.*;
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
import java.util.Optional;

@Controller
public class CTSPController {

    @Autowired
    private CTSPService ctspService;
    @Autowired
    private CTSPRepository ctspRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private AnhRepository anhRepository;
    @Autowired
    private UsersRepository usersRepository;

    // get all cho quản lý
    @GetMapping("/ctsp/hien-thi")
    private String hienthi(Model model,
                           @RequestParam ("page") Optional<Integer> pageParam)
    {
        int page1 = pageParam.orElse(0);
        Pageable p = PageRequest.of(page1,5);
        Page<CTSP> page = ctspRepository.findBytrangThai(ctspRepository.ACTIVE,p);
        model.addAttribute("list", page);

        return "/ctsp/get-all";
    }
    // get all cho khách hàng
    @GetMapping("/ctsp/hien-thi2")
    private String hienthi2(Model model,
                           @RequestParam ("page") Optional<Integer> pageParam)
    {
        int page1 = pageParam.orElse(0);
        Pageable p = PageRequest.of(page1,5);
        Page<CTSP> page = ctspRepository.findBytrangThai(ctspRepository.ACTIVE,p);
        model.addAttribute("list", page);

        return "/ctsp/get-all_kh";
    }

    @GetMapping("/ctsp/view-add")
    private String viewAdd(Model model) {
        model.addAttribute("lstSP", sanPhamRepository.findBytrangThai(sanPhamRepository.ACTIVE));
        model.addAttribute("lstMS", mauSacRepository.findBytrangThai(mauSacRepository.ACTIVE));
        model.addAttribute("lstA", anhRepository.findBytrangThai(anhRepository.ACTIVE));
        model.addAttribute("lstUS", usersRepository.findBytrangThai(usersRepository.ACTIVE));

        return "ctsp/add";
    }
    @PostMapping("/ctsp/add")
    public String add(
                      @RequestParam("idSanPham") SanPham idSanPham,
                      @RequestParam("idMauSac") MauSac idMauSac,
                      @RequestParam("idAnh") Anh idAnh,
                      @RequestParam("moTa") String moTa,
                      @RequestParam("giaBan") BigDecimal giaBan,
                      @RequestParam("soLuongTon")Integer soLuongTon,
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
                .soLuongTon(soLuongTon)
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
        model.addAttribute("lstSP", sanPhamRepository.findBytrangThai(sanPhamRepository.ACTIVE));
        model.addAttribute("lstMS", mauSacRepository.findBytrangThai(mauSacRepository.ACTIVE));
        model.addAttribute("lstA", anhRepository.findBytrangThai(anhRepository.ACTIVE));
        model.addAttribute("lstUS", usersRepository.findBytrangThai(usersRepository.ACTIVE));
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
        ctsp.setSoLuongTon(updatedCustomer.getSoLuongTon());
        ctsp.setNguoiTao(updatedCustomer.getNguoiTao());
        ctsp.setNguoiSua(updatedCustomer.getNguoiSua());
        ctsp.setNgayTao(updatedCustomer.getNgayTao());
        ctsp.setNgaySua(updatedCustomer.getNgaySua());
        ctsp.setGhiChu(updatedCustomer.getGhiChu());
        ctsp.setTrangThai(updatedCustomer.getTrangThai());

        ctspRepository.save(ctsp);
       return "redirect:/ctsp/hien-thi";
    }
    //detail


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

//    @GetMapping("/ctsp/search")
//    public String search(@RequestParam(value = "tenSanPham", required = false) String tenSanPham,
//                         @RequestParam(value = "minGiaBan", required = false) BigDecimal minGiaBan,
//                         @RequestParam(value = "maxGiaBan", required = false) BigDecimal maxGiaBan,
//                         @RequestParam(value = "giaBanRange", required = false) String giaBanRange,
//                         @RequestParam(value = "page", defaultValue = "0") int page,
//                         Model model) {
//        Pageable pageable = PageRequest.of(page, 10);
//        Page<CTSP> productsPage;
//
//        if (giaBanRange != null && !giaBanRange.isEmpty()) {
//            String[] priceRange = giaBanRange.split("-");
//            minGiaBan = new BigDecimal(priceRange[0]);
//            maxGiaBan = new BigDecimal(priceRange[1]);
//        }
//        if ((tenSanPham != null && !tenSanPham.isEmpty()) && (minGiaBan != null && maxGiaBan != null)) {
//            productsPage = ctspService.searchByTenSanPhamAndPriceRange(tenSanPham, minGiaBan, maxGiaBan, pageable);
//        } else if (tenSanPham != null && !tenSanPham.isEmpty()) {
//            productsPage = ctspService.searchByTenSanPham(tenSanPham, pageable);
//        } else if (minGiaBan != null && maxGiaBan != null) {
//            productsPage = ctspService.searchByPriceRange(minGiaBan, maxGiaBan, pageable);
//        } else {
//            productsPage = ctspRepository.findBytrangThai(ctspRepository.ACTIVE,pageable);
//        }
//
//        model.addAttribute("list", productsPage);
//        return "/ctsp/search";
//    }

}

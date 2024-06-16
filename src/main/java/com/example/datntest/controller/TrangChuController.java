package com.example.datntest.controller;

import com.example.datntest.entity.*;
import com.example.datntest.repository.*;
import com.example.datntest.service.CTSPService;
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
public class TrangChuController {

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

    @GetMapping("/trangchu/hien-thi")
    private String hienthi(Model model,
                           @RequestParam ("page") Optional<Integer> pageParam)
    {
        int page1 = pageParam.orElse(0);
        Pageable p = PageRequest.of(page1,5);
        Page<CTSP> page = ctspRepository.findBytrangThai(ctspRepository.ACTIVE,p);
        model.addAttribute("list", page);
        model.addAttribute("lstSP", sanPhamRepository.findBytrangThai(sanPhamRepository.ACTIVE));
        model.addAttribute("lstMS", mauSacRepository.findBytrangThai(mauSacRepository.ACTIVE));
        model.addAttribute("lstA", anhRepository.findBytrangThai(anhRepository.ACTIVE));
        model.addAttribute("lstUS", usersRepository.findBytrangThai(usersRepository.ACTIVE));
        return "trangchu";
    }

    @GetMapping("/trangchu/search")
    public String search(@RequestParam(value = "tenSanPham", required = false) String tenSanPham,
                         @RequestParam(value = "minGiaBan", required = false) BigDecimal minGiaBan,
                         @RequestParam(value = "maxGiaBan", required = false) BigDecimal maxGiaBan,
                         @RequestParam(value = "giaBanRange", required = false) String giaBanRange,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         Model model) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<CTSP> productsPage;

        if (giaBanRange != null && !giaBanRange.isEmpty()) {
            String[] priceRange = giaBanRange.split("-");
            minGiaBan = new BigDecimal(priceRange[0]);
            maxGiaBan = new BigDecimal(priceRange[1]);
        }
        if ((tenSanPham != null && !tenSanPham.isEmpty()) && (minGiaBan != null && maxGiaBan != null)) {
            productsPage = ctspService.searchByTenSanPhamAndPriceRange(tenSanPham, minGiaBan, maxGiaBan, pageable);
        } else if (tenSanPham != null && !tenSanPham.isEmpty()) {
            productsPage = ctspService.searchByTenSanPham(tenSanPham, pageable);
        } else if (minGiaBan != null && maxGiaBan != null) {
            productsPage = ctspService.searchByPriceRange(minGiaBan, maxGiaBan, pageable);
        } else {
            productsPage = ctspRepository.findBytrangThai(ctspRepository.ACTIVE,pageable);
        }

        model.addAttribute("list", productsPage);
        return "/ctsp/search";
    }

}

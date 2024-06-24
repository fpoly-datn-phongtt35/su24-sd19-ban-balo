package com.example.datntest.controller;

import com.example.datntest.entity.CTSP;
import com.example.datntest.entity.SanPham;
import com.example.datntest.repository.CTSPRepository;
import com.example.datntest.repository.SanPhamRepository;
import com.example.datntest.service.CTSPService;
import com.example.datntest.service.SanPhamService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
public class ShopController {

    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private CTSPService ctspService;

    @Autowired
    private CTSPRepository ctspRepository;



    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/shop")
    public String shop(Model model, HttpSession session) {
        model.addAttribute("pageName", "shop");
        session.setAttribute("active", 2);
        return "index"; // Trả về tên của file JSP chính (home.jsp)
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session,
                       @RequestParam(value = "page", defaultValue = "0") int pages,
                        @RequestParam ("page") Optional<Integer> pageParam) {
        session.setAttribute("active", 1);
        int page1 = pageParam.orElse(0);
        Pageable p = PageRequest.of(page1,5);
        Page<CTSP> page = ctspRepository.findBytrangThai(ctspRepository.ACTIVE,p);
        model.addAttribute("list", page);
        model.addAttribute("pageName", "ctsp/get-all");
        return "index";
    }

    @GetMapping("/ctsp/search")
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
        model.addAttribute("pageName", "ctsp/get-all");

        return "index";
    }
}

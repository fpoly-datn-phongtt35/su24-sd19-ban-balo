package com.example.datntest.controller;

import com.example.datntest.entity.DongSanPham;
import com.example.datntest.entity.NSX;
import com.example.datntest.repository.DongSanPhamRepository;
import com.example.datntest.repository.NSXRepository;
import com.example.datntest.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class NSXController {

    @Autowired
    private NSXService nsxService;
    @Autowired
    private NSXRepository nsxRepository;



    @GetMapping("/nsx/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {
        Page<NSX> page = nsxService.getAll(pages);
        model.addAttribute("list", page);
        return "/nsx/get-all";
    }
    @GetMapping("/nsx/view-add")
    private String viewAdd() {
        return "nsx/add";
    }
    @PostMapping("/nsx/add")
    public String add(@RequestParam("maNSX")String maNSX,
                      @RequestParam("tenNSX") String tenNSX,
                      @RequestParam("ngayTao") String ngayTao,
                      @RequestParam("ngaySua") String ngaySua,
                      @RequestParam("trangThai") Integer trangThai)
    {
        NSX nsx = NSX.builder()
                .maNSX(maNSX)
                .tenNSX(Date.valueOf(tenNSX))
                .ngayTao(Date.valueOf(ngayTao))
                .ngaySua(Date.valueOf(ngaySua))
                .trangThai(trangThai)
                .build();
        nsxService.add(nsx);
        return "redirect:/nsx/hien-thi";
    }
    //xóa
    @GetMapping("/nsx/delete/{idNSX}")
    public String delete(@PathVariable("idNSX") Integer idNSX){
        nsxService.delete(idNSX);
        return "redirect:/nsx/hien-thi";
    }

    @GetMapping("/nsx/updateForm/{idNSX}")
    public String view(@PathVariable("idNSX") Integer idNSX, Model model) {
        NSX nsx = nsxService.detail(idNSX);
        model.addAttribute("nsx", nsx);
        return "nsx/updateForm";
    }

    @PostMapping("/nsx/update/{idNSX}")
    public String update(@PathVariable("idNSX") Integer idNSX, @ModelAttribute("nsx") NSX updatedCustomer) {
        NSX nsx = nsxRepository.findById(idNSX)
                .orElseThrow(() -> new RuntimeException("Khong tim thay "));

        nsx.setMaNSX(updatedCustomer.getMaNSX());
        nsx.setTenNSX(updatedCustomer.getTenNSX());
        nsx.setNgayTao(updatedCustomer.getNgayTao());
        nsx.setNgaySua(updatedCustomer.getNgaySua());
        nsx.setTrangThai(updatedCustomer.getTrangThai());

        nsxRepository.save(nsx);
        return "redirect:/nsx/hien-thi";
    }

}

package com.example.datntest.controller;

import com.example.datntest.entity.*;
import com.example.datntest.repository.*;
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
import java.util.List;
import java.util.Optional;

@Controller
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private ChatLieuRepository chatLieuRepository;
    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;
    @Autowired
    private NSXRepository nsxRepository;
    @Autowired
    private HangRepository hangRepository;

    @GetMapping("/sanpham/hien-thi2")
    private String getHTMLtable(Model model
    ){
        model.addAttribute("list",sanPhamRepository.getSanPham());
        return "/sanpham/get-all";
    }
    @GetMapping("/sanpham/table1")
    @ResponseBody
    public List<SanPham> originTable() {
        // Xử lý tìm kiếm dữ liệu dựa trên query
        List<SanPham> searchData = sanPhamRepository.getSanPham();
        // Hàm searchData là để giả lập việc tìm kiếm
        return searchData;
    }
    @GetMapping("/sanpham/search")
    @ResponseBody
    public List<SanPham> searchTable(@RequestParam("query") String query) {
        // Xử lý tìm kiếm dữ liệu dựa trên query
        List<SanPham> searchData = sanPhamRepository.ListtimTheoTenorMa(query);
        // Hàm searchData là để giả lập việc tìm kiếm
        return searchData;
    }

    @GetMapping("/sanpham/hien-thi")
    private String hienthi(Model model,
                           @RequestParam(required = false) String tenSanPham,
                           @RequestParam(required = false) String tenChatLieu,
                           @RequestParam(required = false) BigDecimal giaTu,
                           @RequestParam(required = false) BigDecimal giaDen,
                           @RequestParam(value = "page", defaultValue = "0") int pages) {


        Pageable pageable = PageRequest.of(pages, 5);
        Page<SanPham> sanPhamPage;

        if (tenSanPham != null && !tenSanPham.isEmpty()) {
            // Nếu có nhập tên sản phẩm, thực hiện tìm kiếm
            sanPhamPage = sanPhamService.timKiemTheoTen(tenSanPham, pageable);
        } else if (tenChatLieu != null && !tenChatLieu.isEmpty()) {
            sanPhamPage = sanPhamService.timKiemTheoTenChatLieu(pageable, tenChatLieu);
        }else if (giaTu != null && giaDen != null) {
            sanPhamPage = sanPhamService.timKiemTheoKhoangGia(giaTu, giaDen, pageable);
        }  else {
            sanPhamPage = sanPhamService.getAll(pageable);
        }
        model.addAttribute("lstCL", chatLieuRepository.findBytrangThai(chatLieuRepository.ACTIVE));
        model.addAttribute("list", sanPhamPage);
        return "/sanpham/get-all";
    }

    @GetMapping("/sanpham/view-add")
    private String viewAdd(Model model) {
        model.addAttribute("lstCL", chatLieuRepository.findBytrangThai(chatLieuRepository.ACTIVE));
        model.addAttribute("lstDSP", dongSanPhamRepository.findBytrangThai(dongSanPhamRepository.ACTIVE));
        model.addAttribute("lstNSX", nsxRepository.findBytrangThai(nsxRepository.ACTIVE));
        model.addAttribute("lstH", hangRepository.findBytrangThai(hangRepository.ACTIVE));
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
//                      @RequestParam("soLuongTon")Integer soLuongTon,
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
//                .soLuongTon(soLuongTon)
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
        model.addAttribute("lstCL", chatLieuRepository.findBytrangThai(chatLieuRepository.ACTIVE));
        model.addAttribute("lstDSP", dongSanPhamRepository.findBytrangThai(dongSanPhamRepository.ACTIVE));
        model.addAttribute("lstNSX", nsxRepository.findBytrangThai(nsxRepository.ACTIVE));
        model.addAttribute("lstH", hangRepository.findBytrangThai(hangRepository.ACTIVE));

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
//        sanPham.setSoLuongTon(updatedCustomer.getSoLuongTon());
        sanPham.setNgayTao(updatedCustomer.getNgayTao());
        sanPham.setNgaySua(updatedCustomer.getNgaySua());
        sanPham.setTrangThai(updatedCustomer.getTrangThai());

        sanPhamRepository.save(sanPham);
        return "redirect:/sanpham/hien-thi";
    }

}

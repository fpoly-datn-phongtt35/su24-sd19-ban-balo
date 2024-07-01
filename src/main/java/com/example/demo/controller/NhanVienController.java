package com.example.demo.controller;

import com.example.demo.model.ChucVu;
import com.example.demo.model.NhanVien;
import com.example.demo.sevice.ChucVuService;
import com.example.demo.sevice.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/nhan-vien/")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private ChucVuService chucVuService;


    @GetMapping("hien-thi")
    public String hienThi(Model model, @RequestParam(name = "page", defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 5);

        model.addAttribute("nhanViens",nhanVienService.getData(pageable));

        List<ChucVu> chucVus = chucVuService.getAll();
        model.addAttribute("chucVus",chucVus);
        return "NhanVien/indexNV";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable(name = "id") Long id){
        nhanVienService.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") Long id, Model model){
        NhanVien nhanVien = nhanVienService.getOne(id);
        model.addAttribute("nv",nhanVien);

        List<ChucVu> chucVus = chucVuService.getAll();
        model.addAttribute("chucVus",chucVus);
        return "NhanVien/update-NV";
    }
    @PostMapping("add")
    public String add(@RequestParam(name = "maNhanVien") String maNhanVien,
                      @RequestParam(name = "tenNhanVien") String tenNhanVien,
                      @RequestParam(name = "tenDemNhanVien") String tenDemNhanVien,
                      @RequestParam(name = "hoNhanVien") String hoNhanVien,
                      @RequestParam(name = "ngaySinh") LocalDate ngaySinh,
                      @RequestParam(name = "gioiTinh") Integer gioiTinh,
                      @RequestParam(name = "sdt") String sdt,
                      @RequestParam(name = "cccd") String cccd,
                      @RequestParam(name = "soNha") String soNha,
                      @RequestParam(name = "phuongXa") String phuongXa,
                      @RequestParam(name = "quanHuyen") String quanHuyen,
                      @RequestParam(name = "tinhThanhPho") String tinhThanhPho,
                      @RequestParam(name = "chucVu") String chucVu,
                      @RequestParam(name = "ngayTao") LocalDate ngayTao,
                      @RequestParam(name = "ngaySua") LocalDate ngaySua,
                      @RequestParam(name = "trangThai") String trangThai){
        NhanVien nhanVien = NhanVien.builder()
                .maNhanVien(maNhanVien)
                .tenNhanVien(tenNhanVien)
                .tenDemNhanVien(tenDemNhanVien)
                .hoNhanVien(hoNhanVien)
                .ngaySinh(ngaySinh)
                .gioiTinh(gioiTinh)
                .sdt(sdt)
                .cccd(cccd)
                .soNha(soNha)
                .phuongXa(phuongXa)
                .quanHuyen(quanHuyen)
                .tinhThanhPho(tinhThanhPho)
                .chucVu(chucVuService.getOne(Long.valueOf(chucVu)))
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("update/{id}")
    public String update(@RequestParam(name = "maNhanVien") String maNhanVien,
                          @RequestParam(name = "tenNhanVien") String tenNhanVien,
                          @RequestParam(name = "tenDemNhanVien") String tenDemNhanVien,
                          @RequestParam(name = "hoNhanVien") String hoNhanVien,
                          @RequestParam(name = "ngaySinh") LocalDate ngaySinh,
                          @RequestParam(name = "gioiTinh") Integer gioiTinh,
                          @RequestParam(name = "sdt") String sdt,
                          @RequestParam(name = "cccd") String cccd,
                          @RequestParam(name = "soNha") String soNha,
                          @RequestParam(name = "phuongXa") String phuongXa,
                          @RequestParam(name = "quanHuyen") String quanHuyen,
                          @RequestParam(name = "tinhThanhPho") String tinhThanhPho,
                          @RequestParam(name = "chucVu") String chucVu,
                          @RequestParam(name = "ngayTao") LocalDate ngayTao,
                          @RequestParam(name = "ngaySua") LocalDate ngaySua,
                          @RequestParam(name = "trangThai") String trangThai,
                          @PathVariable(name = "id") Long id){
        NhanVien nhanVien = NhanVien.builder()
                .maNhanVien(maNhanVien)
                .tenNhanVien(tenNhanVien)
                .tenDemNhanVien(tenDemNhanVien)
                .hoNhanVien(hoNhanVien)
                .ngaySinh(ngaySinh)
                .gioiTinh(gioiTinh)
                .sdt(sdt)
                .cccd(cccd)
                .soNha(soNha)
                .phuongXa(phuongXa)
                .quanHuyen(quanHuyen)
                .tinhThanhPho(tinhThanhPho)
                .chucVu(chucVuService.getOne(Long.valueOf(chucVu)))
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        nhanVienService.update(nhanVien,id);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("search")
    public String searchByKey(@RequestParam("key") String key, Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("listCategory", nhanVienService.searchByKey(key, pageable));
        model.addAttribute("category", new NhanVien());
        return "NhanVien/indexNV";
    }
}

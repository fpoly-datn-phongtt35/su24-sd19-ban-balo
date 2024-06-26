package com.example.demo.controller;


import com.example.demo.model.ChucVu;
import com.example.demo.model.NhanVien;
import com.example.demo.sevice.ChucVuService;
import com.example.demo.sevice.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        Page<NhanVien> nhanViens = nhanVienService.getData(page);
        model.addAttribute("nhanViens",nhanViens);

        List<ChucVu> chucVus = chucVuService.getAll();
        model.addAttribute("chucVus",chucVus);
        return "NhanVien/indexNV";
    }
    @GetMapping("remove/{id}")
    public String remove(@PathVariable(name = "id") int id){
        nhanVienService.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") int id, Model model){
        NhanVien nhanVien = nhanVienService.getOne(id);
        model.addAttribute("nv",nhanVien);

        List<ChucVu> chucVus = chucVuService.getAll();
        model.addAttribute("chucVus",chucVus);
        return "NhanVien/update-NV";
    }
    @PostMapping("add")
    public String add(@RequestParam(name = "maNhanVien") String maNhanVien,
                      @RequestParam(name = "tenNhanVien") String tenNhanVien,
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
                .hoNhanVien(hoNhanVien)
                .ngaySinh(ngaySinh)
                .gioiTinh(gioiTinh)
                .sdt(sdt)
                .cccd(cccd)
                .soNha(soNha)
                .phuongXa(phuongXa)
                .quanHuyen(quanHuyen)
                .tinhThanhPho(tinhThanhPho)
                .chucVu(chucVuService.getOne(Integer.valueOf(chucVu)))
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
                          @PathVariable(name = "id") int id){
        NhanVien nhanVien = NhanVien.builder()
                .maNhanVien(maNhanVien)
                .tenNhanVien(tenNhanVien)
                .hoNhanVien(hoNhanVien)
                .ngaySinh(ngaySinh)
                .gioiTinh(gioiTinh)
                .sdt(sdt)
                .cccd(cccd)
                .soNha(soNha)
                .phuongXa(phuongXa)
                .quanHuyen(quanHuyen)
                .tinhThanhPho(tinhThanhPho)
                .chucVu(chucVuService.getOne(Integer.valueOf(chucVu)))
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        nhanVienService.update(nhanVien,id);
        return "redirect:/nhan-vien/hien-thi";
    }
}

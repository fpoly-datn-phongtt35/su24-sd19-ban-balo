package com.example.demo.controller;

import com.example.demo.model.NhanVien;
import com.example.demo.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/nhan-vien/")
public class NhanVienController {
    private final NhanVienService nhanVienService;
    private List<NhanVien> list;

    @GetMapping("hien-thi")
    public String hienThiNhanVien(Model model) {
        list = nhanVienService.getAll();
        model.addAttribute("list", list);
        return "nhanviens";
    }

    @GetMapping("detail/{id}")
    public String detailNhanVien(@PathVariable("id") Long id, Model model) {
        NhanVien nv = nhanVienService.detail(id);
        model.addAttribute("nv1", nv);
        return "detail-nhan-vien";
    }

    @GetMapping("view-update/{id}")
    public String updateNhanVien(@PathVariable("id") Long id, Model model) {
        NhanVien nv = nhanVienService.detail(id);
        model.addAttribute("nv1", nv);
        return "update-nhan-vien";
    }

    @GetMapping("remove/{ma}")
    public String xoaNhanVien(@PathVariable("id") Long id) {
        nhanVienService.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("view-add")
    public String viewAdd(){
        return "add-sinh-vien";
    }



    @PostMapping("add")
    public String addSinhVien(@RequestParam("id") Long id,
                              @RequestParam("maNhanVien") String maNhanVien,
                              @RequestParam("tenNhanVien") String tenNhanVien,
                              @RequestParam("hoNhanVien") String hoNhanVien,
                              @RequestParam("ngaySinh") Date ngaySinh,
                              @RequestParam("gioiTinh") Boolean gioiTinh,
                              @RequestParam("sdt") String sdt,
                              @RequestParam("cccd") String cccd,
                              @RequestParam("soNha") String soNha,
                              @RequestParam("phuongXa") String phuongXa,
                              @RequestParam("quanHuyen") String quanHuyen,
                              @RequestParam("tinhThanhPho") String tinhThanhPho,
                              @RequestParam("matKhau") String matKhau,
                              @RequestParam("nguoiTao") Integer nguoiTao,
                              @RequestParam("nguoiSua") Integer nguoiSua,
                              @RequestParam("ngayTao") Timestamp ngayTao,
                              @RequestParam("ngaySua") Timestamp ngaySua,
                              @RequestParam("trangThai" )Boolean trangThai){
        //khoi tao doi tuong
        NhanVien nv = NhanVien.builder()
                .maNhanVien(maNhanVien)
                .tenNhanVien(tenNhanVien)
                .hoNhanVien(hoNhanVien)
                .tenNhanVien(tenNhanVien)
                .ngaySinh(Date.valueOf(ngaySinh.toLocalDate()))
                .sdt(sdt)
                .cccd(cccd)
                .soNha(soNha)
                .phuongXa(phuongXa)
                .quanHuyen(quanHuyen)
                .tinhThanhPho(tinhThanhPho)
                .nguoiTao(nguoiTao)
                .nguoiSua(nguoiSua)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .matKhau(matKhau)
                .gioiTinh(gioiTinh)
                .trangThai(trangThai)
                .build();
        //b2:goi add trong service
        nhanVienService.add(nv);
        //B3: Quay lai trang chu
        return "redirect:/nhan-vien/hien-thi";

    }


}

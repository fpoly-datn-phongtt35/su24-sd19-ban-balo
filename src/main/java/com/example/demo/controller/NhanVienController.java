package com.example.demo.controller;

import com.example.demo.model.NhanVien;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.impl.NhanVienServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.sql.Date;


@Controller
@RequiredArgsConstructor
@RequestMapping("/nhan-vien/")
public class NhanVienController {
    private final NhanVienService nhanVienService;
    private final NhanVienServiceImpl nhanVienService1;
    private final ChucVuService chucVuService;

    @GetMapping("hien-thi")
    public String page(Model model, @ModelAttribute("sp") NhanVien sp,
                                  @RequestParam(defaultValue = "0") int a) {
         nhanVienService.getAll();
        model.addAttribute("list", nhanVienService1.page(a,5));
        model.addAttribute("sp",sp);
        model.addAttribute("cv", chucVuService.getAll());
        return "indexNhanVien";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model,
                                 @ModelAttribute("sp") NhanVien sp) {
        nhanVienService.detail(id);
        model.addAttribute("sp", nhanVienService.detail(id));
        model.addAttribute("ListSP", nhanVienService.getAll());
        model.addAttribute("chucVu", chucVuService.getAll());
        return "indexNhanVien";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") Long id, Model model,@ModelAttribute("sp") NhanVien sp) {
       nhanVienService.detail(id);
        model.addAttribute("sp", nhanVienService.detail(id));
        model.addAttribute("ListSP", nhanVienService.getAll());
        model.addAttribute("chucVu", chucVuService.getAll());
        return "detailNhanVien";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        nhanVienService.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("add")
    public String add(
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
                              @RequestParam("trangThai" )Integer trangThai){
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
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Long id,
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
                              @RequestParam("trangThai" )Integer trangThai){
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
        nhanVienService.update(nv,id);
        //B3: Quay lai trang chu
        return "redirect:/nhan-vien/hien-thi";

    }


}

package com.example.demo.controllers;


import com.example.demo.models.TrongLuong;
import com.example.demo.services.TrongLuongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/trong-luong")
public class TrongLuongController {
    @Autowired
    private TrongLuongService trongLuongService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @ModelAttribute("trongLuong") TrongLuong trongLuong) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<TrongLuong> page = trongLuongService.getAll(pageable);
        model.addAttribute("listTrongLuong", page.getContent());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("contentPage", "../trong-luong/hien-thi.jsp");
        return "home/layout";
    }

    @GetMapping("/hien-thi-delete")
    public String hienThiNgungHoatDong(Model model, @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                       @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @ModelAttribute("trongLuong") TrongLuong trongLuong) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<TrongLuong> page = trongLuongService.getAll1(pageable);
        model.addAttribute("listTrongLuong", page.getContent());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("contentPage", "../trong-luong/hien-thi-ngung-hoat-dong.jsp");
        return "home/layout";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model, @ModelAttribute("trongLuong") TrongLuong trongLuong
            , @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<TrongLuong> page = trongLuongService.getAll(pageable);
        model.addAttribute("listTrongLuong", page.getContent());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("trongLuong", new TrongLuong());
        model.addAttribute("batmodalthemtrongluong", 0);
        model.addAttribute("contentPage", "../trong-luong/hien-thi.jsp");
        return "home/layout";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid @ModelAttribute("trongLuong") TrongLuong trongLuong, BindingResult bindingResult
            , @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                      @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        if (bindingResult.hasErrors()) {
            Pageable pageable = PageRequest.of(pageNum, pageSize);
            Page<TrongLuong> page = trongLuongService.getAll(pageable);
            model.addAttribute("listTrongLuong", page.getContent());
            model.addAttribute("totalPage", page.getTotalPages());
            model.addAttribute("batmodalthemtrongluong", 0);
            model.addAttribute("contentPage", "../trong-luong/hien-thi.jsp");
            return "home/layout";
        }
        String mhd = "";
        Integer sl = trongLuongService.findAllFullTT().size() + 1;
        if (sl < 9) {
            mhd = "CA0" + sl;
        } else {
            mhd = "CA" + sl;
        }
        trongLuong.setMa(mhd);
        trongLuong.setNgayTao(Date.valueOf(LocalDate.now()));
        trongLuong.setTrangThai(0);
        trongLuongService.add(trongLuong);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<TrongLuong> page = trongLuongService.getAll(pageable);
        model.addAttribute("listTrongLuong", page.getContent());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("batmodalthemtrongluong", 1);
        model.addAttribute("thongBaoThanhCong", "Thêm dữ liệu thành công");
        model.addAttribute("contentPage", "../trong-luong/hien-thi.jsp");
        return "home/layout";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id, @ModelAttribute("trongLuong") TrongLuong trongLuong
            , @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<TrongLuong> page = trongLuongService.getAll(pageable);
        model.addAttribute("listTrongLuong", page.getContent());
        model.addAttribute("trongLuong", trongLuongService.findById(id));
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("batmodaldetailtrongluong", 0);
        model.addAttribute("contentPage", "../trong-luong/hien-thi.jsp");
        return "home/layout";
    }

    @GetMapping("/detail-ngung-hoat-dong/{id}")
    public String detailNgungHoatDong(Model model, @PathVariable("id") UUID id, @ModelAttribute("trongLuong") TrongLuong trongLuong
            , @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                      @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<TrongLuong> page = trongLuongService.getAll1(pageable);
        model.addAttribute("listTrongLuong", page.getContent());
        model.addAttribute("trongLuong", trongLuongService.findById(id));
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("batmodaldetailtrongluong", 0);
        model.addAttribute("contentPage", "../trong-luong/hien-thi-ngung-hoat-dong.jsp");
        return "home/layout";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") UUID id, @ModelAttribute("trongLuong") TrongLuong trongLuong
            , @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<TrongLuong> page = trongLuongService.getAll(pageable);
        model.addAttribute("listTrongLuong", page.getContent());
        model.addAttribute("trongLuong", trongLuongService.findById(id));
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("batmodalupdatetrongluong", 0);
        model.addAttribute("contentPage", "../trong-luong/hien-thi.jsp");
        return "home/layout";
    }

    @PostMapping("/update/{id}")
    public String add(Model model, @PathVariable("id") UUID id, @Valid @ModelAttribute("trongLuong") TrongLuong trongLuong, BindingResult bindingResult
            , @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                      @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        if (bindingResult.hasErrors()) {

            Pageable pageable = PageRequest.of(pageNum, pageSize);
            Page<TrongLuong> page = trongLuongService.getAll(pageable);
            model.addAttribute("listTrongLuong", page.getContent());
            model.addAttribute("totalPage", page.getTotalPages());
            model.addAttribute("batmodalupdatetrongluong", 0);
            model.addAttribute("contentPage", "../trong-luong/hien-thi.jsp");
            return "home/layout";
        }
        TrongLuong cl = trongLuongService.findById(id);
        cl.setNgaySua(Date.valueOf(LocalDate.now()));
        cl.setTrangThai(0);
        cl.setTen(trongLuong.getTen());
        trongLuongService.update(id, cl);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<TrongLuong> page = trongLuongService.getAll(pageable);
        model.addAttribute("listTrongLuong", page.getContent());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("batmodalupdatetrongluong", 1);
        model.addAttribute("thongBaoThanhCong", "Cập nhật dữ liệu thành công");
        model.addAttribute("contentPage", "../trong-luong/hien-thi.jsp");
        return "home/layout";
    }

    @GetMapping("/delete/{id}")
    public String updateTrangThai(Model model, @PathVariable("id") UUID id, @ModelAttribute("trongLuong") TrongLuong trongLuong
            , @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                  @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        TrongLuong cl = trongLuongService.findById(id);
        cl.setTrangThai(1);
        cl.setNgaySua(Date.valueOf(LocalDate.now()));
        trongLuongService.update(id, cl);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<TrongLuong> page = trongLuongService.getAll(pageable);
        model.addAttribute("listTrongLuong", page.getContent());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("thongBaoThanhCong", "Cập nhật trạng thái thành công");
        model.addAttribute("contentPage", "../trong-luong/hien-thi.jsp");
        return "home/layout";
    }

    @GetMapping("/khoi-phuc/{id}")
    public String updateTrangThaiNgung(Model model, @PathVariable("id") UUID id, @ModelAttribute("trongLuong") TrongLuong trongLuong
            , @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                       @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        TrongLuong cl = trongLuongService.findById(id);
        cl.setTrangThai(0);
        cl.setNgaySua(Date.valueOf(LocalDate.now()));
        trongLuongService.update(id, cl);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<TrongLuong> page = trongLuongService.getAll1(pageable);
        model.addAttribute("listTrongLuong", page.getContent());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("thongBaoThanhCong", "Cập nhật trạng thái thành công");
        model.addAttribute("contentPage", "../trong-luong/hien-thi-ngung-hoat-dong.jsp");
        return "home/layout";
    }

    @PostMapping("/search-con-hoat-dong")
    public String search0(Model model, @ModelAttribute("trongLuong") TrongLuong trongLuong, @RequestParam("search") String search
            , @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        if (search.isEmpty()) {
            model.addAttribute("thongBao", "Không để trống thông tin");
            Pageable pageable = PageRequest.of(pageNum, pageSize);
            Page<TrongLuong> page = trongLuongService.getAll(pageable);
            model.addAttribute("listTrongLuong", page.getContent());
            model.addAttribute("totalPage", page.getTotalPages());
            model.addAttribute("contentPage", "../trong-luong/hien-thi.jsp");
            return "home/layout";
        } else {
            List<TrongLuong> list = trongLuongService.search0(search);
            model.addAttribute("listTrongLuong", list);
            model.addAttribute("thongBaoThanhCong", "Tìm kiếm dữ liệu thành công");
            model.addAttribute("contentPage", "../trong-luong/hien-thi.jsp");
            return "home/layout";
        }

    }

    @PostMapping("/search-ngung-hoat-dong")
    public String search1(Model model, @ModelAttribute("trongLuong") TrongLuong trongLuong, @RequestParam("search") String search
            , @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        if (search.isEmpty()) {
            model.addAttribute("thongBao", "Không để trống thông tin");
            Pageable pageable = PageRequest.of(pageNum, pageSize);
            Page<TrongLuong> page = trongLuongService.getAll1(pageable);
            model.addAttribute("listTrongLuong", page.getContent());
            model.addAttribute("totalPage", page.getTotalPages());
            model.addAttribute("contentPage", "../trong-luong/hien-thi-ngung-hoat-dong.jsp");
            return "home/layout";
        } else {
            List<TrongLuong> list = trongLuongService.search1(search);
            model.addAttribute("listTrongLuong", list);
            model.addAttribute("thongBaoThanhCong", "Tìm kiếm dữ liệu thành công");
            model.addAttribute("contentPage", "../trong-luong/hien-thi-ngung-hoat-dong.jsp");
            return "home/layout";
        }

    }
}

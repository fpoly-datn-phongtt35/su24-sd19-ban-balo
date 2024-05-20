package com.example.demo.controller;

import com.example.demo.model.NhanVien;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cms/nhan-vien/")
public class NhanVienController {
    private final NhanVienService nhanVienService;


    @GetMapping("hienThi")
    public ResponseEntity<List<NhanVien>> hienThiTatCa(){
        List<NhanVien> nhanVienList = nhanVienService.getAll();
        return new ResponseEntity<>(nhanVienList.stream().toList(), HttpStatus.OK);
    }
    @PutMapping("update/{ma}")
    public ResponseEntity<NhanVien> update(@PathVariable("id") Long id, @RequestBody NhanVien nhanVien){
        nhanVien.setId(id);
        NhanVien nhanVien1 = nhanVienService.update(nhanVien,id);
        return new ResponseEntity<>(nhanVien1, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")Long id){
        nhanVienService.delete(id);
        return new ResponseEntity<>("Xoa thanh cong", HttpStatus.OK);
    }
    @PostMapping("create")
    public ResponseEntity<NhanVien> add(@RequestBody NhanVien nhanVien){
        NhanVien nhanVien1 = nhanVienService.add(nhanVien);
        return new ResponseEntity<>(nhanVien1, HttpStatus.CREATED);
    }


}

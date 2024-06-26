package com.example.demo.sevice;

import com.example.demo.model.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhanVienService {
    List<NhanVien> findAll();
    NhanVien getOne(int id);
    void add(NhanVien nhanVien);
    void update(NhanVien nhanVien, int id);
    void delete(int id);
    Page<NhanVien> getData(int page);

}

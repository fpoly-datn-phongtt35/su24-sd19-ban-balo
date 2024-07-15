package com.example.demo.sevice;


import com.example.demo.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NhanVienService {
    List<NhanVien> findAll();
    NhanVien getOne(Long id);
    NhanVien add(NhanVien nhanVien);
    NhanVien update(NhanVien nhanVien, Long id);
    void delete(Long id);
    Page<NhanVien> getData(Pageable pageable);
    Page<NhanVien> searchByKey(String key, Pageable pageable);
    String generateCustomerCode();

}

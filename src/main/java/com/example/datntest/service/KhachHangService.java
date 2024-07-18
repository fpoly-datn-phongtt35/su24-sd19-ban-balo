package com.example.datntest.service;

import com.example.datntest.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    Page<KhachHang> getAll(int pages);
    KhachHang add(KhachHang khachHang);
    KhachHang detail(Integer idKhachHang);
    KhachHang delete(Integer idKhachHang);
    Page<KhachHang> searchByTenKhachHang(String tenKhachHang, Pageable pageable);

}

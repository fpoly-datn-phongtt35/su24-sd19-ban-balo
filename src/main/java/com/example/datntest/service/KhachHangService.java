package com.example.datntest.service;

import com.example.datntest.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface KhachHangService {
    Page<KhachHang> getAll(int pages);
    void add(KhachHang khachHang);
    KhachHang detail(Integer idKhachHang);
    KhachHang delete(Integer idKhachHang);
}

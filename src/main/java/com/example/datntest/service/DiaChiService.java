package com.example.datntest.service;

import com.example.datntest.entity.DiaChi;

import java.util.List;
import java.util.UUID;

public interface DiaChiService {
    List<DiaChi> danhSachDiaChi(Integer idKhachHang);
}

package com.example.datntest.service;

import com.example.datntest.entity.DongSanPham;
import com.example.datntest.entity.SanPham;
import org.springframework.data.domain.Page;


public interface DongSanPhamService {
    Page<DongSanPham> getAll(int page);
    void add(DongSanPham dongSanPham);
    DongSanPham detail(Integer id);
    DongSanPham delete(Integer id);
}

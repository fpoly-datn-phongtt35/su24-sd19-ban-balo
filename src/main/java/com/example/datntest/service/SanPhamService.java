package com.example.datntest.service;

import com.example.datntest.entity.SanPham;
import com.example.datntest.entity.Size;
import org.springframework.data.domain.Page;


public interface SanPhamService {
    Page<SanPham> getAll(int page);
    void add(SanPham sanPham);
    SanPham detail(Integer id);
    SanPham delete(Integer id);
}

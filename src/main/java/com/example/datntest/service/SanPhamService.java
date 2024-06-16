package com.example.datntest.service;

import com.example.datntest.entity.SanPham;
import org.springframework.data.domain.Page;


public interface SanPhamService {
    Page<SanPham> getAll(int page);
    void add(SanPham sanPham);
    SanPham detail(Integer idSanPham);
    SanPham delete(Integer idSanPham);

}

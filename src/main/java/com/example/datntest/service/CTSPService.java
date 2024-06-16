package com.example.datntest.service;

import com.example.datntest.entity.Anh;
import com.example.datntest.entity.CTSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;


public interface CTSPService {
//    Page<CTSP> getAll(int page);
//
    void add(CTSP ctsp);
    CTSP detail(Integer idCTSP);
    CTSP delete(Integer idCTSP);
//    tìm theo tên
    Page<CTSP> searchByTenSanPham(String tenSanPham, Pageable pageable);
    // tìm theo giá
    Page<CTSP> searchByPriceRange(BigDecimal minGiaBan, BigDecimal maxGiaBan, Pageable pageable);
    //tất
    Page<CTSP> searchByTenSanPhamAndPriceRange(String tenSanPham, BigDecimal minGiaBan, BigDecimal maxGiaBan, Pageable pageable);
}

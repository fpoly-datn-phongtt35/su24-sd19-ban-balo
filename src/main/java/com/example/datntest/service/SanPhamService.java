package com.example.datntest.service;

import com.example.datntest.entity.CTSP;
import com.example.datntest.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;


public interface SanPhamService {
    Page<SanPham> getAll(Pageable pageable);
    void add(SanPham sanPham);
    SanPham detail(Integer idSanPham);
    SanPham delete(Integer idSanPham);
//tìm kiếmx
    Page<SanPham> timKiemTheoTen(String tenSanPham, Pageable pageable);
    Page<SanPham> timKiemTheoTenChatLieu(Pageable pageable, String tenChatLieu);
    Page<SanPham> timKiemTheoTenDongSanPham(Pageable pageable, String tenDongSanPham);
    Page<SanPham> timKiemTheoTenHang(Pageable pageable, String tenHang);
    //khoảng giá
    Page<SanPham> timKiemTheoKhoangGia(BigDecimal giaTu, BigDecimal giaDen, Pageable pageable);
//tổng
    public Page<SanPham> searchSanPham(Pageable pageable, String tenSanPham, String tenChatLieu,String tenDongSanPham,String tenHang, BigDecimal giaTu, BigDecimal giaDen);
}

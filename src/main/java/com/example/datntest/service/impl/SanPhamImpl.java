package com.example.datntest.service.impl;

import com.example.datntest.entity.CTSP;
import com.example.datntest.entity.SanPham;
import com.example.datntest.repository.SanPhamRepository;
import com.example.datntest.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SanPhamImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Override
    public Page<SanPham> getAll(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public void add(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham detail(Integer idSanPham) {
        return sanPhamRepository.findById(idSanPham).orElse(null);
    }

    @Override
    public SanPham delete(Integer idSanPham) {
        sanPhamRepository.deleteById(idSanPham);
        return null;
    }

    //tìm kiếm
    @Override
    public Page<SanPham> timKiemTheoTenChatLieu(Pageable pageable, String tenChatLieu) {
        return sanPhamRepository.findByIdChatLieu_TenChatLieu(pageable, tenChatLieu);
    }
    @Override
    public Page<SanPham> timKiemTheoTenDongSanPham(Pageable pageable, String tenDongSanPham) {
        return sanPhamRepository.findByIdDongSanPham_TenDongSanPham(pageable, tenDongSanPham);
    }
    @Override
    public Page<SanPham> timKiemTheoTenHang(Pageable pageable, String tenHang) {
        return sanPhamRepository.findByIdHang_TenHang(pageable, tenHang);
    }


    @Override
    public Page<SanPham> timKiemTheoTen(String tenSanPham, Pageable pageable) {
        return sanPhamRepository.findByTenSanPhamContaining(tenSanPham, pageable);
    }
    //khoảng giá
    @Override
    public Page<SanPham> timKiemTheoKhoangGia(BigDecimal giaTu, BigDecimal giaDen, Pageable pageable) {
        return sanPhamRepository.findByGiaNhapBetween(giaTu, giaDen, pageable);
    }
    //tổng tìm
    @Override
    public Page<SanPham> searchSanPham(Pageable pageable, String tenSanPham,String tenDongSanPham, String tenChatLieu,String tenHang, BigDecimal giaTu, BigDecimal giaDen) {
        return sanPhamRepository.searchSanPham(pageable, tenSanPham, tenChatLieu,tenDongSanPham,tenHang, giaTu, giaDen);
    }

}

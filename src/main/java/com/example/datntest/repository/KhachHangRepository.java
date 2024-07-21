package com.example.datntest.repository;

import com.example.datntest.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface KhachHangRepository extends JpaRepository<KhachHang,Integer> {
    @Query("select c from KhachHang c  order by c.maKhachHang desc ")
    Page<KhachHang> getAll(Pageable pageable);

    @Query("SELECT kh FROM KhachHang kh WHERE kh.tenKhachHang LIKE :tenKhachHang")
    Page<KhachHang> searchByTenKhachHang(String tenKhachHang, Pageable pageable);

}

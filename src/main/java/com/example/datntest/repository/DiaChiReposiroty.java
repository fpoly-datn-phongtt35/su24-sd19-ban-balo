package com.example.datntest.repository;

import com.example.datntest.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DiaChiReposiroty extends JpaRepository<DiaChi,Integer> {
    @Query("select c from DiaChi c  where  c.khachHang.idKhachHang = 0 and c.khachHang.idKhachHang=:id")
    List<DiaChi> danhSachDiaChi(Integer id);
}

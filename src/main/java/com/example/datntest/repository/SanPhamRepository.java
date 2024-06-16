package com.example.datntest.repository;

import com.example.datntest.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {
    public static final int ACTIVE =1;
    public static final int INACTIVE =0;
    public List<SanPham> findBytrangThai(int trangThai);



}

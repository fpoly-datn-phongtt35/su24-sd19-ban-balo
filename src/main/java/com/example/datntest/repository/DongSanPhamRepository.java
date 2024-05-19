package com.example.datntest.repository;

import com.example.datntest.entity.DongSanPham;
import com.example.datntest.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DongSanPhamRepository extends JpaRepository<DongSanPham,Integer> {
}

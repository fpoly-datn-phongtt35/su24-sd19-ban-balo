package com.example.demo.repsitory;


import com.example.demo.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    Optional<KhachHang> findByMaKhachHang(String maKhachHang);

    Optional<KhachHang> findById(Long id);

    boolean existsByMaKhachHang(String maKhachHang);

    boolean existsBySdt(String sdt);
}

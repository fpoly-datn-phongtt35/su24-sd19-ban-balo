package com.example.demo.repsitory;

import com.example.demo.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
//    @Query("select p from NhanVien p")
//    Page<NhanVien> getAllNhanVien(Pageable pageable);
}

package com.example.demo.repsitory;

import com.example.demo.model.NhanVien;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    @Query(value = "select * from NhanVien where TenNhanVien like %:key%",nativeQuery = true)
    Page<NhanVien> searchByKey(@Param("key")String key, Pageable pageable);
    @Query(value = "select * from NhanVien", nativeQuery = true)
    Page<NhanVien> findAll(Pageable pageable);
}

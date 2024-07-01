package com.example.demo.repsitory;

import com.example.demo.model.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, Long> {
    boolean existsByTenChucVu(String tenChucVu);
    ChucVu getFirstByTenChucVu(String tenChucVu);
}

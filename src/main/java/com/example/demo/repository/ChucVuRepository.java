package com.example.demo.repository;

import com.example.demo.model.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu,Long> {
//    boolean existsByTen(String tenChucVu);
//    ChucVu getFirstByTen(String tenChucVu);


}

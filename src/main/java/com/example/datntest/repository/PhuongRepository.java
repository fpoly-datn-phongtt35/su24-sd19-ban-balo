package com.example.datntest.repository;

import com.example.datntest.entity.Phuong;
import com.example.datntest.entity.Quan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhuongRepository extends JpaRepository<Phuong, Integer> {
    List<Phuong> findByQuanIdQuan(Integer QuanIdQuan);
}

package com.example.datntest.repository;

import com.example.datntest.entity.Quan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuanRepository extends JpaRepository<Quan, Integer> {
    List<Quan> findByTinhIdTinh(Integer TinhIdTinh);
}

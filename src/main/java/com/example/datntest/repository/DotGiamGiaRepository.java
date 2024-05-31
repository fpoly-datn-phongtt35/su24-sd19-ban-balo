package com.example.datntest.repository;

import com.example.datntest.entity.Anh;
import com.example.datntest.entity.DotGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DotGiamGiaRepository extends JpaRepository<DotGiamGia,Integer> {
}

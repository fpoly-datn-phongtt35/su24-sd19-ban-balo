package com.example.datntest.repository;

import com.example.datntest.entity.Anh;
import com.example.datntest.entity.Hang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnhRepository extends JpaRepository<Anh,Integer> {
}

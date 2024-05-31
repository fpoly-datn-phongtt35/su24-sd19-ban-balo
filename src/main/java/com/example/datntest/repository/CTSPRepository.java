package com.example.datntest.repository;

import com.example.datntest.entity.CTSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTSPRepository extends JpaRepository<CTSP,Integer> {
}

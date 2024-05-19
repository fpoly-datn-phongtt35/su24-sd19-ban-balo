package com.example.datntest.repository;

import com.example.datntest.entity.NSX;
import com.example.datntest.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NSXRepository extends JpaRepository<NSX,Integer> {
}

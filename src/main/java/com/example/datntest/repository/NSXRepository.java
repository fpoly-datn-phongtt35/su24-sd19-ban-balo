package com.example.datntest.repository;

import com.example.datntest.entity.MauSac;
import com.example.datntest.entity.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NSXRepository extends JpaRepository<NSX,Integer> {

    public static final int ACTIVE =1;
    public static final int INACTIVE =0;
    public List<NSX> findBytrangThai(int trangThai);

}

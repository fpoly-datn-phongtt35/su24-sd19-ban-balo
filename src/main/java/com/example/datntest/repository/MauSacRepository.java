package com.example.datntest.repository;

import com.example.datntest.entity.DongSanPham;
import com.example.datntest.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac,Integer> {

    public static final int ACTIVE =1;
    public static final int INACTIVE =0;
    public List<MauSac> findBytrangThai(int trangThai);

}

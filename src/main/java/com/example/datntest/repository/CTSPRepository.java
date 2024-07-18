package com.example.datntest.repository;

import com.example.datntest.entity.CTSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface CTSPRepository extends JpaRepository<CTSP,Integer> {
//%?1%
    public static final int ACTIVE =1;
    public static final int INACTIVE =0;
    public Page<CTSP> findBytrangThai(int trangThai,Pageable pageable);


    @Query("SELECT ctsp FROM CTSP ctsp WHERE ctsp.idSanPham.tenSanPham LIKE :tenSanPham AND ctsp.trangThai!=0")
    Page<CTSP> searchByTenSanPham(String tenSanPham, Pageable pageable);

    @Query("SELECT ctsp FROM CTSP ctsp WHERE ctsp.giaBan BETWEEN ?1 AND ?2 AND ctsp.trangThai!=0")
    Page<CTSP> findByGiaBanBetween(BigDecimal minGiaBan, BigDecimal maxGiaBan, Pageable pageable);

    //cungf lucs
    @Query("SELECT ctsp FROM CTSP ctsp WHERE ctsp.idSanPham.tenSanPham LIKE %?1% AND ctsp.giaBan BETWEEN ?2 AND ?3 AND ctsp.trangThai!=0")
    Page<CTSP> findByTenSanPhamContainingAndGiaBanBetween(String tenSanPham, BigDecimal minGiaBan, BigDecimal maxGiaBan, Pageable pageable);

//detail

}

package com.example.demo.repositories;

import com.example.demo.models.TrongLuong;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrongLuongRepository extends JpaRepository<TrongLuong, UUID> {
    @Query("select c from TrongLuong c  where c.trangThai=0 order by c.ma desc ")
    Page<TrongLuong> getAll(Pageable pageable);

    @Query("select c from TrongLuong c  where c.trangThai=1 order by c.ma desc ")
    Page<TrongLuong> getAll1(Pageable pageable);

    @Query("select c from TrongLuong c  where  c.trangThai = 0")
    List<TrongLuong> findAll0();

    @Query("select c from TrongLuong c  where  c.trangThai = 0 and (c.ma like %:ten% or c.ten like %:ten%)")
    List<TrongLuong> search0(String ten);

    @Query("select c from TrongLuong c  where  c.trangThai = 1 and (c.ma like %:ten% or c.ten like %:ten%)")
    List<TrongLuong> search1(String ten);

    @Transactional
    @Modifying
    @Query(value = "update TrongLuong set trangThai=0, ngaySua=convert(date,getdate(),105)", nativeQuery = true)
    void updateTT();

    TrongLuong findTrongLuongByMa(String ma);
    TrongLuong findTrongLuongByTen(String ten);
}

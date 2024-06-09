package com.example.maindatn.Repository;

import com.example.maindatn.Entity.PhieuGiamGia_Entity;
import com.example.maindatn.Entity.User_Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PhieuGiamGia_Repository extends JpaRepository<PhieuGiamGia_Entity,Integer> {
    public static final int ACTIVE =1;
    public static final int INACTIVE =0;
    public Page<PhieuGiamGia_Entity> findBytrangthai(int trangthai, Pageable pageable);


    @Query("SELECT c from User_Entity c join NhanVien_Entity b on c.nhanVien = b " +
            "join ChucVu_Entity d on b.idChucVu=d where d.id =1")
    List<User_Entity> getme();

}

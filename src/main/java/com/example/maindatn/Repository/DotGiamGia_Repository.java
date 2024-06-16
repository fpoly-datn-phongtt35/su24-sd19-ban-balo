package com.example.maindatn.Repository;

import com.example.maindatn.Entity.DotGiamGia_Entity;
import com.example.maindatn.Entity.PhieuGiamGia_Entity;
import com.example.maindatn.Entity.User_Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DotGiamGia_Repository  extends JpaRepository<DotGiamGia_Entity,Integer> {
    public static final int ACTIVE =1;
    public static final int INACTIVE =0;
    //GetSanPham
    @Query("SELECT c from DotGiamGia_Entity c where c.trangthai!=0")
    public Page<DotGiamGia_Entity> getDotGG( Pageable pageable);

    @Query("SELECT c from User_Entity c join NhanVien_Entity b on c.nhanVien = b " +
            "join ChucVu_Entity d on b.idChucVu=d where d.id =1")
    List<User_Entity> getme();


    //Xoa(update ve 0)
    @Transactional
    @Modifying
    @Query("update DotGiamGia_Entity c set c.trangthai=0 where c.id=:ID")
    void updateTrangthai_0(@Param("ID") Integer id);


}

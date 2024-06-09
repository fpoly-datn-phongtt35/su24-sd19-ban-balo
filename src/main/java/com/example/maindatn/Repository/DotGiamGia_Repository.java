package com.example.maindatn.Repository;

import com.example.maindatn.Entity.DotGiamGia_Entity;
import com.example.maindatn.Entity.PhieuGiamGia_Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DotGiamGia_Repository  extends JpaRepository<DotGiamGia_Entity,Integer> {
    public static final int ACTIVE =1;
    public static final int INACTIVE =0;
    public Page<DotGiamGia_Entity> findBytrangthai(int trangthai, Pageable pageable);

}

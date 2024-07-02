package com.example.datntest.repository;

import com.example.datntest.entity.CTSP;
import com.example.datntest.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {
    public static final int ACTIVE =1;
    public static final int INACTIVE =0;
    public List<SanPham> findBytrangThai(int trangThai);

//tìm kiếm
    @Query("SELECT sanpham FROM SanPham sanpham WHERE sanpham.tenSanPham LIKE :tenSanPham AND sanpham.trangThai!=0")
    Page<SanPham> findByTenSanPhamContaining(String tenSanPham, Pageable pageable);

    @Query("SELECT sanpham FROM SanPham sanpham WHERE sanpham.idChatLieu.tenChatLieu LIKE :tenChatLieu AND sanpham.trangThai!=0")
    Page<SanPham> findByIdChatLieu_TenChatLieu(Pageable pageable, String tenChatLieu);

    //khoảng giá
    @Query("SELECT sanpham FROM SanPham sanpham WHERE sanpham.giaNhap BETWEEN ?1 AND ?2 AND sanpham.trangThai!=0")
    Page<SanPham> findByGiaNhapBetween(BigDecimal giaTu, BigDecimal giaDen, Pageable pageable);

    //tổng
    @Query("SELECT s FROM SanPham s WHERE " +
            "(:tenSanPham IS NULL OR s.tenSanPham LIKE %:tenSanPham%) AND " +
            "(:tenChatLieu IS NULL OR s.idChatLieu.tenChatLieu IN :tenChatLieu) AND " +
            "(:giaTu IS NULL OR s.giaNhap >= :giaTu) AND " +
            "(:giaDen IS NULL OR s.giaNhap <= :giaDen)")
    Page<SanPham> findByCriteria(@Param("tenSanPham") String tenSanPham,
                                 @Param("tenChatLieu") List<String> tenChatLieu,
                                 @Param("giaTu") BigDecimal giaTu,
                                 @Param("giaDen") BigDecimal giaDen,
                                 Pageable pageable);

    //test ko lod trang
    @Query("SELECT c from SanPham c where c.trangThai!=0")
    List<SanPham> getSanPham();

    @Query("SELECT c from SanPham c where c.trangThai!=0 and c.tenSanPham=:query or c.maSanPham=:query")
    List<SanPham> ListtimTheoTenorMa(String query);
}

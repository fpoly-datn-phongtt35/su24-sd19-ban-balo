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

//    @Query("SELECT C.url FROM CTSP A " +
//            "JOIN SanPham B ON A.idSanPham = B " +
//            "JOIN Anh C ON A.idAnh = C " +
//            "WHERE B.idSanPham = :id " +
//            "ORDER BY C.idAnh DESC")
//    List<String> getNameAnh ( @Param("id") int id);
    //Join lấy ảnh CTSP

//    @Query("SELECT B FROM CTSP A " +
//            "JOIN SanPham B ON A.idSanPham = B " +
//            "JOIN Anh C ON A.idAnh = C " +
//            "ORDER BY C.idAnh DESC")
//
//    Page<SanPham> getALLwHAnh(Pageable pageable);

//tìm kiếm
    @Query("SELECT sanpham FROM SanPham sanpham WHERE sanpham.tenSanPham LIKE %:tenSanPham% AND sanpham.trangThai!=0")
    Page<SanPham> findByTenSanPhamContaining(String tenSanPham, Pageable pageable);

    @Query("SELECT sanpham FROM SanPham sanpham WHERE sanpham.idChatLieu.tenChatLieu LIKE :tenChatLieu AND sanpham.trangThai!=0")
    Page<SanPham> findByIdChatLieu_TenChatLieu(Pageable pageable, String tenChatLieu);

    @Query("SELECT sp FROM SanPham sp WHERE sp.idDongSanPham.tenDongSanPham = :tenDongSanPham AND sp.trangThai != 0")
    Page<SanPham> findByIdDongSanPham_TenDongSanPham(Pageable pageable, String tenDongSanPham);

    @Query("SELECT sp FROM SanPham sp WHERE sp.idHang.tenHang = :tenHang AND sp.trangThai != 0")
    Page<SanPham> findByIdHang_TenHang(Pageable pageable, String tenHang);

    //khoảng giá
    @Query("SELECT sanpham FROM SanPham sanpham WHERE sanpham.giaNhap BETWEEN ?1 AND ?2 AND sanpham.trangThai!=0")
    Page<SanPham> findByGiaNhapBetween(BigDecimal giaTu, BigDecimal giaDen, Pageable pageable);

    //tổng
    @Query("SELECT sp FROM SanPham sp WHERE " +
            "(:tenSanPham IS NULL OR sp.tenSanPham LIKE %:tenSanPham%) AND " +
            "(:tenChatLieu IS NULL OR sp.idChatLieu.tenChatLieu = :tenChatLieu) AND " +
            "(:tenDongSanPham IS NULL OR sp.idDongSanPham.tenDongSanPham = :tenDongSanPham) AND " +
            "(:tenHang IS NULL OR sp.idHang.tenHang = :tenHang) AND " +
            "(:giaTu IS NULL OR sp.giaNhap >= :giaTu) AND " +
            "(:giaDen IS NULL OR sp.giaNhap <= :giaDen) AND sp.trangThai != 0")
    Page<SanPham> searchSanPham(Pageable pageable, String tenSanPham, String tenChatLieu, String tenDongSanPham, String tenHang, BigDecimal giaTu, BigDecimal giaDen);


    //test ko lod trang
    @Query("SELECT c from SanPham c where c.trangThai!=0")
    List<SanPham> getSanPham();

    @Query("SELECT c from SanPham c where c.trangThai!=0 and c.tenSanPham=:query or c.maSanPham=:query")
    List<SanPham> ListtimTheoTenorMa(String query);
}

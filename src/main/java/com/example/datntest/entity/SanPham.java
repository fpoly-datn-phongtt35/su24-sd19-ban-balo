package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "SanPham")
public class SanPham {
    @Id
    @Column(name = "IdSanPham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSanPham;

    @ManyToOne
    @JoinColumn(name = "IdChatLieu", referencedColumnName = "IdChatLieu")
    private ChatLieu idChatLieu;

    @ManyToOne
    @JoinColumn(name = "IdDongSanPham", referencedColumnName = "IdDongSanPham")
    private DongSanPham idDongSanPham;


    @ManyToOne
    @JoinColumn(name = "IdNSX", referencedColumnName = "IdNSX")
    private NSX idNSX;

    @ManyToOne
    @JoinColumn(name = "IdHang", referencedColumnName = "IdHang")
    private Hang idHang;

    @Column(name = "MaSanPham")
    private String maSanPham;

    @Column(name = "TenSanPham")
    private String tenSanPham;

    @Column(name = "ChieuDai")
    private Integer chieuDai;

    @Column(name = "ChieuRong")
    private Integer chieuRong;

    @Column(name = "ChieuCao")
    private Integer chieuCao;

    @Column(name = "TrongLuong")
    private Integer trongLuong;

    @Column(name = "TrongLuongToiDa")
    private Integer trongLuongToiDa;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

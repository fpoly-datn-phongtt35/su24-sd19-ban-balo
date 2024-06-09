package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdSanPham", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNSX")
    private Nsx idNSX;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHang")
    private Hang idHang;

    @Nationalized
    @Column(name = "MaSanPham", length = 20)
    private String maSanPham;

    @Nationalized
    @Column(name = "TenSanPham", length = 20)
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

    @Column(name = "GiaNhap", precision = 11, scale = 2)
    private BigDecimal giaNhap;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgaySua")
    private LocalDate ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
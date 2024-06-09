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
public class PhieuGiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPhieuGiamGia", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "MaPhieuGiamGia", length = 20)
    private String maPhieuGiamGia;

    @Nationalized
    @Column(name = "TenPhieuGiamGia", length = 50)
    private String tenPhieuGiamGia;

    @Column(name = "NgayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "NgayKetThuc")
    private LocalDate ngayKetThuc;

    @Column(name = "GiamToiDa", precision = 11, scale = 2)
    private BigDecimal giamToiDa;

    @Column(name = "DieuKien", precision = 11, scale = 2)
    private BigDecimal dieuKien;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiTao")
    private User nguoiTao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiSua")
    private User nguoiSua;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgaySua")
    private LocalDate ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
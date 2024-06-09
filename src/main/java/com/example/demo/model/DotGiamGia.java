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
public class DotGiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDotGiamGia", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "MaDotGiamGia", length = 20)
    private String maDotGiamGia;

    @Nationalized
    @Column(name = "TenDotGiamGia", length = 20)
    private String tenDotGiamGia;

    @Column(name = "GiaTriDotGiamGia", precision = 11, scale = 2)
    private BigDecimal giaTriDotGiamGia;

    @Nationalized
    @Column(name = "Loai", length = 100)
    private String loai;

    @Column(name = "NgayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "NgayKetThuc")
    private LocalDate ngayKetThuc;

    @Column(name = "GiamToiDa", precision = 11, scale = 2)
    private BigDecimal giamToiDa;

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
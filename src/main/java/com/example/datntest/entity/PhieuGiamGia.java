package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "PhieuGiamGia")
public class PhieuGiamGia {
    @Id
    @Column(name = "IdPhieuGiamGia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPhieuGiamGia;

    @Column(name = "MaPhieuGiamGia")
    private String maPhieuGiamGia;

    @Column(name = "TenPhieuGiamGia")
    private String tenPhieuGiamGia;

    @Column(name = "NgayBatDau")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKetThuc;

    @Column(name = "GiamToiDa")
    private BigDecimal giamToiDa;

    @Column(name = "DieuKien")
    private BigDecimal dieuKien;
//
//    @ManyToOne
//    @JoinColumn(name = "NguoiTao", insertable = true, updatable = true, referencedColumnName = "IdUsers")
//    private Users nguoiTao;
//
//    @ManyToOne
//    @JoinColumn(name = "NguoiSua", insertable = true, updatable = true, referencedColumnName = "IdUsers")
//    private Users nguoiSua;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

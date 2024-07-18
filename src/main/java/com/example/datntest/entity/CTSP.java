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
@Table(name = "CTSP")
public class CTSP {

    @Id
    @Column(name = "IdCTSP")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCTSP;

    @ManyToOne
    @JoinColumn(name = "IdSanPham", referencedColumnName = "IdSanPham")
    private SanPham idSanPham;

    @ManyToOne
    @JoinColumn(name = "IdMauSac", referencedColumnName = "IdMauSac")
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "IdAnh", referencedColumnName = "IdAnh")
    private Anh idAnh;

    @Column(name = "Mota")
    private String moTa;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiTao", insertable = true, updatable = true, referencedColumnName = "IdUsers")
    private Users nguoiTao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiSua", insertable = true, updatable = true, referencedColumnName = "IdUsers")
    private Users nguoiSua;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

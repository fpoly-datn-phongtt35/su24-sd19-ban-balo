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
@Table(name = "DotGiamGia")
public class DotGiamGia {
    @Id
    @Column(name = "IdDotGiamGia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDotGiamGia;

    @Column(name = "MaDotGiamGia")
    private String maDotGiamGia;

    @Column(name = "TenDotGiamGia")
    private String tenDotGiamGia;

    @Column(name = "GiaTriDotGiamGia")
    private BigDecimal giaTriDotGiamGia;

    @Column(name = "Loai")
    private String loai;

    @Column(name = "NgayBatDau")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKetThuc;

    @Column(name = "GiamToiDa")
    private BigDecimal giamToiDa;

    @ManyToOne
    @JoinColumn(name = "NguoiTao", insertable = false, updatable = false, referencedColumnName = "IdUsers")
    private Users nguoiTao;

    @ManyToOne
    @JoinColumn(name = "NguoiSua", insertable = false, updatable = false, referencedColumnName = "IdUsers")
    private Users nguoiSua;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

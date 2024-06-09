package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdNhanVien", nullable = false)
    private Integer id;

    @Column(name = "MaNhanVien", length = 20)
    private String maNhanVien;

    @Column(name = "TenNhanVien", length = 20)
    private String tenNhanVien;

    @Column(name = "HoNhanVien", length = 20)
    private String hoNhanVien;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "GioiTinh")
    private boolean gioiTinh;

    @Column(name = "SDT", length = 15)
    private String sdt;


    @Column(name = "CCCD", length = 15)
    private String cccd;

    @Column(name = "SoNha", length = 10)
    private String soNha;

    @Column(name = "PhuongXa", length = 50)
    private String phuongXa;

    @Column(name = "QuanHuyen", length = 50)
    private String quanHuyen;

    @Column(name = "TinhThanhPho", length = 50)
    private String tinhThanhPho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChucVu", referencedColumnName = "IdChucVu")
    private ChucVu idChucVu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiTao", referencedColumnName = "IdUsers")
    private Users nguoiTao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiSua", referencedColumnName = "IdUsers")
    private Users nguoiSua;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
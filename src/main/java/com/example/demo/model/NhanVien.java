package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdNhanVien", nullable = false)
    private Long id;

    @Nationalized
    @Column(name = "MaNhanVien", length = 20)
    private String maNhanVien;

    @Nationalized
    @Column(name = "TenNhanVien", length = 20)
    private String tenNhanVien;

    @Nationalized
    @Column(name = "HoNhanVien", length = 20)
    private String hoNhanVien;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "GioiTinh")
    private boolean gioiTinh;

    @Nationalized
    @Column(name = "SDT", length = 15)
    private String sdt;

    @Nationalized
    @Column(name = "CCCD", length = 15)
    private String cccd;

    @Nationalized
    @Column(name = "SoNha", length = 10)
    private String soNha;

    @Nationalized
    @Column(name = "PhuongXa", length = 50)
    private String phuongXa;

    @Nationalized
    @Column(name = "QuanHuyen", length = 50)
    private String quanHuyen;

    @Nationalized
    @Column(name = "TinhThanhPho", length = 50)
    private String tinhThanhPho;

    @Nationalized
    @Column(name = "MatKhau", length = 20)
    private String matKhau;

    @Column(name = "NguoiTao")
    private Integer nguoiTao;

    @Column(name = "NguoiSua")
    private Integer nguoiSua;

    @Column(name = "NgayTao")
    private Timestamp ngayTao;

    @Column(name = "NgaySua")
    private Timestamp ngaySua;

    @Column(name = "TrangThai")
    private boolean trangThai;

}
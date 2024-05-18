package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdNhanVien", nullable = false)
    private int id;

    @Nationalized
    @Column(name = "MaNhanVien", nullable = false, length = 20)
    private String maNhanVien;

    @Nationalized
    @Column(name = "TenNhanVien", nullable = false, length = 20)
    private String tenNhanVien;

    @Nationalized
    @Column(name = "HoNhanVien", nullable = false, length = 20)
    private String hoNhanVien;

    @Column(name = "NgaySinh", nullable = false)
    private LocalDate ngaySinh;

    @Column(name = "GioiTinh", nullable = false)
    private int gioiTinh;

    @Nationalized
    @Column(name = "SDT", nullable = false, length = 15)
    private String sdt;

    @Nationalized
    @Column(name = "CCCD", nullable = false, length = 15)
    private String cccd;

    @Nationalized
    @Column(name = "DiaChi", nullable = false, length = 40)
    private String diaChi;

    @Nationalized
    @Column(name = "ThanhPho", nullable = false, length = 20)
    private String thanhPho;

    @Nationalized
    @Column(name = "Quan", nullable = false, length = 20)
    private String quan;

    @Nationalized
    @Column(name = "Xa", nullable = false, length = 20)
    private String xa;

    @Nationalized
    @Column(name = "QuocGia", nullable = false, length = 20)
    private String quocGia;

    git branch -d huy



    @Nationalized
    @Column(name = "MatKhau", nullable = false, length = 20)
    private String matKhau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChucVu")
    private ChucVu idChucVu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCuaHang")
    private CuaHang idCuaHang;

    @Column(name = "NgayTao", nullable = false)
    private LocalDate ngayTao;

    @Column(name = "NgaySua", nullable = false)
    private LocalDate ngaySua;

    @Column(name = "TrangThai", nullable = false)
    private int trangThai;

}
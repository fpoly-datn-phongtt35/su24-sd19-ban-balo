package com.example.maindatn.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdKhachHang")
    private Integer idKhachHang;
    @Column(name = "MaKhachHang")
    private String maKhachHang;
    @Column(name = "TenKhachHang")
    private String tenKhachHang;
    @Column(name = "HoKhachHang")
    private String hoKhachHang;
    @Column(name = "NgaySinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;
    @Column(name = "GioiTinh")
    private Integer gioiTinh;
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "CCCD")
    private String cccd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HangKhachHang", referencedColumnName = "IdHangKhachHang")
    private HangKhachHang_Entity hangKhachHang;
    @Column(name = "SoNha")
    private String soNha;
    @Column(name = "PhuongXa")
    private String phuongXa;
    @Column(name = "QuanHuyen")
    private String quanHuyen;
    @Column(name = "TinhThanhPho")
    private String tinhThanhPho;
    @Column(name = "DiemTichLuy")
    private Integer diemTichLuy;
    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;
    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;
    @Column(name = "TrangThai")
    private Integer trangThai;
}

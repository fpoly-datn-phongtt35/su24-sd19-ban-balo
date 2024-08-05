package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdKhachHang")
    private Integer idKhachHang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUserKH", referencedColumnName = "IdUserKH")
    private User user;
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
    private HangKhachHang hangKhachHang;
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

    public void setHangKhachHang(HangKhachHang hangKhachHang) {
        this.hangKhachHang = hangKhachHang;
    }
}

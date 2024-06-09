package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdKhachHang", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "MaKhachHang", length = 20)
    private String maKhachHang;

    @Nationalized
    @Column(name = "TenKhachHang", length = 20)
    private String tenKhachHang;

    @Nationalized
    @Column(name = "HoKhachHang", length = 20)
    private String hoKhachHang;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Nationalized
    @Column(name = "SDT", length = 10)
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

    @ColumnDefault("0")
    @Column(name = "DiemTichLuy")
    private Integer diemTichLuy;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgaySua")
    private LocalDate ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
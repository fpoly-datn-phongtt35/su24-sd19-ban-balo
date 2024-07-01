package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdKhachHang", nullable = false)
    private Long id;

    @Size(max = 20)
    @Nationalized
    @Column(name = "MaKhachHang", length = 20)
    private String maKhachHang;

    @Size(max = 20)
    @Nationalized
    @Column(name = "TenKhachHang", length = 20)
    private String tenKhachHang;

    @Size(max = 20)
    @Nationalized
    @Column(name = "HoKhachHang", length = 20)
    private String hoKhachHang;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Size(max = 10)
    @Nationalized
    @Column(name = "SDT", length = 10)
    private String sdt;

    @Size(max = 15)
    @Nationalized
    @Column(name = "CCCD", length = 15)
    private String cccd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HangKhachHang")
    private HangKhachHang hangKhachHang;

    @Size(max = 10)
    @Nationalized
    @Column(name = "SoNha", length = 10)
    private String soNha;

    @Size(max = 50)
    @Nationalized
    @Column(name = "PhuongXa", length = 50)
    private String phuongXa;

    @Size(max = 50)
    @Nationalized
    @Column(name = "QuanHuyen", length = 50)
    private String quanHuyen;

    @Size(max = 50)
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
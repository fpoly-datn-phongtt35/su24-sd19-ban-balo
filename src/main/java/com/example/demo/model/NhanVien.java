package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdNhanVien", nullable = false)
    private int id;

    @Size(max = 20)
    @Nationalized
    @Column(name = "MaNhanVien", length = 20)
    private String maNhanVien;

    @Size(max = 20)
    @Nationalized
    @Column(name = "TenNhanVien", length = 20)
    private String tenNhanVien;

    @Size(max = 20)
    @Nationalized
    @Column(name = "HoNhanVien", length = 20)
    private String hoNhanVien;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Size(max = 15)
    @Nationalized
    @Column(name = "SDT", length = 15)
    private String sdt;

    @Size(max = 15)
    @Nationalized
    @Column(name = "CCCD", length = 15)
    private String cccd;

    @Size(max = 30)
    @Nationalized
    @Column(name = "SoNha", length = 30)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChucVu")
    private ChucVu chucVu;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgaySua")
    private LocalDate ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
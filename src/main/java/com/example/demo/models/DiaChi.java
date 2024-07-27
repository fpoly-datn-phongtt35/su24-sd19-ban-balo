package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "DiaChi")
public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "DiaChi")
    private String soDiaChi;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ThanhPho")
    private String thanhPho;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "Quan")
    private String quan;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "Phuong")
    private String phuong;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "NguoiTao")
    private String nguoiTao;

    @Column(name = "NguoiSua")
    private String nguoiSua;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "TrangThai")
    private int trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachHang;
}

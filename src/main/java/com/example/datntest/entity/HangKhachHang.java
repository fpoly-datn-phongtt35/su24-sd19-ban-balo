package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HangKhachHang")
public class HangKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdHangKhachHang")
    private Integer idHangKhachHang;
    @Column(name = "MaHangKhachHang")
    private String maHangKhachHang;
    @Column(name = "TenHangKhachHang")
    private String tenHangKhachHang;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "DiemToiThieu")
    private Integer diemToiThieu;
    @Column(name = "TrangThai")
    private Integer trangThai;

}

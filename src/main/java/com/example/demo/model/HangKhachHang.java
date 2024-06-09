package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class HangKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdHangKhachHang", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "MaHangKhachHang", length = 50)
    private String maHangKhachHang;

    @Nationalized
    @Column(name = "TenHangKhachHang", length = 50)
    private String tenHangKhachHang;

    @Nationalized
    @Column(name = "MoTa", length = 100)
    private String moTa;

    @Column(name = "DiemToiThieu")
    private Integer diemToiThieu;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
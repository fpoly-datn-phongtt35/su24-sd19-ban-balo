package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HangKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdHangKhachHang", nullable = false)
    private Long id;

    @Size(max = 50)
    @Nationalized
    @Column(name = "MaHangKhachHang", length = 50)
    private String maHangKhachHang;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TenHangKhachHang", length = 50)
    private String tenHangKhachHang;

    @Size(max = 100)
    @Nationalized
    @Column(name = "MoTa", length = 100)
    private String moTa;

    @Column(name = "DiemToiThieu")
    private Integer diemToiThieu;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
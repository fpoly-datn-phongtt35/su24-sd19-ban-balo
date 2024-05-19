package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "DongSanPham")
public class DongSanPham {
    @Id
    @Column(name = "IdDongSanPham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDongSanPham;

    @Column(name = "MaDongSanPham")
    private String maDongSanPham;

    @Column(name = "TenDongSanPham")
    private String tenDongSanPham;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

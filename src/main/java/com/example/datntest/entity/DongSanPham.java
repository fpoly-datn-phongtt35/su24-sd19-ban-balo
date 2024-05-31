package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

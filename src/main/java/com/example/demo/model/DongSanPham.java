package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class DongSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDongSanPham", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "MaDongSanPham", length = 20)
    private String maDongSanPham;

    @Nationalized
    @Column(name = "TenDongSanPham", length = 20)
    private String tenDongSanPham;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgaySua")
    private LocalDate ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
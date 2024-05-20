package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdChucVu", nullable = false)
    private Long id;

    @Nationalized
    @Column(name = "MaChucVu", length = 20)
    private String maChucVu;

    @Nationalized
    @Column(name = "TenChucVu", length = 20)
    private String tenChucVu;

    @Column(name = "NguoiTao")
    private Integer nguoiTao;

    @Column(name = "NguoiSua")
    private Integer nguoiSua;

    @Column(name = "NgayTao")
    private Timestamp ngayTao;

    @Column(name = "NgaySua")
    private Timestamp ngaySua;

    @Column(name = "TrangThai")
    private boolean trangThai;

}
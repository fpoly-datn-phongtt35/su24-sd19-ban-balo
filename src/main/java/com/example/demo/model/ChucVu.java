package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdChucVu", nullable = false)
    private int id;

    @Nationalized
    @Column(name = "MaChucVu", nullable = false, length = 20)
    private String maChucVu;

    @Nationalized
    @Column(name = "TenChucVu", nullable = false, length = 20)
    private String tenChucVu;

    @Column(name = "NgayTao", nullable = false)
    private Timestamp ngayTao;

    @Column(name = "NgaySua", nullable = false)
    private Timestamp ngaySua;

    @Column(name = "TrangThai", nullable = false)
    private int trangThai;

}
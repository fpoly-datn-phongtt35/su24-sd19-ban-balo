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
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCuaHang", nullable = false)
    private int id;

    @Nationalized
    @Column(name = "MaCuaHang", nullable = false, length = 20)
    private String maCuaHang;

    @Nationalized
    @Column(name = "TenCuaHang", nullable = false, length = 20)
    private String tenCuaHang;

    @Nationalized
    @Column(name = "DiaChi", nullable = false, length = 20)
    private String diaChi;

    @Nationalized
    @Column(name = "ThanhPho", nullable = false, length = 20)
    private String thanhPho;

    @Nationalized
    @Column(name = "Quan", nullable = false, length = 20)
    private String quan;

    @Nationalized
    @Column(name = "Xa", nullable = false, length = 20)
    private String xa;

    @Nationalized
    @Column(name = "QuocGia", nullable = false, length = 20)
    private String quocGia;

    @Column(name = "NgayTao", nullable = false)
    private Timestamp ngayTao;

    @Column(name = "NgaySua", nullable = false)
    private Timestamp ngaySua;

    @Column(name = "TrangThai", nullable = false)
    private int trangThai;

}
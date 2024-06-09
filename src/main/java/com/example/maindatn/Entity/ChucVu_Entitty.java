package com.example.maindatn.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ChucVu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChucVu_Entitty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "IdChucVu")
    private Integer id;
    @Column(name = "MaChucVu")
    private String maChucVu;
    @Column(name = "TenChucVu")
    private String tenChucVu;

    @Column(name = "NguoiTao")
    private Integer nguoiTao;

    @Column(name = "NguoiSua")
    private Integer nguoiSua;

    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;



}

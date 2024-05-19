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
@Table(name = "Hang")
public class Hang {
    @Id
    @Column(name = "IdHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHang;

    @Column(name = "MaHang")
    private String maHang;

    @Column(name = "TenHang")
    private String tenHang;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

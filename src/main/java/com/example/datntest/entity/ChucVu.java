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
@Table(name = "ChucVu")
public class ChucVu {

    @Id
    @Column(name = "IdChucVu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChucVu;

    @Column(name = "MaChucVu")
    private String maChucVu;

    @Column(name = "TenChucVu")
    private String tenChucVu;

    @ManyToOne
    @JoinColumn(name = "NguoiTao", insertable = false, updatable = false, referencedColumnName = "IdUsers")
    private Users nguoiTao;

    @ManyToOne
    @JoinColumn(name = "NguoiSua", insertable = false, updatable = false, referencedColumnName = "IdUsers")
    private Users nguoiSua;

    @Column(name = "NgayTao")
    private Date NgayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

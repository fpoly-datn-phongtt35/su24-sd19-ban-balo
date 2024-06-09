package com.example.maindatn.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ChucVu")
public class ChucVu_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdChucVu", nullable = false)
    private Integer id;

    @Column(name = "MaChucVu", length = 20)
    private String maChucVu;

    @Column(name = "TenChucVu", length = 20)
    private String tenChucVu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiTao", referencedColumnName = "IdUsers")
    private User_Entity nguoiTao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiSua", referencedColumnName = "IdUsers")
    private User_Entity nguoiSua;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private int trangThai;
}

package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsers", nullable = false)
    private Long id;

    @Nationalized
    @Column(name = "Email", length = 50)
    private String email;

    @Nationalized
    @Column(name = "PassWord", length = 50)
    private String passWord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChucVu")
    private ChucVu idChucVu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNhanVien")
    private NhanVien idNhanVien;

    @Column(name = "NgayThanhToan")
    private Timestamp ngayThanhToan;

    @Nationalized
    @Column(name = "GhiChu", length = 50)
    private String ghiChu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiTao")
    private User nguoiTao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiSua")
    private User nguoiSua;

    @Column(name = "NgayTao")
    private Timestamp ngayTao;

    @Column(name = "NgaySua")
    private Timestamp ngaySua;

    @Column(name = "TrangThai")
    private boolean trangThai;

}
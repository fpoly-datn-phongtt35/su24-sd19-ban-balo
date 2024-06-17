package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

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
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKhachHang")
    private KhachHang idKhachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNhanVien")
    private NhanVien idNhanVien;

    @Nationalized
    @Column(name = "Email", length = 50)
    private String email;

    @Nationalized
    @Column(name = "PassWord", length = 50)
    private String passWord;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgaySua")
    private LocalDate ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsers")
    private Integer idUsers;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKhachHang", referencedColumnName = "IdKhachHang")
    private KhachHang khachHang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNhanVien", referencedColumnName = "IdNhanVien")
    private NhanVien nhanVien;

    @Column(name = "Email")
    private String email;
    @Column(name = "PassWord")
    private String passWord;
    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "NgaySua")
    private Date ngaySua;
    @Column(name = "TrangThai")
    private Integer trangThai;

}

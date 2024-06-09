package com.example.maindatn.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsers")
    private Integer idUsers;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKhachHang", referencedColumnName = "IdKhachHang")
    private KhachHang_Entity khachHang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNhanVien", referencedColumnName = "IdNhanVien")
    private NhanVien_Entity nhanVien;

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

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
    private Integer id;
    @Column(name = "Email")
    private String email;
    @Column(name = "PassWord")
    private String passWord;

    @ManyToOne
    @JoinColumn(name = "IdChucVu",referencedColumnName = "IdChucVu")
    private ChucVu_Entitty idChucVu;


    @Column(name = "GhiChu")
    private String ghiChu;


    @ManyToOne
    @JoinColumn(name = "NguoiTao",referencedColumnName = "IdUsers")
    private User_Entity nguoiTao;

    @ManyToOne
    @JoinColumn(name = "NguoiSua",referencedColumnName = "IdUsers")
    private User_Entity nguoiSua;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;


    @Column(name = "TrangThai")
    private Integer trangThai;


}

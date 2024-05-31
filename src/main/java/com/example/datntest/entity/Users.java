package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "Users")
public class Users {

    @Id
    @Column(name = "IdUsers")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsers;

    @Column(name = "Email")
    private String email;

    @Column(name = "PassWord")
    private String passWord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChucVu", insertable = false, updatable = false, referencedColumnName = "IdChucVu")
    private ChucVu idChucVu;

    @Column(name = "GhiChu")
    private String ghiChu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiTao", insertable = false, updatable = false, referencedColumnName = "IdUsers")
    private Users nguoiTao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiSua", insertable = false, updatable = false, referencedColumnName = "IdUsers")
    private Users nguoiSua;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NgayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

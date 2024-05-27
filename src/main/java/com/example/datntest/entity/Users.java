package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserKH")
public class Users {

    @Id
    @ManyToOne
    @JoinColumn(name = "IdKhachHang", insertable = false, updatable = false, referencedColumnName = "IdKhachHang")
    private KhachHang khachHang;
    @Column(name = "TaiKhoan")
    private String taiKhoan;
    @Column(name = "MatKhau")
    private String matKhau;
    @Column(name = "SDT")
    private String sdt;

}

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
@Table(name = "NSX")
public class NSX {
    @Id
    @Column(name = "IdNSX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNSX;

    @Column(name = "MaNSX")
    private String maNSX;

    @Column(name = "TenNSX")
    private Date tenNSX;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

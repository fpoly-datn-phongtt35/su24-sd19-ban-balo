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
@Table(name = "NSX")
public class NSX {
    @Id
    @Column(name = "IdNSX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNSX;

    @Column(name = "MaNSX")
    private String maNSX;

    @Column(name = "TenNSX")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tenNSX;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

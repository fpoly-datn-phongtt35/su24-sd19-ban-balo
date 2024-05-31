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
@Table(name = "Anh")
public class Anh {
    @Id
    @Column(name = "IdAnh")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAnh;

    @Column(name = "Url")
    private String url;


    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

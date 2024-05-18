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
@Table(name = "Size")
public class Size {
    @Id
    @Column(name = "IdSize")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSize;

    @Column(name = "MaSize")
    private String maSize;

    @Column(name = "TenSize")
    private String tenSize;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

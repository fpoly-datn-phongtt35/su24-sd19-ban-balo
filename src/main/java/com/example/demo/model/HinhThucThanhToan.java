package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
public class HinhThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdHinhThucThanhToan", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "HinhThuc", length = 100)
    private String hinhThuc;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
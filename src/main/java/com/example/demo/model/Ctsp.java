package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "CTSP")
public class Ctsp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCTSP", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAnh")
    private Anh idAnh;

    @Nationalized
    @Lob
    @Column(name = "Mota")
    private String mota;

    @Column(name = "GiaBan", precision = 11, scale = 2)
    private BigDecimal giaBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiTao")
    private User nguoiTao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiSua")
    private User nguoiSua;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgaySua")
    private LocalDate ngaySua;

    @Nationalized
    @Column(name = "GhiChu", length = 50)
    private String ghiChu;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
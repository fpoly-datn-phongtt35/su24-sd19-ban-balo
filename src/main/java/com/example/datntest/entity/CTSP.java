package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "CTSP")
public class CTSP {

    @Id
    @Column(name = "IdCTSP")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCTSP;

    @ManyToOne
    @JoinColumn(name = "IdChatLieu", referencedColumnName = "IdChatLieu")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "IdSanPham", referencedColumnName = "IdSanPham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdMauSac", referencedColumnName = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSanPham", referencedColumnName = "IdDongSanPham")
    private DongSanPham dongSanPham;

    @ManyToOne
    @JoinColumn(name = "IdHang", referencedColumnName = "IdHang")
    private Hang hang;

    @ManyToOne
    @JoinColumn(name = "IdNSX", referencedColumnName = "IdNSX")
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name = "IdSize", referencedColumnName = "IdSize")
    private Size size;

//  Thiếu đợt giảm giá


    @Column(name = "Anh")
    private String anh;

    @Column(name = "Mota")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Double giaNhap;

    @Column(name = "GiaBan")
    private Double giaBan;

    @Column(name = "NguoiTao")
    private String nguoiTao;

    @Column(name = "NguoiSua")
    private String nguoiSua;

    @Column(name = "NgayTao")
    private String NgayTao;

    @Column(name = "NgaySua")
    private String ngaySua;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "SoLuongTra")
    private Integer soLuongTra;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

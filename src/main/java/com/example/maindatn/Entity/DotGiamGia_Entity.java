package com.example.maindatn.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "DotGiamGia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DotGiamGia_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDotGiamGia")
    private Integer id;

    @Column(name = "MaDotGiamGia")
    private String ma;

    @Column(name = "TenDotGiamGia")
    private String ten;

    @Column(name = "GiaTriDotGiamGia")
    private Double giaTriDotGiamGia;



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NgayBatDau")
    private Date beginday;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NgayKetThuc")
    private Date endday;

    @Column(name = "GiamToiDa")
    private Double giamToiDa;

    @Column(name = "DieuKien")
    private Double dieuKien;



    @ManyToOne
    @JoinColumn(name = "NguoiTao",referencedColumnName = "IdUsers")
    private User_Entity nguoiTao;

    @ManyToOne
    @JoinColumn(name = "NguoiSua",referencedColumnName = "IdUsers")
    private User_Entity nguoiSua;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NgayTao")
    private Date ngayTao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangthai;
}

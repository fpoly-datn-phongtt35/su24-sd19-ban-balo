package com.example.maindatn.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Table(name = "PhieuGiamGia")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PhieuGiamGia_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPhieuGiamGia")
    private Integer id;

    @Column(name = "MaPhieuGiamGia")
    private String ma;

    @Column(name = "TenPhieuGiamGia")
    private String ten;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NgayBatDau")
    private Date beginday;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NgayKetThuc")
    private Date endday;

    @Column(name = "GiamToiDa")
    private Double giamToiDa;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "NguoiTao",referencedColumnName = "IdUsers")
    private User_Entity nguoiTao;

    @JsonIgnore
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

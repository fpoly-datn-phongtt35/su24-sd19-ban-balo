package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    //    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ma")
    private String ma;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    //    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "SdtNguoiNhan")
            private String sdtNguoiNhan;

    //    @NotBlank(message = "Không để trống thông tin"
    @Column(name = "EmailNguoiNhan")
    private String emailNguoiNhan;

    //    @NotBlank(message = "Không để trống thông tin"
    @Column(name = "TongTien")
    private BigDecimal tongTien;

    //    @DecimalMin(value = "0", message = "Phí ship phải là số và lớn hơn hoặc bằng 0")
//    @DecimalMax(value = "300000", message = "Phí ship tối đa là 300.000")
    @Column(name = "PhiShip")
    private BigDecimal phiShip;

    @Column(name = "LoaiHoaDon")
    private int loaiHoaDon;

    @Column(name = "GhiChu")
    private String ghiChu;

    @CreationTimestamp
    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date ngayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date ngaySua;

    @Column(name = "NguoiTao")
    private String nguoiTao;

    @Column(name = "NguoiSua")
    private String nguoiSua;

    @Column(name = "NgayNhan")
    private java.sql.Date ngayNhan;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "TrangThaiHoaDon")
    private int trangThaiHoaDon;

    @Column(name = "TrangThaiGiaoHang")
    private int trangThaiGiaoHang;

    @Column(name = "hinhThucThanhToan")
    private int hinhThucThanhToan;

    @Column(name = "MaGiaoDich")
    private String maGiaoDich;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDiaChi")
    private DiaChi diaChi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNhanVien")
    private NhanVien nhanVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPGG")
    private PhieuGiamGia phieuGiamGia;


    public String convertTongtien() {
        // Input number
        long number = Long.valueOf(String.valueOf(tongTien));

        // Create a DecimalFormat instance with the desired pattern
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

        // Format the number
        return decimalFormat.format(number);
    }

    public String convertTongtien2() {
        // Input number
        long number = Long.valueOf(String.valueOf(tongTien));

        // Create a DecimalFormat instance with the desired pattern
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

        // Format the number
        return  decimalFormat.format(number).replaceAll("[,]", ".");
    }

    public String convertPhiShip() {
        // Input number
        if (phiShip==null){
            return "0";
        }else {
            long number = Long.valueOf(String.valueOf(phiShip));

            // Create a DecimalFormat instance with the desired pattern
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

            // Format the number
            return decimalFormat.format(number);        }

    }


}

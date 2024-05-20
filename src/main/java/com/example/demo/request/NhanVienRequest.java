package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class NhanVienRequest {
    private Long id;
    private String maNhanVien;
    private String TenNhanVien;
    private String HoNhanVien;
    private String email;
    private String avatar;
    private String cccd;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String sdt;
    private boolean trangThai=true;
    private Long idCV;
    String soNha;
    String phuongXa;
    String quanHuyen;
    String tinhThanhPho;

}

package com.example.maindatn.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormDgg {
    private Integer id;

    private String ma;
    private String ten;

    private Double giaTriDotGiamGia;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginday;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endday;

    private Double giamToiDa;
    private Double dieuKien;

    private Integer nguoiTao;
    private Integer nguoiSua;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    private Integer trangthai;
}

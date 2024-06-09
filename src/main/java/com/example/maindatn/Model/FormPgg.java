package com.example.maindatn.Model;

import com.example.maindatn.Entity.User_Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormPgg {   private Integer id;

    private String ma;
    private String ten;
    private String loai;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginday;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endday;

    private Double mucDo;
    private Double giamToiDa;
    private Double dieuKien;
    private Integer soLuong;

    private Integer nguoiTao;
    private Integer nguoiSua;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    private Integer trangthai;


}

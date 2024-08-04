package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.util.UUID;
@Entity
@Table(name = "MauSac")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
//    @NotBlank(message = "* không để trống")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "* không để trống")
    @Length(max = 100, message = "* Không quá 100 kí tự")
    private String ten;

    @Column(name = "TrangThai")
    private Integer trangThai;
    @CreationTimestamp
    private Date ngayTao;
    private Date ngaySua;

}

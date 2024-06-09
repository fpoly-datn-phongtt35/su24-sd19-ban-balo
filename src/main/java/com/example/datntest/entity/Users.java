package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "Users")
public class Users {

    @Id
    @Column(name = "IdUsers")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsers;

    @Column(name = "Email")
    private String email;

    @Column(name = "PassWord")
    private String passWord;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NgayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

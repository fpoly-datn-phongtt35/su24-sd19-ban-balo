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
@Table(name = "ChatLieu")
public class ChatLieu {
    @Id
    @Column(name = "IdChatLieu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChatLieu;

    @Column(name = "MaChatLieu")
    private String maChatLieu;

    @Column(name = "TenChatLieu")
    private String tenChatLieu;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

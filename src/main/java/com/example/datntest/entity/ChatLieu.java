package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer idchatLieu;

    @Column(name = "MaChatLieu")
    private String machatLieu;

    @Column(name = "TenChatLieu")
    private String tenchatLieu;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

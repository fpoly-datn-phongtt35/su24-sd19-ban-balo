package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class ChatLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdChatLieu", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "MaChatLieu", length = 20)
    private String maChatLieu;

    @Nationalized
    @Column(name = "TenChatLieu", length = 20)
    private String tenChatLieu;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgaySua")
    private LocalDate ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
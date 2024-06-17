package com.example.datntest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Phuong")
public class Phuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPhuong", nullable = false)
    private Integer idPhuong;

    @Column(name = "Ten")
    private String Ten;

    @ManyToOne
    @JoinColumn(name = "Quan_IdQuan")
    private Quan quan;

}

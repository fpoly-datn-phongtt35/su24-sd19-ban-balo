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
@Table(name = "Tinh")
public class Tinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTinh", nullable = false)
    private Integer idTinh;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "tinh")
    private List<Quan> quanList;
}

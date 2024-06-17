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
@Table(name = "Quan")
public class Quan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdQuan", nullable = false)
    private Integer idQuan;

    @Column(name = "Ten")
    private String Ten;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Tinh_IdTinh", referencedColumnName = "IdTinh")
    private Tinh tinh;

    @OneToMany(mappedBy = "quan")
    private List<Phuong> phuongList;
}

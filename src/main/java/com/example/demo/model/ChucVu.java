package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdChucVu", nullable = false)
    private Long id;

    @Size(max = 20)
    @Nationalized
    @Column(name = "MaChucVu", length = 20)
    private String maChucVu;

    @Size(max = 20)
    @Nationalized
    @Column(name = "TenChucVu", length = 20)
    private String tenChucVu;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgaySua")
    private LocalDate ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
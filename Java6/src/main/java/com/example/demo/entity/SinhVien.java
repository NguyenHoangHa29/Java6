package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sinh_vien")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Lop lop;

}

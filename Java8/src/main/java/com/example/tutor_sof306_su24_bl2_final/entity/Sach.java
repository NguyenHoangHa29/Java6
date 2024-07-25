package com.example.tutor_sof306_su24_bl2_final.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Sach")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "NgayXuatBan")
    private String ngayXuatBan;

    @Column(name = "SoTrang")
    private Integer soTrang;

    @Column(name = "DonGia")
    private Float donGia;

    @ManyToOne
    @JoinColumn(name = "IdNXB",referencedColumnName = "Id")
    private NhaXuatBan nhaXuatBan;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

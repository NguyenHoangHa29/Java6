package com.example.tutor_sof306_su24_bl2_final.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NXB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhaXuatBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

     @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

}

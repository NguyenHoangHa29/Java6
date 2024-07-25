package com.example.demo.request;

import com.example.demo.entity.Lop;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SinhVienRequest {

    private Long id;

    private String hoTen;

    private String diaChi;

    private String gioiTinh;

    private Lop lop;

}

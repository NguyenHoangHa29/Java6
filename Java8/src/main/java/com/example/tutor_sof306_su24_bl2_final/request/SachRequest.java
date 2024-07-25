package com.example.tutor_sof306_su24_bl2_final.request;

import com.example.tutor_sof306_su24_bl2_final.entity.NhaXuatBan;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SachRequest {

    private Long id;

    @NotBlank(message = "Ma không được trống")
    private String ma;

    @NotBlank(message = "Tên không được trống")
    private String ten;

    @NotBlank(message = "Ngày xuất bản không được trống")
    private String ngayXuatBan;

    @NotNull(message = "Số trang không được trống")
    private Integer soTrang;

    @NotNull(message = "Dơn giá không được trống")
    private Float donGia;

    @NotNull(message = "Nhà xuất bản không được trống")
    private NhaXuatBan nhaXuatBan;

}

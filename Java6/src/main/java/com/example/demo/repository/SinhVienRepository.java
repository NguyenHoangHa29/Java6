package com.example.demo.repository;

import com.example.demo.entity.SinhVien;
import com.example.demo.reponse.SinhVien2Response;
import com.example.demo.reponse.SinhVienResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {

    @Query(value = """
       SELECT sv.ho_ten as ten,
              sv.dia_chi AS diaChi,
              l.ma_lop AS maLop
       FROM sinh_vien sv
       JOIN lop l ON l.id = sv.lop_id
    """,countQuery = """
        SELECT COUNT(*)
        FROM sinh_vien sv
        JOIN lop l ON l.id = sv.lop_id
    """
            ,nativeQuery = true)
    Page<SinhVien2Response> phanTrang(Pageable pageable);

    @Query("""
        SELECT new com.example.demo.reponse.SinhVienResponse(sv.hoTen,sv.diaChi,sv.lop.maLop)
        FROM SinhVien sv
    """)
    List<SinhVienResponse> findAll1();

}

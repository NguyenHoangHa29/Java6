package com.example.tutor_sof306_su24_bl2_final.repository;

import com.example.tutor_sof306_su24_bl2_final.entity.Sach;
import com.example.tutor_sof306_su24_bl2_final.response.SachResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SachRepository extends JpaRepository<Sach,Long> {

    @Query("""
    SELECT new com.example.tutor_sof306_su24_bl2_final.response.SachResponse
    (s.ma,s.ten,s.ngayXuatBan,s.soTrang,s.donGia,s.nhaXuatBan.ten)
    FROM Sach s
    """)
    List<SachResponse> getAll();

    @Query("""
    SELECT new com.example.tutor_sof306_su24_bl2_final.response.SachResponse
    (s.ma,s.ten,s.ngayXuatBan,s.soTrang,s.donGia,s.nhaXuatBan.ten)
    FROM Sach s
    """)
    Page<SachResponse> phanTrang(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = """
    DELETE FROM sach where ma = :ma
    """,nativeQuery = true)
    void delete(String ma);

}

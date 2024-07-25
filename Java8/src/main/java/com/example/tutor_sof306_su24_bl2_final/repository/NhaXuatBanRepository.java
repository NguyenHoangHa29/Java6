package com.example.tutor_sof306_su24_bl2_final.repository;

import com.example.tutor_sof306_su24_bl2_final.entity.NhaXuatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBan,Long> {
}

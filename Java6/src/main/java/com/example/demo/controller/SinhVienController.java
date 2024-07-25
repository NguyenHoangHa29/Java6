package com.example.demo.controller;

import com.example.demo.entity.SinhVien;
import com.example.demo.reponse.SinhVien2Response;
import com.example.demo.reponse.SinhVienResponse;
import com.example.demo.repository.SinhVienRepository;
import com.example.demo.request.SinhVienRequest;
import org.hibernate.type.descriptor.java.LongJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class SinhVienController {

    @Autowired
    private SinhVienRepository repository;

    @GetMapping("/hien-thi")
    public List<SinhVienResponse> hienThi(){
        return repository.findAll1();
    }

    @GetMapping("/phan-trang")
    public List<SinhVien2Response> phanTrang(@RequestParam(value = "currentPage",
                                    defaultValue = "0") Integer currentPage){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(currentPage,pageSize);
        return repository.phanTrang(pageable).getContent();
    }

    @PostMapping("/add")
    public String add(@RequestBody SinhVienRequest sinhVien){

        SinhVien sv = new SinhVien();
        sv.setHoTen(sinhVien.getHoTen());
        sv.setGioiTinh(sinhVien.getGioiTinh());
        sv.setDiaChi(sinhVien.getDiaChi());
        sv.setLop(sinhVien.getLop());

        SinhVien sv1 = repository.save(sv);
        if(sv1 != null){
            return "thêm sinh viên thành công";
        }
        return "thêm sinh viên thất bại";
    }

    @PutMapping("/update")
    public String update(@RequestBody SinhVien sinhVien){
        SinhVien sv = repository.save(sinhVien);
        if(sv != null){
            return "sửa sinh viên thành công";
        }
        return "sửa sinh viên thất bại";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        try {
            repository.deleteById(id);
            return "xoa thanh cong";
        }catch (Exception e){
            return "Xoa that bai";
        }

    }

    @GetMapping("/detail")
    public SinhVien detail(@RequestParam(value = "id", defaultValue = "2") Long id){
        return repository.findById(id).get();
    }

    @GetMapping("/sap-xep")
    public List<SinhVien> sapXep(){
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(SinhVien::getId).reversed())
                .toList();
    }

    @GetMapping("/loc")
    public List<SinhVien> search(@RequestParam(value = "ten",defaultValue = "") String ten){
        return repository.findAll()
                .stream()
                .filter(sinhVien -> sinhVien.getHoTen().contains(ten))
                .toList();
    }

}

package com.example.tutor_sof306_su24_bl2_final.controller;

import com.example.tutor_sof306_su24_bl2_final.entity.Sach;
import com.example.tutor_sof306_su24_bl2_final.repository.NhaXuatBanRepository;
import com.example.tutor_sof306_su24_bl2_final.repository.SachRepository;
import com.example.tutor_sof306_su24_bl2_final.request.SachRequest;
import com.example.tutor_sof306_su24_bl2_final.response.SachResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
public class SachController {

    @Autowired
    private SachRepository sachRepository;

    @Autowired
    private NhaXuatBanRepository nhaXuatBanRepository;

    @GetMapping("/hien-thi")
    public List<SachResponse> getAll(){
        return sachRepository.getAll();
    }

    @GetMapping("/phan-trang")
    public List<SachResponse> phanTrang(@RequestParam(value = "currentPage",defaultValue = "0") Integer currentPage){
        int size = 5;
        Pageable pageable = PageRequest.of(currentPage,size);
        return sachRepository.phanTrang(pageable).getContent();
    }

    @PostMapping("/add")
    public String add (@RequestBody @Valid SachRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "Thêm thất bại";
        }
        Sach sach = new Sach();
        sach.setMa(request.getMa());
        sach.setTen(request.getTen());
        sach.setDonGia(request.getDonGia());
        sach.setNgayXuatBan(request.getNgayXuatBan());
        sach.setSoTrang(request.getSoTrang());
        sach.setNhaXuatBan(request.getNhaXuatBan());
        Sach s = sachRepository.save(sach);
        if(s == null){
            return "Thêm sách thất bại";
        }
        return "Thêm thành công";
    }

    @PutMapping("/update")
    public String update(@RequestBody SachRequest request){
        Sach sach = new Sach();
        sach.setId(request.getId());
        sach.setMa(request.getMa());
        sach.setTen(request.getTen());
        sach.setDonGia(request.getDonGia());
        sach.setNgayXuatBan(request.getNgayXuatBan());
        sach.setSoTrang(request.getSoTrang());
        sach.setNhaXuatBan(request.getNhaXuatBan());
        Sach s = sachRepository.save(sach);
        if(s == null){
            return "Sửa sách thất bại";
        }
        return "Sửa thành công";
    }

    @DeleteMapping("/delete/{ma}")
    public String delete(@PathVariable("ma") String maSach){
        try {
            sachRepository.delete(maSach);
            return "Xóa thành công";
        }catch (Exception e){
            e.printStackTrace();
            return "Xóa thất bại";
        }
    }

    @GetMapping("/detail")
    public Sach detail(@RequestParam(value = "id",defaultValue = "0") Long id){
        Optional<Sach> sach = sachRepository.findById(id);
        if(sach.isPresent()){
            return sachRepository.findById(id).get();
        }
        return null;
    }

    @GetMapping("/filter")
    public List<SachResponse> filter(){
        return sachRepository.getAll().stream()
                .filter(item -> item.getTenNhaXuatBan().equalsIgnoreCase("Nguyễn Văn Anh"))
                .toList();
    }

    @GetMapping("/sort")
    public List<SachResponse> sort(){
        return sachRepository.getAll().stream()
                .sorted(Comparator.comparing(SachResponse::getDonGia).reversed())
                .toList();
    }

    @GetMapping("/filter2")
    public List<SachResponse> filter2(){
        return sachRepository.getAll().stream()
                .filter(item->item.getTen().contains("a"))
                .filter(sach -> sach.getSoTrang()>=50 && sach.getSoTrang()<=100)
                .toList();
    }

}

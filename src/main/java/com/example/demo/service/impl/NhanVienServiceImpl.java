package com.example.demo.service.impl;

import com.example.demo.model.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository;


    @Override
    public Page<NhanVien> phanTrang(Integer pageNum, Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNum , pageNo);
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        nhanVienRepository.deleteById(id);

    }

    @Override
    public NhanVien detail(Long id) {
        NhanVien nhanVien = nhanVienRepository.findById(id).get();
        return nhanVien;
    }

    @Override
    public NhanVien add(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien update(NhanVien nhanVien, Long id) {
        Optional<NhanVien> optional = nhanVienRepository.findById(id);
        return optional.map(o ->
        {
            nhanVienRepository.save(nhanVien);
            return o;
        }).orElse(null);
    }
//
//    @Override
//    public NhanVien getByMa(String ma) {
//        return null;
//    }
//
//    @Override
//    public boolean existByMa(String ma) {
//        return false;
//    }
}

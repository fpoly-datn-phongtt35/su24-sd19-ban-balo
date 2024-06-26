package com.example.demo.sevice.impl;


import com.example.demo.model.NhanVien;
import com.example.demo.repsitory.NhanVienRepository;
import com.example.demo.sevice.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {
    private final NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien getOne(int id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    @Override
    public void add(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien, int id) {
        nhanVien.setId(id);
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void delete(int id) {
        nhanVienRepository.deleteById(id);

    }

    @Override
    public Page<NhanVien> getData(int page) {
        Pageable pageable = PageRequest.of(page,5);
        return nhanVienRepository.findAll(pageable);
    }
}

package com.example.demo.sevice.impl;


import com.example.demo.model.NhanVien;
import com.example.demo.repsitory.NhanVienRepository;
import com.example.demo.sevice.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public NhanVien getOne(Long id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    @Override
    public NhanVien add(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien update(NhanVien nhanVien, Long id) {
        nhanVien.setId(id);
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public void delete(Long id) {
        nhanVienRepository.deleteById(id);

    }

    @Override
    public Page<NhanVien> getData(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public Page<NhanVien> searchByKey(String key, Pageable pageable) {
        return nhanVienRepository.searchByKey(key, pageable);
    }

    @Override
    public String generateCustomerCode() {
        long count = nhanVienRepository.count();
        int numberOfDigits = (int) Math.log10(count + 1) + 1;
        int numberOfZeros = Math.max(0, 5 - numberOfDigits);
        String employeeCode;
        do {
            employeeCode = String.format("NV%0" + (numberOfDigits + numberOfZeros) + "d", count + 1);
            count++;
        } while (nhanVienRepository.existsByMaNhanVien(employeeCode));

        return employeeCode;
    }
}

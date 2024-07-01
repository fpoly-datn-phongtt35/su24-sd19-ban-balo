package com.example.demo.sevice.impl;

import com.example.demo.model.KhachHang;
import com.example.demo.repsitory.KhachHangRepository;
import com.example.demo.sevice.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KhachHangServiceImpl implements KhachHangService {
    private final KhachHangRepository khachHangRepository;


    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang getOne(Long id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public KhachHang add(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang update(KhachHang khachHang, Long id) {
        khachHang.setId(id);
        return khachHangRepository.save(khachHang);
    }

    @Override
    public void delete(Long id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHang getByMa(String ma) {
        return khachHangRepository.findByMaKhachHang(ma)
                .orElseThrow(() -> new UsernameNotFoundException("username does not exist"));
    }

    @Override
    public boolean existByMa(String ma) {
        return khachHangRepository.existsByMaKhachHang(ma);
    }

    @Override
    public boolean existsBySdt(String sdt) {
        return khachHangRepository.existsBySdt(sdt);
    }

    @Override
    public String generateCustomerCode() {
        long count = khachHangRepository.count();
        int numberOfDigits = (int) Math.log10(count + 1) + 1;
        int numberOfZeros = Math.max(0, 5 - numberOfDigits);
        String customerCode;
        do {
            customerCode = String.format("KH%0" + (numberOfDigits + numberOfZeros) + "d", count + 1);
            count++;
        } while (khachHangRepository.existsByMaKhachHang(customerCode));

        return customerCode;
    }
}

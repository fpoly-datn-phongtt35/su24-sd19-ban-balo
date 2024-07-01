package com.example.demo.sevice;

import com.example.demo.model.KhachHang;

import java.util.List;

public interface KhachHangService {
    List<KhachHang> findAll();
    KhachHang getOne(Long id);
    KhachHang add(KhachHang khachHang);
    KhachHang update(KhachHang khachHang, Long id);
    void delete(Long id);

    KhachHang getByMa(String ma);

    boolean existByMa(String ma);

    boolean existsBySdt(String sdt);

    String generateCustomerCode();
}

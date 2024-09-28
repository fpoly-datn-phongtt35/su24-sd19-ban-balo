package com.example.demo.services.impl;

import com.example.demo.models.KhachHang;
import com.example.demo.repositories.KhachHangRepository;
import com.example.demo.services.KhachHangService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public Page<KhachHang> getAll(Pageable pageable) {
        return khachHangRepository.getAll(pageable);
    }

    @Override
    public Page<KhachHang> getAll1(Pageable pageable) {
        return khachHangRepository.getAll1(pageable);
    }

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll0();
    }

    @Override
    public List<KhachHang> findAllFullTT() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang findById(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public KhachHang add(KhachHang trongLuong) {
        return khachHangRepository.save(trongLuong);
    }

    @Override
    public KhachHang update(UUID id,KhachHang trongLuong) {
        if (id != null) {
            KhachHang trongLuongUpdate = khachHangRepository.findById(id).orElse(null);
            if (trongLuongUpdate != null) {
                BeanUtils.copyProperties(trongLuong, trongLuongUpdate);
                khachHangRepository.save(trongLuongUpdate);
            }
        }
        return null;
    }

    @Override
    public void updateTT() {

    }

    @Override
    public List<KhachHang> search0(String ten) {
        return khachHangRepository.search0(ten);
    }

    @Override
    public List<KhachHang> search1(String ten) {
        return khachHangRepository.search1(ten);
    }

    @Override
    public boolean existKhachHangByEmail(String email) {
        return khachHangRepository.existsKhachHangByEmail(email);
    }

    @Override
    public boolean existKhachHangBySDT(String sdt) {
        return khachHangRepository.existsKhachHangBySoDienThoai(sdt);
    }

    @Override
    public List<KhachHang> locTT(int trangThai) {
        return khachHangRepository.findAllByTrangThai(trangThai);
    }

    @Override
    public Page<KhachHang> locGT(Boolean gioiTinh,Pageable pageable) {
        return khachHangRepository.findAllByGioiTinh(gioiTinh,pageable);
    }

    @Override
    public Page<KhachHang> findAllByTinhTrangAndGioiTinh(int trangThai, Boolean gioiTinh,Pageable pageable) {
        return khachHangRepository.findAllByTrangThaiAndGioiTinh(trangThai,gioiTinh,pageable);
    }

    @Override
    public KhachHang quenMatKhau(String username, String email) {
        return khachHangRepository.quenMatKhau(username, email);
    }
}

package com.example.datntest.service.impl;

import com.example.datntest.entity.KhachHang;
import com.example.datntest.repository.KhachHangRepository;
import com.example.datntest.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KhachHangImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Override
    public Page<KhachHang> getAll(int pages) {
        Pageable pageable = PageRequest.of(pages,4);
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang detail(Integer idKhachHang) {
        return khachHangRepository.findById(idKhachHang).orElse(null);
    }


    public KhachHang delete(Integer idKhachHang) {
        khachHangRepository.deleteById(idKhachHang);
        return null;
    }

    @Override
    public Page<KhachHang> searchByTenKhachHang(String tenKhachHang, Pageable pageable) {
        return khachHangRepository.searchByTenKhachHang("%" + tenKhachHang + "%", pageable);
    }
}

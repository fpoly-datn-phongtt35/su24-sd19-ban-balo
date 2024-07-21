package com.example.datntest.service.impl;

import com.example.datntest.entity.DiaChi;
import com.example.datntest.repository.DiaChiReposiroty;
import com.example.datntest.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiaChiImpl implements DiaChiService {
    @Autowired
    private DiaChiReposiroty diaChiRepository;

    @Override
    public List<DiaChi> danhSachDiaChi(Integer idKhachHang) {
        return diaChiRepository.danhSachDiaChi(idKhachHang);
    }
}

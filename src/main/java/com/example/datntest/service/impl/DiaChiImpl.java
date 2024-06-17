package com.example.datntest.service.impl;

import com.example.datntest.entity.Phuong;
import com.example.datntest.entity.Quan;
import com.example.datntest.entity.Tinh;
import com.example.datntest.repository.PhuongRepository;
import com.example.datntest.repository.QuanRepository;
import com.example.datntest.repository.TinhRepository;
import com.example.datntest.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaChiImpl implements DiaChiService {

    @Autowired
    private TinhRepository tinhRepository;

    @Autowired
    private QuanRepository quanRepository;

    @Autowired
    private PhuongRepository phuongRepository;
    @Override
    public List<Tinh> getAllTinh() {
        return tinhRepository.findAll();
    }

    @Override
    public List<Quan> getQuanByTinhIdTinh(Integer tinhIdTinh) {
        return quanRepository.findByTinhIdTinh(tinhIdTinh);
    }

    @Override
    public List<Phuong> getPhuongByQuanIdQuan(Integer quanIdQuan) {
        return phuongRepository.findByQuanIdQuan(quanIdQuan);
    }
}

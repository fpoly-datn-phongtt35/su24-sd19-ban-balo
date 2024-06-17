package com.example.datntest.service;

import com.example.datntest.entity.Phuong;
import com.example.datntest.entity.Quan;
import com.example.datntest.entity.Tinh;

import java.util.List;

public interface DiaChiService {
    List<Tinh> getAllTinh();

    List<Quan> getQuanByTinhIdTinh(Integer tinhIdTinh);

    List<Phuong> getPhuongByQuanIdQuan(Integer quanIdQuan);
}

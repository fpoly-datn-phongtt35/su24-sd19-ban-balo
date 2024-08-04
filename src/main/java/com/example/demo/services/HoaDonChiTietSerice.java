package com.example.demo.services;

import com.example.demo.models.HoaDonChiTiet;

import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietSerice {

    List<HoaDonChiTiet> hoaDonChiTietAll(UUID id);

    HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet update(UUID id, HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet findHoaDonChiTiet(UUID id);

    public Boolean delete(UUID id);

    //    List<HoaDonChiTiet> hoaDonChiTietBanHang(UUID id);
    List<HoaDonChiTiet> searchBanTaiQuay(UUID id, String ten);

    HoaDonChiTiet findById(UUID id);

    HoaDonChiTiet hdct(UUID idHDCT, UUID idCTSP);
}

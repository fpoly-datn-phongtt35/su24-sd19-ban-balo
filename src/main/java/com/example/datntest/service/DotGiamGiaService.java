package com.example.datntest.service;

import com.example.datntest.entity.Anh;
import com.example.datntest.entity.DotGiamGia;
import org.springframework.data.domain.Page;


public interface DotGiamGiaService {
    Page<DotGiamGia> getAll(int page);
    void add(DotGiamGia dotGiamGia);
    DotGiamGia detail(Integer idDotGiamGia);
    DotGiamGia delete(Integer idDotGiamGia);
}

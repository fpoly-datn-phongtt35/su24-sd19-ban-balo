package com.example.datntest.service.impl;

import com.example.datntest.entity.CTSP;
import com.example.datntest.repository.CTSPRepository;
import com.example.datntest.service.CTSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CTSPImpl implements CTSPService {
    @Autowired
    private CTSPRepository ctspRepository;


    @Override
    public void add(CTSP ctsp) {
        ctspRepository.save(ctsp);
    }

    @Override
    public CTSP detail(Integer idCTSP) {
        return ctspRepository.findById(idCTSP).orElse(null);

    }

    @Override
    public CTSP delete(Integer idCTSP) {
        ctspRepository.deleteById(idCTSP);
        return null;
    }

    @Override
    public Page<CTSP> searchByTenSanPham(String tenSanPham, Pageable pageable) {
        return ctspRepository.searchByTenSanPham("%" + tenSanPham + "%", pageable);
    }
    @Autowired
    public CTSPImpl(CTSPRepository ctspRepository) {
        this.ctspRepository = ctspRepository;
    }

    //giá
    @Override
    public Page<CTSP> searchByPriceRange(BigDecimal minGiaBan, BigDecimal maxGiaBan, Pageable pageable) {
        return ctspRepository.findByGiaBanBetween(minGiaBan, maxGiaBan, pageable);
    }
    //tất
    @Override
    public Page<CTSP> searchByTenSanPhamAndPriceRange(String tenSanPham, BigDecimal minGiaBan, BigDecimal maxGiaBan, Pageable pageable) {
        return ctspRepository.findByTenSanPhamContainingAndGiaBanBetween(tenSanPham, minGiaBan, maxGiaBan, pageable);
    }

    //detail
}

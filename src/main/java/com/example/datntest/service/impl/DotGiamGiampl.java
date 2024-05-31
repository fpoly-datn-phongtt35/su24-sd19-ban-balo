package com.example.datntest.service.impl;

import com.example.datntest.entity.Anh;
import com.example.datntest.entity.DotGiamGia;
import com.example.datntest.repository.AnhRepository;
import com.example.datntest.repository.DotGiamGiaRepository;
import com.example.datntest.service.AnhService;
import com.example.datntest.service.DotGiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DotGiamGiampl implements DotGiamGiaService {
    @Autowired
    private DotGiamGiaRepository dotGiamGiaRepository;
    @Override
    public Page<DotGiamGia> getAll(int page) {
        Pageable pageable = PageRequest.of(page,3);
        return dotGiamGiaRepository.findAll(pageable);
    }

    @Override
    public void add(DotGiamGia anh) {
        dotGiamGiaRepository.save(anh);
    }

    @Override
    public DotGiamGia detail(Integer idDotGiamGia) {
        return dotGiamGiaRepository.findById(idDotGiamGia).orElse(null);

    }

    @Override
    public DotGiamGia delete(Integer idDotGiamGia) {
        dotGiamGiaRepository.deleteById(idDotGiamGia);
        return null;
    }

}

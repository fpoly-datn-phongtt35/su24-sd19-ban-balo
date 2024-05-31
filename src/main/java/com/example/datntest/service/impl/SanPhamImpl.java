package com.example.datntest.service.impl;

import com.example.datntest.entity.SanPham;
import com.example.datntest.repository.SanPhamRepository;
import com.example.datntest.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SanPhamImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Override
    public Page<SanPham> getAll(int page) {
        Pageable pageable = PageRequest.of(page,3);
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public void add(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham detail(Integer idSanPham) {
        return sanPhamRepository.findById(idSanPham).orElse(null);
    }

    @Override
    public SanPham delete(Integer idSanPham) {
        sanPhamRepository.deleteById(idSanPham);
        return null;
    }

}

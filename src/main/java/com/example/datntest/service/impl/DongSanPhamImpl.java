package com.example.datntest.service.impl;

import com.example.datntest.entity.DongSanPham;
import com.example.datntest.entity.SanPham;
import com.example.datntest.repository.DongSanPhamRepository;
import com.example.datntest.repository.SanPhamRepository;
import com.example.datntest.service.DongSanPhamService;
import com.example.datntest.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DongSanPhamImpl implements DongSanPhamService {
    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;
    @Override
    public Page<DongSanPham> getAll(int page) {
        Pageable pageable = PageRequest.of(page,3);
        return dongSanPhamRepository.findAll(pageable);
    }

    @Override
    public void add(DongSanPham dongSanPham) {
        dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public DongSanPham detail(Integer id) {
        return null;
    }

    @Override
    public DongSanPham delete(Integer id) {
        return null;
    }

}

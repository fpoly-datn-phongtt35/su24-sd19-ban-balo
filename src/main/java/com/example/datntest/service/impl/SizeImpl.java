package com.example.datntest.service.impl;

import com.example.datntest.entity.Size;
import com.example.datntest.repository.SizeRepository;
import com.example.datntest.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SizeImpl implements SizeService {
    @Autowired
    private SizeRepository sizeRepository;
    @Override
    public Page<Size> getAll(int page) {
        Pageable pageable = PageRequest.of(page,3);
        return sizeRepository.findAll(pageable);
    }

    @Override
    public void add(Size mauSac) {
        sizeRepository.save(mauSac);
    }

    @Override
    public Size detail(Integer id) {
        return null;
    }

    @Override
    public Size delete(Integer id) {
        return null;
    }

}

package com.example.datntest.service.impl;

import com.example.datntest.entity.MauSac;
import com.example.datntest.entity.Size;
import com.example.datntest.repository.MauSacRepository;
import com.example.datntest.repository.SizeRepository;
import com.example.datntest.service.MauSacService;
import com.example.datntest.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MauSacImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;
    @Override
    public Page<MauSac> getAll(int page) {
        Pageable pageable = PageRequest.of(page,3);
        return mauSacRepository.findAll(pageable);
    }

    @Override
    public void add(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public MauSac detail(Integer id) {
        return null;
    }

    @Override
    public MauSac delete(Integer id) {
        return null;
    }

}

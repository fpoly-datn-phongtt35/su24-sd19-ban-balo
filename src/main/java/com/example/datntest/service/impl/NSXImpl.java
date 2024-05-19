package com.example.datntest.service.impl;

import com.example.datntest.entity.NSX;
import com.example.datntest.entity.Size;
import com.example.datntest.repository.NSXRepository;
import com.example.datntest.repository.SizeRepository;
import com.example.datntest.service.NSXService;
import com.example.datntest.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NSXImpl implements NSXService {
    @Autowired
    private NSXRepository nsxRepository;
    @Override
    public Page<NSX> getAll(int page) {
        Pageable pageable = PageRequest.of(page,3);
        return nsxRepository.findAll(pageable);
    }

    @Override
    public void add(NSX nsx) {
        nsxRepository.save(nsx);
    }

    @Override
    public NSX detail(Integer id) {
        return null;
    }

    @Override
    public NSX delete(Integer id) {
        return null;
    }

}

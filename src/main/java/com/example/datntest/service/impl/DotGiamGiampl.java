package com.example.datntest.service.impl;

import com.example.datntest.entity.Anh;
import com.example.datntest.entity.NSX;
import com.example.datntest.repository.AnhRepository;
import com.example.datntest.repository.NSXRepository;
import com.example.datntest.service.AnhService;
import com.example.datntest.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class Anhmpl implements AnhService {
    @Autowired
    private AnhRepository anhRepository;
    @Override
    public Page<Anh> getAll(int page) {
        Pageable pageable = PageRequest.of(page,3);
        return anhRepository.findAll(pageable);
    }

    @Override
    public void add(Anh anh) {
        anhRepository.save(anh);
    }

    @Override
    public Anh detail(Integer id) {
        return null;
    }

    @Override
    public Anh delete(Integer id) {
        return null;
    }

}

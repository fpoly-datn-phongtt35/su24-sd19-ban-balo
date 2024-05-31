package com.example.datntest.service.impl;

import com.example.datntest.entity.Hang;
import com.example.datntest.repository.HangRepository;
import com.example.datntest.service.HangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HangImpl implements HangService {
    @Autowired
    private HangRepository hangRepository;
    @Override
    public Page<Hang> getAll(int page) {
        Pageable pageable = PageRequest.of(page,3);
        return hangRepository.findAll(pageable);
    }

    @Override
    public void add(Hang hang) {
        hangRepository.save(hang);
    }

    @Override
    public Hang detail(Integer idHang) {
        return hangRepository.findById(idHang).orElse(null);

    }

    @Override
    public Hang delete(Integer idHang) {
        hangRepository.deleteById(idHang);
        return null;
    }

}

package com.example.datntest.service.impl;

import com.example.datntest.entity.CTSP;
import com.example.datntest.entity.ChatLieu;
import com.example.datntest.repository.CTSPRepository;
import com.example.datntest.repository.ChatLieuRepository;
import com.example.datntest.service.CTSPService;
import com.example.datntest.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CTSPImpl implements CTSPService {
    @Autowired
    private CTSPRepository ctspRepository;
    @Override
    public Page<CTSP> getAll(int page) {
        Pageable pageable = PageRequest.of(page,3);
        return ctspRepository.findAll(pageable);
    }

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

}

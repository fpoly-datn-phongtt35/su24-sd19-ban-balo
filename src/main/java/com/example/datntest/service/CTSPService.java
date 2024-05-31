package com.example.datntest.service;

import com.example.datntest.entity.Anh;
import com.example.datntest.entity.CTSP;
import org.springframework.data.domain.Page;


public interface CTSPService {
    Page<CTSP> getAll(int page);
    void add(CTSP ctsp);
    CTSP detail(Integer id);
    CTSP delete(Integer id);
}

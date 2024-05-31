package com.example.datntest.service;

import com.example.datntest.entity.MauSac;
import org.springframework.data.domain.Page;


public interface MauSacService {
    Page<MauSac> getAll(int page);
    void add(MauSac mauSac);
    MauSac detail(Integer idMauSac);
    MauSac delete(Integer idMauSac);
}

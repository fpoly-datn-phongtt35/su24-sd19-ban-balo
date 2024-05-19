package com.example.datntest.service;

import com.example.datntest.entity.MauSac;
import com.example.datntest.entity.Size;
import org.springframework.data.domain.Page;


public interface MauSacService {
    Page<MauSac> getAll(int page);
    void add(MauSac mauSac);
    MauSac detail(Integer id);
    MauSac delete(Integer id);
}

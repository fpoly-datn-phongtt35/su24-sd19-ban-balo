package com.example.datntest.service;

import com.example.datntest.entity.Hang;
import com.example.datntest.entity.Size;
import org.springframework.data.domain.Page;


public interface HangService {
    Page<Hang> getAll(int page);
    void add(Hang hang);
    Hang detail(Integer id);
    Hang delete(Integer id);
}

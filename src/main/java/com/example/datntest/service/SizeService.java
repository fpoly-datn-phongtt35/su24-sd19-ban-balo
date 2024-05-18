package com.example.datntest.service;

import com.example.datntest.entity.Size;
import org.springframework.data.domain.Page;


public interface SizeService {
    Page<Size> getAll(int page);
    void add(Size size);
    Size detail(Integer id);
    Size delete(Integer id);
}

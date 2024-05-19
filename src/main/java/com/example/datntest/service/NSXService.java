package com.example.datntest.service;

import com.example.datntest.entity.NSX;
import com.example.datntest.entity.Size;
import org.springframework.data.domain.Page;


public interface NSXService {
    Page<NSX> getAll(int page);
    void add(NSX nsx);
    NSX detail(Integer id);
    NSX delete(Integer id);
}

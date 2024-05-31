package com.example.datntest.service;

import com.example.datntest.entity.Anh;
import com.example.datntest.entity.NSX;
import org.springframework.data.domain.Page;


public interface AnhService {
    Page<Anh> getAll(int page);
    void add(Anh anh);
    Anh detail(Integer idAnh);
    Anh delete(Integer idAnh);
}

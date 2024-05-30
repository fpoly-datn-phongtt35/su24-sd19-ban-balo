package com.example.demo.service;

import com.example.demo.model.ChucVu;

import java.util.List;


public interface ChucVuService {

    List<ChucVu> page(int a, int b);

    List<ChucVu> getAll();
    ChucVu add(ChucVu cv);
    ChucVu update(ChucVu cv, Long id);
    void delete(Long id);
    ChucVu detail(Long id);

}

package com.example.demo.sevice;

import com.example.demo.model.ChucVu;


import java.util.List;

public interface ChucVuService {
    List<ChucVu> getAll();
    ChucVu getOne(Long id);
    void add(ChucVu chucVu);
    void delete(Long id);
    void update(ChucVu chucVu, Long id);
    ChucVu getByTenChucVu(String tenChucVu);
    boolean existsByTenBoolean(String tenChucVu);



}

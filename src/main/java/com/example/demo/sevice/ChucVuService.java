package com.example.demo.sevice;

import com.example.demo.model.ChucVu;


import java.util.List;

public interface ChucVuService {
    List<ChucVu> getAll();
    ChucVu getOne(int id);
    void add(ChucVu chucVu);
    void delete(int id);
    void update(ChucVu chucVu, int id);



}

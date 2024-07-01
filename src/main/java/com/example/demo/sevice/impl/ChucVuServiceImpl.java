package com.example.demo.sevice.impl;


import com.example.demo.model.ChucVu;
import com.example.demo.repsitory.ChucVuRepository;
import com.example.demo.sevice.ChucVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ChucVuServiceImpl implements ChucVuService {

     private final ChucVuRepository chucVuRepository;


    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu getOne(Long id) {
        return chucVuRepository.findById(id).orElse(null);
    }

    @Override
    public void add(ChucVu chucVu) {
        chucVuRepository.save(chucVu);

    }

    @Override
    public void delete(Long id) {
        chucVuRepository.deleteById(id);

    }

    @Override
    public void update(ChucVu chucVu, Long id) {
       chucVu.setId(id);
       chucVuRepository.save(chucVu);
    }

    @Override
    public ChucVu getByTenChucVu(String tenChucVu) {
        return chucVuRepository.getFirstByTenChucVu(tenChucVu);
    }

    @Override
    public boolean existsByTenBoolean(String tenChucVu) {
        return chucVuRepository.existsByTenChucVu(tenChucVu);
    }


}
package com.example.demo.service.impl;

import com.example.demo.model.ChucVu;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.service.ChucVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChucVuServiceImpl implements ChucVuService {
    private final ChucVuRepository chucVuRepository;


    @Override
    public List<ChucVu> page(int a, int b){
        return chucVuRepository.findAll(PageRequest.of(a,b)).stream().toList();
    }

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu add(ChucVu cv) {
        return chucVuRepository.save(cv);
    }

    @Override
    public ChucVu update(ChucVu cv, Long id) {
        return chucVuRepository.save(cv);
    }

    @Override
    public void delete(Long id) {
        chucVuRepository.deleteById(id);
    }

    @Override
    public ChucVu detail(Long id) {
        return chucVuRepository.findById(id).get();
    }
}
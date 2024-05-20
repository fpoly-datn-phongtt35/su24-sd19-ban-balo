package com.example.demo.service.impl;

import com.example.demo.model.ChucVu;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.service.ChucVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChucVuServiceImpl implements ChucVuService {
    private final ChucVuRepository chucVuRepository;


    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll(Sort.by(Sort.Direction.DESC, "ngaySua"));
    }

    @Override
    public boolean delete(Long id) {
        ChucVu cv = chucVuRepository.findById(id).get();
        if (cv.getId() != null) {
            chucVuRepository.deleteById(cv.getId());
            return true;
        }
        return false;
    }

    @Override
    public ChucVu getById(Long id) {
        ChucVu chucVu = chucVuRepository.findById(id).get();
        return chucVu;
    }

    @Override
    public ChucVu save(ChucVu chucVu) {
        return chucVuRepository.save(chucVu);
    }
}

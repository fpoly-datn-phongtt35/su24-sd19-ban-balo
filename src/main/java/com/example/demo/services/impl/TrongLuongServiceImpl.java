package com.example.demo.services.impl;

import com.example.demo.models.TrongLuong;
import com.example.demo.repositories.TrongLuongRepository;
import com.example.demo.services.TrongLuongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TrongLuongServiceImpl implements TrongLuongService {

    @Autowired
    private TrongLuongRepository trongLuongRepository;

    @Override
    public Page<TrongLuong> getAll(Pageable pageable) {
        return trongLuongRepository.getAll(pageable);
    }

    @Override
    public Page<TrongLuong> getAll1(Pageable pageable) {
        return trongLuongRepository.getAll1(pageable);
    }

    @Override
    public List<TrongLuong> findAll() {
        return trongLuongRepository.findAll0();
    }

    @Override
    public List<TrongLuong> findAllFullTT() {
        return trongLuongRepository.findAll();
    }

    @Override
    public TrongLuong findById(UUID id) {
        return trongLuongRepository.findById(id).orElse(null);
    }

    @Override
    public TrongLuong add(TrongLuong trongLuong) {
        return trongLuongRepository.save(trongLuong);
    }

    @Override
    public TrongLuong update(UUID id,TrongLuong trongLuong) {
        if (id != null) {
            TrongLuong trongLuongUpdate = trongLuongRepository.findById(id).orElse(null);
            if (trongLuongUpdate != null) {
                BeanUtils.copyProperties(trongLuong, trongLuongUpdate);
                trongLuongRepository.save(trongLuongUpdate);
            }
        }
        return null;
    }

    @Override
    public void updateTT() {

    }

    @Override
    public List<TrongLuong> search0(String ten) {
        return trongLuongRepository.search0(ten);
    }

    @Override
    public List<TrongLuong> search1(String ten) {
        return trongLuongRepository.search1(ten);
    }

    @Override
    public TrongLuong findByMa(String ma) {
        return trongLuongRepository.findTrongLuongByMa(ma);
    }

    @Override
    public TrongLuong findByTen(String ten) {
        return trongLuongRepository.findTrongLuongByTen(ten);
    }
}

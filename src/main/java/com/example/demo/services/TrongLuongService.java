package com.example.demo.services;


import com.example.demo.models.TrongLuong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.UUID;

public interface TrongLuongService {
    public Page<TrongLuong> getAll(Pageable pageable);

    public Page<TrongLuong> getAll1(Pageable pageable);

    public List<TrongLuong> findAll();

    public List<TrongLuong> findAllFullTT();

    public TrongLuong findById(UUID id);

    public TrongLuong add(TrongLuong trongLuong);

    public TrongLuong update(UUID id, TrongLuong trongLuong);

    public void updateTT();

    public List<TrongLuong> search0(String ten);

    public List<TrongLuong> search1(String ten);

    TrongLuong findByMa(String ma);

    TrongLuong findByTen(String ten);
}

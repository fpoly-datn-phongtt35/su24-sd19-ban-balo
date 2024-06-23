package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Optional;

public interface UserService {
    User getByUsername(String email);

    boolean existByUsername(String email);

    User createNewUser(User user);

    User findByKhachHang_Id(Integer id);

    User findByNhanVien_Id(Integer id);

    User update(User user);

    boolean existsByEmail(String email);
}

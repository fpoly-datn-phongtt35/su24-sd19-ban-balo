package com.example.datntest.service;

import com.example.datntest.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getAccount(Integer idKhachHang);

    User findBytaiKhoanAndmatKhau(String taiKhoan, String matKhau);

    User addAccount(User user);

    User findAccountBysdt(String sdt);
}

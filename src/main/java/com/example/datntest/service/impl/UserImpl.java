package com.example.datntest.service.impl;

import com.example.datntest.entity.User;
import com.example.datntest.repository.UserRepository;
import com.example.datntest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getAccount(Integer idKhachHang) {
        return this.userRepository.findById(idKhachHang);
    }

    @Override
    public User findBytaiKhoanAndmatKhau(String taiKhoan, String matKhau) {
        return this.userRepository.findByTaiKhoanAndMatKhau(taiKhoan, matKhau);
    }


    @Override
    public User addAccount(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findAccountBysdt(String sdt) {
        return this.userRepository.findAccountBysdt(sdt);
    }
}

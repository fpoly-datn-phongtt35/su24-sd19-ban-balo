package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getAccount(Integer idNhanVien) {
        return this.userRepository.findById(idNhanVien);
    }


    @Override
    public User addAccount(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findAccountByEmail(String email) {
        return this.userRepository.findAccountByEmail(email);
    }

    @Override
    public User findByEmailAndPassword(String email, String passWord) {
        return this.userRepository.findByEmailAndPassWord(email, passWord);
    }
}

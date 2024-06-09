package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getAccount(Integer idUsers);

    User addAccount(User users);

    User findAccountByEmail(String email);

    User findByEmailAndPassword(String email, String passWord);
}

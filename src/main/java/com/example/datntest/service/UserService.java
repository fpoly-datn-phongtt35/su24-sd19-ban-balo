package com.example.datntest.service;

import com.example.datntest.entity.Users;

import java.util.Optional;

public interface UserService {
    Optional<Users> getAccount(Integer idUsers);

    Users addAccount(Users users);

    Users findAccountByEmail(String email);

    Users findByEmailAndPassword(String email, String passWord);
}

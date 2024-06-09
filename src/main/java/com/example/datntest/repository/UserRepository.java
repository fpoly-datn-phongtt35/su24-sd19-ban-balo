package com.example.datntest.repository;


import com.example.datntest.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByEmailAndPassWord(String email, String passWord);

    Users findAccountByEmail(String email);
}

package com.example.datntest.repository;


import com.example.datntest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByTaiKhoanAndMatKhau(String taiKhoan, String matKhau);

    User findAccountBysdt(String sdt);
}

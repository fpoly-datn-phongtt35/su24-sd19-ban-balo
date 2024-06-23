package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    User getUserByEmail(String email);

    boolean existsByEmail(String email);

    User findByKhachHang_Id(Integer id);

    User findByNhanVien_Id(Integer id);
}

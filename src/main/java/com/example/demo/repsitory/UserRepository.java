package com.example.demo.repsitory;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User getUserByEmail(String email);

    boolean existsByEmail(String email);

    User findByKhachHang_Id(Long id);

    User findByNhanVien_Id(Long id);
}

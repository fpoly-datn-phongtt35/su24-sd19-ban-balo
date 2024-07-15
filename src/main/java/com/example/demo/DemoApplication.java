package com.example.demo;

import com.example.demo.model.ChucVu;
import com.example.demo.model.NhanVien;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repsitory.ChucVuRepository;
import com.example.demo.repsitory.NhanVienRepository;
import com.example.demo.repsitory.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;

@SpringBootApplication
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DemoApplication {
    UserRepository userRepository;
    ChucVuRepository chucVuRepository;

    PasswordEncoder passwordEncoder;
    NhanVienRepository nhanVienRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner init() {
        return args -> {
            // Kiểm tra xem bảng user có bản ghi nào không
            if (userRepository.count() == 0) {
                // Nếu không có bản ghi, thêm một bản ghi mặc định
                User defaultUser = new User();
                defaultUser.setEmail("admin@gmail.com");
                defaultUser.setPassword(passwordEncoder.encode("123"));
                defaultUser.setRole(Role.ADMIN);
                defaultUser.setTrangThai(1);
                defaultUser.setNgayTao(new Date(System.currentTimeMillis()));
                NhanVien nhanVien = new NhanVien();
                nhanVien.setCccd("000000000000");
                nhanVien.setSdt("0999999999");
                nhanVien.setMaNhanVien("ADMIN");
                nhanVien.setTrangThai(1);
                ChucVu chucVu = chucVuRepository.getFirstByTenChucVu("Quản Lý");
                if (chucVu != null) {
                    nhanVien.setChucVu(chucVu);
                } else {
                    chucVu = new ChucVu();
                    chucVu.setTenChucVu("Quản Lý");
                    chucVu.setNgayTao(new Date(System.currentTimeMillis()));
                    chucVu = chucVuRepository.save(chucVu);
                    nhanVien.setChucVu(chucVu);
                }
                nhanVien.setTenNhanVien("Huy");
                nhanVien.setNgaySinh(new Date(2003,9,4));
                nhanVien.setSoNha("69");
                nhanVien.setPhuongXa(" Kiều Mai");
                nhanVien.setQuanHuyen("Bắc Từ Niêm");
                nhanVien.setTinhThanhPho("Hà Nội");
                nhanVienRepository.save(nhanVien);
                defaultUser.setNhanVien(nhanVien);
                userRepository.save(defaultUser);
            }
        };
    }
}

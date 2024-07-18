package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.model.NhanVien;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.sevice.KhachHangService;
import com.example.demo.sevice.NhanVienService;
import com.example.demo.sevice.UserService;
import com.example.demo.sevice.impl.NhanVienServiceImpl;
import com.example.demo.utility.MailUtility;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;

@Controller
@RequiredArgsConstructor
public class LoginRegisterController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final MailUtility mailUtility;
    private final KhachHangService khachHangService;
    private final NhanVienService nhanVienService;
    private final AuthenticationManager authenticationManager;
    private final NhanVienServiceImpl nhanVienServiceImpl;


    @GetMapping("/login")
    public String formLogin(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "Auth/login";
    }
    @GetMapping("/login-handle")
    public String afterHandleLogin(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String formRegister(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "Auth/register";
    }

    @GetMapping("/forgot-password")
    public String forgot() {
        return "Auth/forgot-password";
    }


    @PostMapping("/login-handle")
    public String login(
            @Valid @ModelAttribute LoginDto loginDto,
            BindingResult bindingResult,
            HttpServletRequest request,
            HttpSession session,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "Auth/login";
        }
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authentication);
            session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
            User user = userService.getByUsername(authentication.getName());
            if (user.getRole() != Role.CUSTOMER) {
                return "redirect:/nhan-vien/hien-thi";
            }
            return "redirect:/";
        } catch (AuthenticationException ex) {
            ex.printStackTrace();
            model.addAttribute("message", "Sai email hoặc mật khẩu !");
            return "Auth/login";
        }
    }
    @PostMapping("/register")
    @Transactional
    public String register(
            @Valid @ModelAttribute RegisterDto registerDto,
            BindingResult bindingResult,
            HttpServletRequest request,
            HttpSession session,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "Auth/register";
        }
        if (userService.existByUsername(registerDto.getEmail())) {
            model.addAttribute("email", "Email đã tồn tại!");
            return "Auth/register";
        }
        try {
            // Create or fetch NhanVien entity
            NhanVien nhanVien = new NhanVien();
            nhanVien.setTenNhanVien(registerDto.getHo() + " " + registerDto.getTenDem() + " " + registerDto.getTen());
            nhanVien.setTrangThai(1);
            nhanVien.setNgayTao(new Date(System.currentTimeMillis()));
            nhanVien.setGioiTinh(registerDto.getGioiTinh());
            nhanVien.setSdt(registerDto.getSdt());
            nhanVien.setMaNhanVien(nhanVienService.generateCustomerCode());

            // Persist NhanVien entity to ensure it's managed
            nhanVien = nhanVienService.add(nhanVien);

            // Encrypt password
            String encodedPassword = passwordEncoder.encode(registerDto.getPassword());

            // Create User entity
            User user = new User();
            user.setEmail(registerDto.getEmail());
            user.setPassword(encodedPassword);
            user.setTrangThai(1); // active
            user.setNhanVien(nhanVien); // Associate with managed NhanVien
            user.setRole(Role.USER);
            user.setNgayTao(new Date(System.currentTimeMillis()));

            // Persist User
            userService.createNewUser(user);

            // Log in the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(registerDto.getEmail(), registerDto.getPassword())
            );
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authentication);
            session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            model.addAttribute("message", "Lỗi khi tạo mới người dùng, vui lòng thử lại!");
            return "Auth/register";
        }
    }


}

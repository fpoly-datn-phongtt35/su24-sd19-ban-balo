package com.example.demo.config;

import com.example.demo.models.KhachHang;
import com.example.demo.models.NhanVien;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoUserDetails implements UserDetails {
    private String hoTen;
    private String username;
    private String password;
    private String diaChi;
    private String urlAnh;
    private boolean gioiTinh;
    private String sdt;
    private UUID id;
    private String ma;
    private String email;
    private Date ngaySinh;
    private String canCuocCongDan;


    private List<GrantedAuthority> authorities;


    public UserInfoUserDetails(Object userInfo) {


        if (userInfo instanceof NhanVien) {
            NhanVien nhanVien = (NhanVien) userInfo;
            username = nhanVien.getTaiKhoan();
            password = nhanVien.getMatKhau();
            id=nhanVien.getId();
            hoTen=nhanVien.getHoTen();
            gioiTinh=nhanVien.getGioiTinh();
            email=nhanVien.getEmail();
            sdt=nhanVien.getSdt();
            diaChi=nhanVien.getDiaChi();
            ngaySinh=nhanVien.getNgaySinh();
            canCuocCongDan =nhanVien.getCCCD();

            authorities = Arrays.stream(nhanVien.getChucVu().getTen().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }
        else if (userInfo instanceof KhachHang) {
            KhachHang khachHang = (KhachHang) userInfo;
            username = khachHang.getTaiKhoan();
            password = khachHang.getMatKhau();
            id=khachHang.getId();
            hoTen=khachHang.getHoTen();
            gioiTinh=khachHang.getGioiTinh();
            email=khachHang.getEmail();
            sdt=khachHang.getSoDienThoai();
            ngaySinh=khachHang.getNgaySinh();
            authorities = new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority("USER")));

        }
        else {
            throw new IllegalArgumentException("Unsupported user type");
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUrlAnh(){
        return urlAnh;
    }
    public UUID getId(){
        return id;
    }
    public String getHoTen(){
        return hoTen;
    }
    public String getDiaChi(){
        return diaChi;
    }
    public boolean getGioiTinh(){
        return gioiTinh;
    }
    public String getSDT(){
        return sdt;
    }
    public String getEmail(){
        return email;
    }
    public String getMa(){
        return ma;
    }
    public Date getNgaySinh(){
        return ngaySinh;
    }
    public String getCanCuoc(){
        return canCuocCongDan;
    }


}

package com.example.demo.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto {
    @NotBlank(message = "Vui lòng nhập email !")
    @Email(message = "Vui lòng nhập đúng định dạng email !")
    String email;

    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", flags = Pattern.Flag.UNICODE_CASE, message = "Vui lòng nhập đúng định dạng mật khẩu!")
    String password;

    @NotBlank(message = "Vui lòng nhập họ !")
    String ho;

    @NotBlank(message = "Vui lòng nhập tên !")
    String ten;

    @NotNull(message = "Vui lòng chọn giới tính !")
    boolean gioiTinh;

    @NotBlank(message = "Vui lòng chọn ngày sinh !")
    String ngaySinh;

    @NotBlank(message = "Vui lòng nhập số di động !")
    String sdt;
}

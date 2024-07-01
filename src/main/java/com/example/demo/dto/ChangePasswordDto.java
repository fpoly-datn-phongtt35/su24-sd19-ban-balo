package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ChangePasswordDto {
    String password;
    String newPassword;
    String confirmPassword;
}
